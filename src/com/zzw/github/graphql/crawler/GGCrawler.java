package com.zzw.github.graphql.crawler;

import com.zzw.github.graphql.crawler.execute.GGContext;

/**
 * Created by zzw on 2018/9/3.
 */
public class GGCrawler {
    public static void main(String[] args) {
        System.out.println("Start GitHub Crawler");

        int begYear = 2018; int begMonth = 1; int begDay = 1;
        int endYear = 2018; int endMonth = 1; int endDay = 2;

        GGContext context = new GGContext("C:\\Users\\zzw\\Desktop\\GGCrawler");
        context.start();

        GGSearchor searchor = new GGSearchor(context);
        searchor.doSearch(begYear, begMonth, begDay, endYear, endMonth, endDay);
    }
}
