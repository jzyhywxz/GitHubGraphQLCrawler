package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class ProjectColumnTemplate {
    public static final String PROJECT_COLUMN_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on ProjectColumn{\\n" +
            "      createdAt\\n" +
            "      databaseId\\n" +
            "      id\\n" +
            "      name\\n" +
            "      project{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      resourcePath\\n" +
            "      updatedAt\\n" +
            "      url\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";
}
