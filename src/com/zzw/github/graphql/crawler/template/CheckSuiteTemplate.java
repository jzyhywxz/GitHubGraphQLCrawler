package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class CheckSuiteTemplate {
    public static final String CHECK_SUITE_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on CheckSuite{\\n" +
            "      branch{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      commit{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      conclusion\\n" +
            "      createdAt\\n" +
            "      databaseId\\n" +
            "      id\\n" +
            "      push{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      repository{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      status\\n" +
            "      updatedAt\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";
}
