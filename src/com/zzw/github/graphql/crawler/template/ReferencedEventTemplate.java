package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class ReferencedEventTemplate {
    public static final String REFERENCED_EVENT_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on ReferencedEvent{\\n" +
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
            "      commitRepository{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      createdAt\\n" +
            "      id\\n" +
            "      isCrossRepository\\n" +
            "      isDirectReference\\n" +
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
