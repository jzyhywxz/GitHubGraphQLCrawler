package com.zzw.github.graphql.crawler;

/**
 * Created by zzw on 2018/10/1.
 */
public class TestMain {
    public static void main(String[] args) {
        // search
        Main.main(new String[]{
                "-t=7f2d4f09836bd6f11ba3134ad9ceab6b66c85177",
                "-d=D:/GitHub",
                "-s=2018-02-01..2018-02-28",
        });

        // error analysis
//        Main.main(new String[]{
//                "-e=D:/GitHub/error/20181001_202812.log",
//                "-type=INFO",
//        });

        // retry
//        Main.main(new String[]{
//                "-t=7f2d4f09836bd6f11ba3134ad9ceab6b66c85177",
//                "-d=D:/GitHub",
//                "-r=D:/GitHub/retry/20181001_195238.log",
//        });
    }
}
