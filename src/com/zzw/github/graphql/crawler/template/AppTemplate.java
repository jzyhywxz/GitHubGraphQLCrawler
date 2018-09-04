package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class AppTemplate {
    public static final String APP_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on App{\\n" +
            "      createdAt\\n" +
            "      databaseId\\n" +
            "      description\\n" +
            "      id\\n" +
            "      logoUrl\\n" +
            "      name\\n" +
            "      slug\\n" +
            "      updatedAt\\n" +
            "      url\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";
}
