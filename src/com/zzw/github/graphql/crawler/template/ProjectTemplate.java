package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class ProjectTemplate {
    public static final String PROJECT_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on Project{\\n" +
            "      body\\n" +
            "      bodyHTML\\n" +
            "      closed\\n" +
            "      closedAt\\n" +
            "      createdAt\\n" +
            "      creator{\\n" +
            "        __typename\\n" +
            "        ... on Bot{\\n" +
            "          id\\n" +
            "        }\\n" +
            "        ... on Organization{\\n" +
            "          id\\n" +
            "        }\\n" +
            "        ... on User{\\n" +
            "          id\\n" +
            "        }\\n" +
            "      }\\n" +
            "      databaseId\\n" +
            "      id\\n" +
            "      name\\n" +
            "      number\\n" +
            "      owner{\\n" +
            "        __typename\\n" +
            "        ... on Organization{\\n" +
            "          id\\n" +
            "        }\\n" +
            "        ... on Repository{\\n" +
            "          id\\n" +
            "        }\\n" +
            "      }\\n" +
            "      resourcePath\\n" +
            "      state\\n" +
            "      updatedAt\\n" +
            "      url\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";
}
