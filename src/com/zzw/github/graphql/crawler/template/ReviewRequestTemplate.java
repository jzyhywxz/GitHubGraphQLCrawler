package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class ReviewRequestTemplate {
    public static final String REVIEW_REQUEST_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on ReviewRequest{\\n" +
            "      databaseId\\n" +
            "      id\\n" +
            "      pullRequest{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      requestedReviewer{\\n" +
            "        __typename\\n" +
            "        ... on Team{\\n" +
            "          id\\n" +
            "        }\\n" +
            "        ... on User{\\n" +
            "          id\\n" +
            "        }\\n" +
            "      }\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";
}
