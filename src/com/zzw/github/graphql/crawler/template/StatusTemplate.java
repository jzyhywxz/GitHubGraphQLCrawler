package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class StatusTemplate {
    public static final String STATUS_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on Status{\\n" +
            "      commit{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      contexts{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      id\\n" +
            "      state\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";
}
