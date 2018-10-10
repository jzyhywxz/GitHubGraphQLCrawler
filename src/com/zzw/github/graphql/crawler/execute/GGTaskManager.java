package com.zzw.github.graphql.crawler.execute;

import com.zzw.github.graphql.crawler.template.MetaTemplate;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by zzw on 2018/8/31.
 */
public class GGTaskManager {
    private GGContext mContext;
    private LinkedList<GGTask> mTaskQueue;
    private Semaphore mTaskSemaphore;
    private ExecutorService mExecutor;
    private Thread mTaskThread;
    private boolean mIsInterrupted;

    public GGTaskManager(GGContext context) {
        this(context, 10);
    }

    public GGTaskManager(GGContext context, int nThreads) {
        mContext = context;
        mTaskQueue = new LinkedList<>();
        mTaskSemaphore = new Semaphore(0);
        mExecutor = Executors.newFixedThreadPool(nThreads);
        mTaskThread = new GGTaskThread();
        mIsInterrupted = false;
    }

    private class GGTaskThread extends Thread {
        @Override
        public void run() {
            try {
                while (!isInterrupted()) {
                    mTaskSemaphore.acquire();
                    GGTask task = removeTaskFromQueue();
                    if (task != null) {
                        mExecutor.execute(task);
                    }

//                    int size = mContext.getCacheManager().getRecordCacheSize() + getTaskQueueSize();
//                    if (size <= 0) {
//                        mContext.stop();
//                    }
                }
            } catch (InterruptedException e) {
//                e.printStackTrace();
                setIsInterrupted(true);
            }
        }
    }

    public void start() {
        setIsInterrupted(false);
        mTaskThread.start();
    }

    public void stop() {
        setIsInterrupted(true);
        mTaskThread.interrupt();
    }

    public synchronized Set<MetaTemplate.TypeIdBean> getTaskQueueSnapshot() {
        Set<MetaTemplate.TypeIdBean> snapshot = new HashSet<>();
        for (GGTask task : mTaskQueue) {
            snapshot.add(task.getTypeIdBean());
        }
        return snapshot;
    }

    public synchronized void addTaskIntoQueue(GGTask task, boolean first) {
        if ((!getIsInterrupted()) && (task != null)) {
            if (first) {
                mTaskQueue.addFirst(task);
            } else {
                mTaskQueue.addLast(task);
            }
            mContext.addNewTask();
            mTaskSemaphore.release();
//            System.out.println("add task into queue");
        }
    }

    private synchronized GGTask removeTaskFromQueue() {
        if (!mTaskQueue.isEmpty()) {
//            System.out.println("remove task from queue");
            return mTaskQueue.removeFirst();
        } else {
            return null;
        }
    }

    private synchronized boolean getIsInterrupted() {
        return mIsInterrupted;
    }

    private synchronized void setIsInterrupted(boolean isInterrupted) {
        mIsInterrupted = isInterrupted;
    }
}
