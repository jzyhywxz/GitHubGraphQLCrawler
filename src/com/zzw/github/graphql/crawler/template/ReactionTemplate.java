package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class ReactionTemplate {
    public static final String REACTION_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on Reaction{\\n" +
            "      content\\n" +
            "      createdAt\\n" +
            "      databaseId\\n" +
            "      id\\n" +
            "      reactable{\\n" +
            "        __typename\\n" +
            "        ... on CommitComment{\\n" +
            "          id\\n" +
            "        }\\n" +
            "        ... on Issue{\\n" +
            "          id\\n" +
            "        }\\n" +
            "        ... on IssueComment{\\n" +
            "          id\\n" +
            "        }\\n" +
            "        ... on PullRequest{\\n" +
            "          id\\n" +
            "        }\\n" +
            "        ... on PullRequestReviewComment{\\n" +
            "          id\\n" +
            "        }\\n" +
            "        ... on TeamDiscussion{\\n" +
            "          id\\n" +
            "        }\\n" +
            "        ... on TeamDiscussionComment{\\n" +
            "          id\\n" +
            "        }\\n" +
            "      }\\n" +
            "      user{\\n" +
            "        id\\n" +
            "      }\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";
}
