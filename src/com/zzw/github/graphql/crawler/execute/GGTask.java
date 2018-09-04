package com.zzw.github.graphql.crawler.execute;

import com.zzw.github.graphql.crawler.template.MetaTemplate;
import com.zzw.github.graphql.network.GGClient;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzw on 2018/8/31.
 */
public class GGTask implements Runnable {
    private GGClient mConnector;
    private GGContext mContext;
    private Class type;
    private String id;

    public GGTask(GGContext context, Class type, String id) {
        this.mConnector = GGContext.getConnector();
        this.mContext = context;
        this.type = type;
        this.id = id;
    }

    public MetaTemplate.TypeIdBean getTypeIdBean() {
        return new MetaTemplate.TypeIdBean(type, id);
    }

    @Override
    public void run() {
        // acquire
        mContext.getCacheManager().addRecordIntoCache(type, id);

        List<String> results = new ArrayList<>();

        // info query result
        String infoResult = doInfoQuery();
        if (infoResult != null) {
            results.add(infoResult);
        }

        // conn query results
        List<Field> connFields = MetaTemplate.getConnFields(type);
        if ((connFields != null) && (connFields.size() > 0)) {
            for (Field connField : connFields) {
                List<String> connResults = doConnQuery(connField);
                if ((connResults != null) && (connResults.size() > 0)) {
                    results.addAll(connResults);
                }
            }
        }

        // write to disk
        if (results.size() > 0) {
            mContext.getDiskManager().writeIntoDisk(type.getSimpleName(), id, results);
        }

        // release
        mContext.getCacheManager().removeRecordFromCache(type, id);
    }

    private String doInfoQuery() {
        String template = MetaTemplate.getInfoTemplate(type);
        if (template == null) {
            return null;
        }

        String payload = MetaTemplate.getInstanceFromTemplate(
                template,
                MetaTemplate.NODE_ID, id);

        String result = null;
        try {
            mConnector.connect(payload, true);
            result = mConnector.result();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            mConnector.disconnect();
        }

        if (MetaTemplate.isAnyErrorOccurred(result)) {
            MetaTemplate.GGError e = new MetaTemplate.GGError("INFO", payload, result);
            mContext.getLogManager().error(e.serialize());
            List<String> errorTypes = MetaTemplate.getErrorType(result);
            if ((errorTypes != null) && errorTypes.contains("RATE_LIMITED")) {
                mContext.stop();
            }
            return null;
        } else {
            addNewTasks(result);
            return result;
        }
    }

    private List<String> doConnQuery(Field connField) {
        if (connField == null) {
            return null;
        }

        String[] templates = MetaTemplate.getConnTemplates(type, connField);
        if ((templates == null) || (templates.length < 2)) {
            return null;
        }

        List<String> results = new ArrayList<>();
        String result;

        result = doFirstConnQuery(templates[0], connField);
        if (result == null) {
            return results;
        }
        results.add(result);

        boolean hasNextPage = MetaTemplate.getHasNextPage(result, connField.getName());
        String endCursor = MetaTemplate.getEndCursor(result, connField.getName());
        while (hasNextPage) {
            result = doAfterConnQuery(templates[1], connField, endCursor);
            if (result == null) {
                return results;
            }
            results.add(result);
            hasNextPage = MetaTemplate.getHasNextPage(result, connField.getName());
            endCursor = MetaTemplate.getEndCursor(result, connField.getName());
        }

        return results;
    }

    private String doFirstConnQuery(String template, Field connField) {
        if ((template == null) || (connField == null)) {
            return null;
        }

        String payload = MetaTemplate.getInstanceFromTemplate(
                template,
                MetaTemplate.NODE_ID, id,
                MetaTemplate.TYPE_NAME, type.getSimpleName(),
                MetaTemplate.FIELD_CONNECTION, connField.getName());

        String result = null;
        try {
            mConnector.connect(payload, true);
            result = mConnector.result();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            mConnector.disconnect();
        }

        if (MetaTemplate.isAnyErrorOccurred(result)) {
            MetaTemplate.GGError e = new MetaTemplate.GGError("FIRST_CONN", payload, result);
            mContext.getLogManager().error(e.serialize());
            List<String> errorTypes = MetaTemplate.getErrorType(result);
            if ((errorTypes != null) && errorTypes.contains("RATE_LIMITED")) {
                mContext.stop();
            }
            return null;
        } else {
            addNewTasks(result);
            return result;
        }
    }

    private String doAfterConnQuery(String template, Field connField, String endCursor) {
        if ((template == null) || (connField == null) || (endCursor == null)) {
            return null;
        }

        String payload = MetaTemplate.getInstanceFromTemplate(
                template,
                MetaTemplate.NODE_ID, id,
                MetaTemplate.TYPE_NAME, type.getSimpleName(),
                MetaTemplate.FIELD_CONNECTION, connField.getName(),
                MetaTemplate.NODE_CURSOR, endCursor);

        String result = null;
        try {
            mConnector.connect(payload, true);
            result = mConnector.result();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            mConnector.disconnect();
        }

        if (MetaTemplate.isAnyErrorOccurred(result)) {
            MetaTemplate.GGError e = new MetaTemplate.GGError("AFTER_CONN", payload, result);
            mContext.getLogManager().error(e.serialize());
            List<String> errorTypes = MetaTemplate.getErrorType(result);
            if ((errorTypes != null) && errorTypes.contains("RATE_LIMITED")) {
                mContext.stop();
            }
            return null;
        } else {
            addNewTasks(result);
            return result;
        }
    }

    private void addNewTasks(String result) {
        if (result == null) {
            return;
        }

        List<MetaTemplate.TypeIdBean> typeIdBeans = MetaTemplate.getInfoNodeIds(result);
        if ((typeIdBeans == null) || typeIdBeans.isEmpty()) {
            return;
        }

        for (MetaTemplate.TypeIdBean typeIdBean : typeIdBeans) {
            Class type = typeIdBean.getType();
            String id = typeIdBean.getId();
            if (mContext.getCacheManager().isRecordExistedInCache(type, id)) {
                continue;
            }
            if (mContext.getDiskManager().isRecordExistedInDisk(type, id)) {
                continue;
            }
//            System.out.println(typeIdBean);
            mContext.getTaskManager().addTaskIntoQueue(new GGTask(mContext, type, id));
        }
    }
}
