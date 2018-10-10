package com.zzw.github.graphql.crawler.execute;

import com.zzw.github.graphql.crawler.template.MetaTemplate;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zzw on 2018/9/1.
 */
public class GGCacheManager {
    private Set<MetaTemplate.TypeIdBean> mRecordCache = new HashSet<>();

    public synchronized Set<MetaTemplate.TypeIdBean> getRecordCacheSnapshot() {
        Set<MetaTemplate.TypeIdBean> snapshot = new HashSet<>();
        for (MetaTemplate.TypeIdBean typeIdBean : mRecordCache) {
            snapshot.add(typeIdBean);
        }
        return snapshot;
    }

    public synchronized boolean isRecordExistedInCache(Class type, String id) {
        if ((type == null) || (id == null) || mRecordCache.isEmpty()) {
            return false;
        }
        for (MetaTemplate.TypeIdBean typeIdBean : mRecordCache) {
            if (type.getName().equals(typeIdBean.getType().getName()) &&
                    id.equals(typeIdBean.getId())) {
                return true;
            }
        }
        return false;
    }

    public synchronized void addRecordIntoCache(MetaTemplate.TypeIdBean typeIdBean) {
        if (typeIdBean != null) {
            mRecordCache.add(typeIdBean);
        }
    }

    public synchronized void removeRecordFromCache(MetaTemplate.TypeIdBean typeIdBean) {
        if ((typeIdBean == null) || mRecordCache.isEmpty()) {
            return;
        }
        mRecordCache.remove(typeIdBean);
    }
}
