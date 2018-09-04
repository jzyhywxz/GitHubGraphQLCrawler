package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class CommitCommentTemplate {
    public static final String COMMIT_COMMENT_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on CommitComment{\\n" +
            "      author{\\n" +
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
            "      authorAssociation\\n" +
            "      body\\n" +
            "      bodyHTML\\n" +
            "      bodyText\\n" +
            "      commit{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      createdAt\\n" +
            "      createdViaEmail\\n" +
            "      databaseId\\n" +
            "      editor{\\n" +
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
            "      id\\n" +
            "      includesCreatedEdit\\n" +
            "      lastEditedAt\\n" +
            "      path\\n" +
            "      position\\n" +
            "      publishedAt\\n" +
            "      reactionGroups{\\n" +
            "        content\\n" +
            "        createdAt\\n" +
            "        viewerHasReacted\\n" +
            "      }\\n" +
            "      repository{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      resourcePath\\n" +
            "      updatedAt\\n" +
            "      url\\n" +
            "    }\\n" +
            "  }\\n" + "}\",\"variables\":\"{}\"}";
}
