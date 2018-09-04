package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class PullRequestReviewCommentTemplate {
    public static final String PULL_REQUEST_REVIEW_COMMENT_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on PullRequestReviewComment{\\n" +
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
            "      diffHunk\\n" +
            "      draftedAt\\n" +
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
            "      originalCommit{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      originalPosition\\n" +
            "      path\\n" +
            "      position\\n" +
            "      publishedAt\\n" +
            "      pullRequest{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      pullRequestReview{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      reactionGroups{\\n" +
            "        content\\n" +
            "        createdAt\\n" +
            "        viewerHasReacted\\n" +
            "      }\\n" +
            "      replyTo{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      repository{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      resourcePath\\n" +
            "      updatedAt\\n" +
            "      url\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";
}
