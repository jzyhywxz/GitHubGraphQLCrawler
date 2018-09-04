package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class PushTemplate {
    public static final String PUSH_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on Push{\\n" +
            "      id\\n" +
            "      nextSha\\n" +
            "      permalink\\n" +
            "      previousSha\\n" +
            "      pusher{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      repository{\\n" +
            "        id\\n" +
            "      }\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";
}
