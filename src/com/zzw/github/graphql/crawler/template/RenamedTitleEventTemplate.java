package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class RenamedTitleEventTemplate {
    public static final String RENAMED_TITLE_EVENT_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on RenamedTitleEvent{\\n" +
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
            "      createdAt\\n" +
            "      currentTitle\\n" +
            "      id\\n" +
            "      previousTitle\\n" +
            "      subject{\\n" +
            "        __typename\\n" +
            "        ... on Issue{\\n" +
            "          id\\n" +
            "        }\\n" +
            "        ... on PullRequest{\\n" +
            "          id\\n" +
            "        }\\n" +
            "      }\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";
}
