package com.zzw.github.graphql.crawler.execute;

import com.zzw.github.graphql.crawler.template.MetaTemplate;
import com.zzw.tools.io.OkTextReader;
import com.zzw.tools.io.OkTextWriter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zzw on 2018/9/1.
 */
public class GGLogManager {
    private static final SimpleDateFormat SDF1 = new SimpleDateFormat("yyyyMMdd_HHmmss");
    private static final SimpleDateFormat SDF2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private String mRootPath;
    private OkTextWriter mInfoLogger = new OkTextWriter();
    private OkTextWriter mErrorLogger = new OkTextWriter();

    public GGLogManager(String rootPath) {
        mRootPath = rootPath;
    }

    public void open() {
        String datetime = SDF1.format(new Date());
        mInfoLogger.open(mRootPath + File.separator + "info" + File.separator + datetime + ".log");
        mErrorLogger.open(mRootPath + File.separator + "error" + File.separator + datetime + ".log");
    }

    public void close() {
        mInfoLogger.close();
        mErrorLogger.close();
    }

    public synchronized void error(String msg) {
        if ((msg != null) && (msg.length() > 0)) {
            long ms = System.currentTimeMillis();
            String datetime = SDF2.format(new Date(ms));
            mErrorLogger.printf("%s(%d) %s\n", datetime, ms, msg);
        }
    }

    public synchronized void info(String msg) {
        if ((msg != null) && (msg.length() > 0)) {
            long ms = System.currentTimeMillis();
            String datetime = SDF2.format(new Date(ms));
            mInfoLogger.printf("%s(%d) %s\n", datetime, ms, msg);
        }
    }

    @Override
    public void finalize() {
        mInfoLogger.close();
        mErrorLogger.close();
    }

    public static List<MetaTemplate.TypeIdBean> parseInfoLog(String path) {
        if (path == null) {
            return null;
        }

        List<MetaTemplate.TypeIdBean> typeIdBeans = new ArrayList<>();

        OkTextReader reader = new OkTextReader();
        reader.open(path);
        String line;
        while ((line = reader.readLine()) != null) {
            String content = line.substring(35);
            if (content.startsWith("[CACHE] ") || content.startsWith("[QUEUE] ")) {
                String s = content.substring(8);
                typeIdBeans.add(MetaTemplate.TypeIdBean.deserialize(s));
            }
        }
        reader.close();

        return typeIdBeans;
    }

    public static List<MetaTemplate.GGError> parseErrorLog(String path) {
        if (path == null) {
            return null;
        }

        List<MetaTemplate.GGError> errors = new ArrayList<>();

        OkTextReader reader = new OkTextReader();
        reader.open(path);
        String line;
        while ((line = reader.readLine()) != null) {
            String content = line.substring(35);
            errors.add(MetaTemplate.GGError.deserialize(content));
        }
        reader.close();

        return errors;
    }
}
