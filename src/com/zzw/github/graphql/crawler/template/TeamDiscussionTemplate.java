package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class TeamDiscussionTemplate {
    public static final String TEAM_DISCUSSION_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on TeamDiscussion{\\n" +
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
            "      bodyVersion\\n" +
            "      commentsResourcePath\\n" +
            "      commentsUrl\\n" +
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
            "      isPinned\\n" +
            "      isPrivate\\n" +
            "      lastEditedAt\\n" +
            "      number\\n" +
            "      publishedAt\\n" +
            "      reactionGroups{\\n" +
            "        content\\n" +
            "        createdAt\\n" +
            "        viewerHasReacted\\n" +
            "      }\\n" +
            "      resourcePath\\n" +
            "      team{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      title\\n" +
            "      updatedAt\\n" +
            "      url\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";
}
