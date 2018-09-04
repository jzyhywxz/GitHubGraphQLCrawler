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
        if ((type == null) || (id == null)) {
            return false;
        }
        MetaTemplate.TypeIdBean typeIdBean = new MetaTemplate.TypeIdBean(type, id);
        return mRecordCache.contains(typeIdBean);
    }

    public synchronized void addRecordIntoCache(Class type, String id) {
        if ((type == null) || (id == null)) {
            return;
        }
        MetaTemplate.TypeIdBean typeIdBean = new MetaTemplate.TypeIdBean(type, id);
        mRecordCache.add(typeIdBean);
    }

    public synchronized void removeRecordFromCache(Class type, String id) {
        if ((type == null) || (id == null)) {
            return;
        }
        MetaTemplate.TypeIdBean typeIdBean = new MetaTemplate.TypeIdBean(type, id);
        mRecordCache.remove(typeIdBean);
    }
}
