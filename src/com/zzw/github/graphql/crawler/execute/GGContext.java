package com.zzw.github.graphql.crawler.execute;

import com.zzw.github.graphql.crawler.template.MetaTemplate;
import com.zzw.github.graphql.network.GGClient;

import java.util.Set;

/**
 * Created by zzw on 2018/8/31.
 */
public class GGContext {
    private String accessToken;
    private String rootPath;
    private GGCacheManager cacheManager;
    private GGDiskManager diskManager;
    private GGLogManager logManager;
    private GGTaskManager taskManager;
    private boolean isRunning;
    private int totalTaskNum = 0;
    private int completedTaskNum = 0;

    public GGContext(String accessToken, String rootPath) {
        this.accessToken = accessToken;
        this.rootPath = rootPath;
        this.cacheManager = new GGCacheManager();
        this.diskManager = new GGDiskManager(this, rootPath);
        this.logManager = new GGLogManager(rootPath);
        this.taskManager = new GGTaskManager(this);
        this.isRunning = false;
    }

    public synchronized void start() {
        if (isRunning) {
            return;
        }
        logManager.open();
        taskManager.start();
        logManager.info("[START] application");
        isRunning = true;
    }

    public synchronized void stop() {
        if (!isRunning) {
            return;
        }
        taskManager.stop();
        Set<MetaTemplate.TypeIdBean> recordCacheSnapshot = cacheManager.getRecordCacheSnapshot();
        for (MetaTemplate.TypeIdBean typeIdBean : recordCacheSnapshot) {
            logManager.info("[CACHE] " + typeIdBean.serialize());
        }
        Set<MetaTemplate.TypeIdBean> taskQueueSnapshot = taskManager.getTaskQueueSnapshot();
        for (MetaTemplate.TypeIdBean typeIdBean : taskQueueSnapshot) {
            logManager.info("[QUEUE] " + typeIdBean.serialize());
        }
        logManager.info("[STOP] application");
        logManager.close();
        isRunning = false;

        System.out.println("Application is finished");
        System.exit(0);
    }

    @Override
    protected void finalize() {
        stop();
    }

    public synchronized void addNewTask() { ++totalTaskNum; }
    public synchronized void completeTask() { ++completedTaskNum; }
    public synchronized int getTotalTaskNum() { return totalTaskNum; }
    public synchronized int getCompletedTaskNum() { return completedTaskNum; }

    public String getRootPath() { return rootPath; }

    public GGCacheManager getCacheManager() {
        return cacheManager;
    }

    public GGDiskManager getDiskManager() {
        return diskManager;
    }

    public GGLogManager getLogManager() {
        return logManager;
    }

    public GGTaskManager getTaskManager() {
        return taskManager;
    }

    public synchronized GGClient getConnector() {
        return new GGClient("https://api.github.com/graphql", accessToken);
    }
}
