package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class PullRequestReviewThreadTemplate {
    public static final String PULL_REQUEST_REVIEW_THREAD_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on PullRequestReviewThread{\\n" +
            "      id\\n" +
            "      pullRequest{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      repository{\\n" +
            "        id\\n" +
            "      }\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";
}
