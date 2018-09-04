package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class PullRequestCommitTemplate {
    public static final String PULL_REQUEST_COMMIT_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on PullRequestCommit{\\n" +
            "      commit{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      id\\n" +
            "      pullRequest{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      resourcePath\\n" +
            "      url\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";
}
