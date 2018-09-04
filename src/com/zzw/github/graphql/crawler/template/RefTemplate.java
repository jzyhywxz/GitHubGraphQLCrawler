package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class RefTemplate {
    public static final String REF_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on Ref{\\n" +
            "      id\\n" +
            "      name\\n" +
            "      prefix\\n" +
            "      repository{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      target{\\n" +
            "        __typename\\n" +
            "        ... on Blob{\\n" +
            "          id\\n" +
            "        }\\n" +
            "        ... on Commit{\\n" +
            "          id\\n" +
            "        }\\n" +
            "        ... on Tag{\\n" +
            "          id\\n" +
            "        }\\n" +
            "        ... on Tree{\\n" +
            "          id\\n" +
            "        }\\n" +
            "      }\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";
}
