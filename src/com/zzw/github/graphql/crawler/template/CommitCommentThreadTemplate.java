package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class CommitCommentThreadTemplate {
    public static final String COMMIT_COMMENT_THREAD_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on CommitCommentThread{\\n" +
            "      commit{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      id\\n" +
            "      path\\n" +
            "      position\\n" +
            "      repository{\\n" +
            "        id\\n" +
            "      }\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";
}
