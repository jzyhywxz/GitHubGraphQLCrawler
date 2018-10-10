package com.zzw.github.graphql.crawler;

import com.zzw.github.graphql.crawler.execute.GGContext;
import com.zzw.github.graphql.crawler.execute.GGTask;
import com.zzw.github.graphql.crawler.template.MetaTemplate;
import com.zzw.github.graphql.crawler.template.SearchTemplate;
import com.zzw.github.graphql.network.GGClient;
import com.zzw.github.graphql.parser.GGParser;
import com.zzw.github.graphql.schema.queries.QueryEntry;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzw on 2018/9/30.
 */
public class GGSearcher {
    private GGContext mContext;
    private GGClient mConnector;

    public GGSearcher(GGContext context) {
        this.mContext = context;
        this.mConnector = context.getConnector();
    }

    public void doSearch(String dateRange) {
        if (dateRange == null) {
            return;
        }
        List<String> results = new ArrayList<>();

        // first search
        String result = doFirstSearch(dateRange);
        results.add(result);
        Object[] pageInfo = getPageInfo(result);
        if (pageInfo == null || pageInfo.length < 2) {
            return;
        }
        boolean hasNextPage = (Boolean) pageInfo[0];
        String endCursor = (String) pageInfo[1];

        // after search
        while (hasNextPage) {
            result = doAfterSearch(dateRange, endCursor);
            results.add(result);
            pageInfo = getPageInfo(result);
            if (pageInfo == null || pageInfo.length < 2) {
                break;
            }
            hasNextPage = (Boolean) pageInfo[0];
            endCursor = (String) pageInfo[1];
        }

        mContext.getDiskManager().writeIntoDisk("Search", dateRange, results);
    }

    public void doSearch(
            int begYear, int begMonth, int begDay,
            int endYear, int endMonth, int endDay) {
        String dateRange = SearchTemplate.getDateRange(begYear, begMonth, begDay, endYear, endMonth, endDay);
        doSearch(dateRange);
    }

    private String doFirstSearch(String dateRange) {
        String payload = MetaTemplate.getInstanceFromTemplate(
                SearchTemplate.SEARCH_REPO_FIRST,
                SearchTemplate.DATE_RANGE, dateRange);
        String result = null;
        try {
            mConnector.connect(payload, true);
            result = mConnector.result();
        } catch (IOException e) {
//            e.printStackTrace();
        } finally {
            mConnector.disconnect();
        }

        if (MetaTemplate.isAnyErrorOccurred(result)) {
            MetaTemplate.GGError e = new MetaTemplate.GGError("FIRST_SEARCH", payload, result);
            throw new NullPointerException(e.serialize());
        } else {
            addNewTasks(result);
            return result;
        }
    }

    private String doAfterSearch(String dateRange, String endCursor) {
        String payload = MetaTemplate.getInstanceFromTemplate(
                SearchTemplate.SEARCH_REPO_FIRST,
                SearchTemplate.DATE_RANGE, dateRange,
                MetaTemplate.NODE_CURSOR, endCursor);
        String result = null;
        try {
            mConnector.connect(payload, true);
            result = mConnector.result();
        } catch (IOException e) {
//            e.printStackTrace();
        } finally {
            mConnector.disconnect();
        }

        if (MetaTemplate.isAnyErrorOccurred(result)) {
            MetaTemplate.GGError e = new MetaTemplate.GGError("AFTER_SEARCH", payload, result);
            throw new NullPointerException(e.serialize());
        } else {
            addNewTasks(result);
            return result;
        }
    }

    private void addNewTasks(String result) {
        QueryEntry entry = GGParser.fromJson(result, QueryEntry.class);

        Object[] edges = GGParser.get(entry, QueryEntry.class, "data/search/edges");
        if (edges == null || edges.length < 2) {
            throw new NullPointerException(result);
        }
        Class edgeComponentType = ((Class) edges[0]).getComponentType();
        Object edgesValue = edges[1];

        Object[] node0 = GGParser.get(entry, QueryEntry.class, "data/search/edges[0]/node");
        if (node0 == null || node0.length < 2) {
            throw new NullPointerException(result);
        }
        Class nodeType = (Class) node0[0];

        int length = Array.getLength(edgesValue);
        for (int i = 0; i < length; i++) {
            Object edgeComponentValue = Array.get(edgesValue, i);

            Object[] nodeId = GGParser.get(edgeComponentValue, edgeComponentType, "node/id/value");
            if (nodeId == null || nodeId.length < 2) {
                throw new NullPointerException(result);
            }
            String nodeIdValue = (String) nodeId[1];

            if (mContext.getCacheManager().isRecordExistedInCache(nodeType, nodeIdValue)) {
                continue;
            }
            if (mContext.getDiskManager().isRecordExistedInDisk(nodeType, nodeIdValue)) {
                continue;
            }
            mContext.getTaskManager().addTaskIntoQueue(new GGTask(mContext, nodeType, nodeIdValue), false);
        }
    }

    private Object[] getPageInfo(String result) {
        QueryEntry entry = GGParser.fromJson(result, QueryEntry.class);

        Object[] hasNextPage = GGParser.get(entry, QueryEntry.class, "data/search/pageInfo/hasNextPage/value");
        if (hasNextPage == null || hasNextPage.length < 2) {
            return null;
        }
        boolean hasNextPageValue = (hasNextPage[1] == null) ? false : (Boolean) hasNextPage[1];

        Object[] endCursor = GGParser.get(entry, QueryEntry.class, "data/search/pageInfo/endCursor/value");
        if (endCursor == null || endCursor.length < 2) {
            return null;
        }
        String endCursorValue = (String) endCursor[1];

        return new Object[]{ hasNextPageValue, endCursorValue };
    }
}
