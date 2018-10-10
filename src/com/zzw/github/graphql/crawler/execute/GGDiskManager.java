package com.zzw.github.graphql.crawler.execute;

import com.zzw.tools.io.OkTextWriter;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zzw on 2018/9/1.
 */
public class GGDiskManager {
    private String mRootPath;
    private GGContext mContext;
    private LinkedList<OkTextWriter> mWriterPool = new LinkedList<>();

    public GGDiskManager(GGContext context, String rootPath) {
        this(context, rootPath, 10);
    }

    public GGDiskManager(GGContext context, String rootPath, int initNum) {
        mContext = context;
        mRootPath = rootPath;
        for (int i = 0; i < initNum; i++) {
            mWriterPool.addLast(new OkTextWriter());
        }
    }

    public synchronized boolean isRecordExistedInDisk(Class type, String id) {
        if ((type == null) || (id == null)) {
            return false;
        }

        String path = mRootPath + File.separator + type.getSimpleName() + File.separator + id + ".json";
        return (new File(path)).exists();
    }

    public void writeIntoDisk(String typeName, String id, List<String> results) {
        if ((typeName == null) || (id == null) || (results == null) || results.isEmpty()) {
            return;
        }

        String path = mRootPath + File.separator + typeName + File.separator + id + ".json";

        OkTextWriter writer = takeOutWriter();
        writer.open(path);
        for (String result : results) {
            writer.println(result);
        }
        writer.close();
        putBackWriter(writer);
    }

    private synchronized OkTextWriter takeOutWriter() {
        if (mWriterPool.isEmpty()) {
            return new OkTextWriter();
        } else {
            return mWriterPool.removeFirst();
        }
    }

    private synchronized void putBackWriter(OkTextWriter writer) {
        if (writer != null) {
            mWriterPool.addLast(writer);
        }
    }
}
