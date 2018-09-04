package com.zzw.github.graphql.crawler.execute;

import com.zzw.github.graphql.crawler.template.MetaTemplate;
import com.zzw.github.graphql.network.GGClient;
import com.zzw.tools.io.OkTextReader;

import java.util.Set;

/**
 * Created by zzw on 2018/8/31.
 */
public class GGContext {
    private GGCacheManager cacheManager;
    private GGDiskManager diskManager;
    private GGLogManager logManager;
    private GGTaskManager taskManager;
    private boolean isRunning;

    public GGContext(String rootPath) {
        cacheManager = new GGCacheManager();
        diskManager = new GGDiskManager(rootPath);
        logManager = new GGLogManager(rootPath);
        taskManager = new GGTaskManager();
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
            logManager.info("[CACHE] " + typeIdBean.toJson());
        }
        Set<MetaTemplate.TypeIdBean> taskQueueSnapshot = taskManager.getTaskQueueSnapshot();
        for (MetaTemplate.TypeIdBean typeIdBean : taskQueueSnapshot) {
            logManager.info("[QUEUE] " + typeIdBean.toJson());
        }
        logManager.info("[STOP] application");
        logManager.close();
        isRunning = false;

        System.exit(0);
    }

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

    public static GGClient getConnector() {
        String rootEndPoint = "https://api.github.com/graphql";
        OkTextReader reader = new OkTextReader();
        reader.open("F:\\JetBrains\\IntelliJIdea\\access_token.txt");
        String accessToken = reader.readLine();
        reader.close();
        return new GGClient(rootEndPoint, accessToken);
    }
}
