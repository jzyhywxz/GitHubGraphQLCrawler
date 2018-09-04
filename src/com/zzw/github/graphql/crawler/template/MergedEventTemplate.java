package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class MergedEventTemplate {
    public static final String MERGED_EVENT_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on MergedEvent{\\n" +
            "      actor{\\n" +
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
            "      commit{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      createdAt\\n" +
            "      id\\n" +
            "      mergeRef{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      mergeRefName\\n" +
            "      pullRequest{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      resourcePath\\n" +
            "      url\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";
}
