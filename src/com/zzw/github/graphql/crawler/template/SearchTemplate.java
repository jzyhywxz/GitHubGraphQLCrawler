package com.zzw.github.graphql.crawler.template;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_CURSOR;

/**
 * Created by zzw on 2018/9/3.
 */
public class SearchTemplate {
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
    public static final String DATE_RANGE = "DATE_RANGE";

    public static final String SEARCH_REPO_FIRST =
            "{\"query\":\"query{\\n" +
            "  search(first:100,query:\\\"created:" + DATE_RANGE + "\\\",type:REPOSITORY){\\n" +
            "    edges{\\n" +
            "      cursor\\n" +
            "      node{\\n" +
            "        __typename\\n" +
            "        ... on Repository{\\n" +
            "          id\\n" +
            "        }\\n" +
            "      }\\n" +
            "    }\\n" +
            "    pageInfo{\\n" +
            "      startCursor\\n" +
            "      endCursor\\n" +
            "      hasPreviousPage\\n" +
            "      hasNextPage\\n" +
            "    }\\n" +
            "    repositoryCount\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";

    public static final String SEARCH_REPO_AFTER =
            "{\"query\":\"query{\\n" +
            "  search(first:100,query:\\\"created:" + DATE_RANGE + "\\\",type:REPOSITORY,after:\\\"" + NODE_CURSOR + "\\\"){\\n" +
            "    edges{\\n" +
            "      cursor\\n" +
            "      node{\\n" +
            "        __typename\\n" +
            "        ... on Repository{\\n" +
            "          id\\n" +
            "        }\\n" +
            "      }\\n" +
            "    }\\n" +
            "    pageInfo{\\n" +
            "      startCursor\\n" +
            "      endCursor\\n" +
            "      hasPreviousPage\\n" +
            "      hasNextPage\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";

    public static String getDateRange(int begYear, int begMonth, int begDay, int endYear, int endMonth, int endDay) {
        String begDate = getDateString(begYear, begMonth, begDay);
        String endDate = getDateString(endYear, endMonth, endDay);
        return begDate + ".." + endDate;
    }

    private static String getDateString(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        Date date = calendar.getTime();
        return SDF.format(date);
    }
}
