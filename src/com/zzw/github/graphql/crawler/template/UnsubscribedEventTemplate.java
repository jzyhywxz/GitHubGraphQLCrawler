package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class UnsubscribedEventTemplate {
    public static final String UNSUBSCRIBED_EVENT_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on UnsubscribedEvent{\\n" +
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
            "      id\\n" +
            "      subscribable{\\n" +
            "        __typename\\n" +
            "        ... on Commit{\\n" +
            "          id\\n" +
            "        }\\n" +
            "        ... on Issue{\\n" +
            "          id\\n" +
            "        }\\n" +
            "        ... on PullRequest{\\n" +
            "          id\\n" +
            "        }\\n" +
            "        ... on Repository{\\n" +
            "          id\\n" +
            "        }\\n" +
            "        ... on Team{\\n" +
            "          id\\n" +
            "        }\\n" +
            "        ... on TeamDiscussion{\\n" +
            "          id\\n" +
            "        }\\n" +
            "      }\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";
}
