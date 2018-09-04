package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class ReviewDismissedEventTemplate {
    public static final String REVIEW_DISMISSED_EVENT_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on ReviewDismissedEvent{\\n" +
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
            "      databaseId\\n" +
            "      id\\n" +
            "      message\\n" +
            "      messageHtml\\n" +
            "      previousReviewState\\n" +
            "      pullRequest{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      pullRequestCommit{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      resourcePath\\n" +
            "      review{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      url\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";
}
