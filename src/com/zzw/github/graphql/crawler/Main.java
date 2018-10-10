package com.zzw.github.graphql.crawler;

import com.zzw.github.graphql.crawler.execute.GGContext;
import com.zzw.github.graphql.crawler.execute.GGLogManager;
import com.zzw.github.graphql.crawler.execute.GGTask;
import com.zzw.github.graphql.crawler.template.MetaTemplate;
import com.zzw.github.graphql.parser.GGParser;
import com.zzw.github.graphql.schema.Error;
import com.zzw.github.graphql.schema.queries.QueryEntry;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

/**
 * Created by zzw on 2018/10/1.
 */
public class Main {
    public static void main(String[] args) {
        if (args == null || args.length <= 0) {
            printUsage();
            System.exit(-1);
        }

        String accessToken = null;
        String directory = null;
        String infoFilePath = null;
        String dateInterval = null;
        String errorFilePath = null;
        String errorType = null;
        String retryFilePath = null;
        for (String arg : args) {
            String[] info = arg.split("=");
            if (info == null || info.length < 2) {
                continue;
            }
            if (info[0].equals("-t")) {
                accessToken = info[1];
            } else if (info[0].equals("-d")) {
                directory = info[1];
                if (directory.endsWith("/") || directory.endsWith("\\")) {
                    directory = directory.substring(0, directory.length() - 1);
                }
            } else if (info[0].equals("-i")) {
                infoFilePath = info[1];
            } else if (info[0].equals("-s")) {
                dateInterval = info[1];
            } else if (info[0].equals("-e")) {
                errorFilePath = info[1];
            } else if (info[0].equals("-type")) {
                errorType = info[1];
                if ((!errorType.equals("INFO")) &&
                        (!errorType.equals("FIRST_CONN")) &&
                        (!errorType.equals("AFTER_CONN"))) {
                    errorType = null;
                }
            } else if (info[0].equals("-r")) {
                retryFilePath = info[1];
            } else {
                printUsage();
                System.exit(-1);
            }
        }

        if (errorFilePath != null) {
            List<MetaTemplate.GGError> ggErrors = GGLogManager.parseErrorLog(errorFilePath);
            if (ggErrors == null || ggErrors.isEmpty()) {
                return;
            }
            for (MetaTemplate.GGError ggError : ggErrors) {
                if ((errorType != null) && (!errorType.equals(ggError.getType()))) {
                    continue;
                }
                Error[] errors = MetaTemplate.GGError.getErrors(ggError.getRespond());
                List<String> errorTypes = MetaTemplate.GGError.getErrorTypes(errors);
                if (MetaTemplate.GGError.isIgnorableErrorType(errorTypes)) {
                    continue;
                }
                List<String> errorMassages = MetaTemplate.GGError.getErrorMassages(errors);
                if (MetaTemplate.GGError.isIgnorableErrorMassage(errorMassages)) {
                    continue;
                }
                System.out.println("type:" + ggError.getType() + ", require:" + ggError.getRequire() + ", respond:" + ggError.getRespond());
            }
            return;
        }

        GGContext context = new GGContext(accessToken, directory);
        context.start();

        System.out.println("Application is starting");

        if (retryFilePath != null) {
            System.out.println("Retrying the failed tasks: " + retryFilePath);
            List<MetaTemplate.TypeIdBean> typeIdBeans = GGLogManager.parseRetryLog(retryFilePath);
            if (typeIdBeans == null || typeIdBeans.isEmpty()) {
                return;
            }

            for (MetaTemplate.TypeIdBean typeIdBean : typeIdBeans) {
                String path = context.getRootPath() + File.separator +
                        typeIdBean.getType().getSimpleName() + File.separator +
                        typeIdBean.getId() + ".json";
                File file = new File(path);
                if (file.exists()) {
                    System.out.println("delete " + path);
                    file.delete();
                }
            }

            for (MetaTemplate.TypeIdBean typeIdBean : typeIdBeans) {
                Class type = typeIdBean.getType();
                String id = typeIdBean.getId();
                if (context.getCacheManager().isRecordExistedInCache(type, id)) {
                    continue;
                }
                if (context.getDiskManager().isRecordExistedInDisk(type, id)) {
                    continue;
                }
                context.getTaskManager().addTaskIntoQueue(new GGTask(context, type, id), true);
            }
            return;
        }

        if (infoFilePath != null) {
            System.out.println("Continuing uncompleted tasks: " + infoFilePath);
            List<MetaTemplate.TypeIdBean> typeIdBeans = GGLogManager.parseInfoLog(infoFilePath);
            if (typeIdBeans == null || typeIdBeans.isEmpty()) {
                return;
            }
            for (MetaTemplate.TypeIdBean typeIdBean : typeIdBeans) {
                Class type = typeIdBean.getType();
                String id = typeIdBean.getId();
                if (context.getCacheManager().isRecordExistedInCache(type, id)) {
                    continue;
                }
                if (context.getDiskManager().isRecordExistedInDisk(type, id)) {
                    continue;
                }
                context.getTaskManager().addTaskIntoQueue(new GGTask(context, type, id), true);
            }
            return;
        }

        if (dateInterval != null) {
            System.out.println("Searching repositories created during " + dateInterval);
            GGSearcher searcher = new GGSearcher(context);
            searcher.doSearch(dateInterval);
        }

//        int begYear = 2018, begMonth = 1, begDay = 1;
//        int endYear = 2018, endMonth = 1, endDay = 2;
//        GGSearcher searcher = new GGSearcher(context);
//        searcher.doSearch(begYear, begMonth, begDay, endYear, endMonth, endDay);
    }

    private static void printUsage() {
        System.out.println("========================== Usage ==========================");
        System.out.println("   Command                      Description");
        System.out.println("-t=<TOKEN>      your access token applied from GitHub.");
        System.out.println("-d=<DIRECTORY>  the directory to store all of the data.");
        System.out.println("-i=<INFO>       the path of information file which holds");
        System.out.println("                uncompleted task items.");
        System.out.println("-s=<DATE>       the \"<DATE>\", which is a \"SimpleDateFormat\"-");
        System.out.println("                style string, indicates the creation date of");
        System.out.println("                repositories. The format of \"<DATE>\" is");
        System.out.println("                \"yyyy-MM-dd..yyyy-MM-dd\", and the former is");
        System.out.println("                earlier than the latter.");
        System.out.println("-e=<ERROR>      the path of error file which holds errors");
        System.out.println("                occurred during application running.");
        System.out.println("-type=<TYPE>    the filter used to only show the errors with");
        System.out.println("                the corresponding type. The value of \"<TYPE>\"");
        System.out.println("                is one of the \"INFO\", \"FIRST_CONN\", \"AFTER_CONN\".");
        System.out.println("-r=<RETRY>      the path of retry file which holds retry task items.");
    }
}
