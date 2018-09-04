package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_CURSOR;
import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class PullRequestTemplate {
    public static final String PULL_REQUEST_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on PullRequest{\\n" +
            "      activeLockReason\\n" +
            "      additions\\n" +
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
            "      baseRef{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      baseRefName\\n" +
            "      baseRefOid\\n" +
            "      body\\n" +
            "      bodyHTML\\n" +
            "      bodyText\\n" +
            "      changedFiles\\n" +
            "      closed\\n" +
            "      closedAt\\n" +
            "      createdAt\\n" +
            "      createdViaEmail\\n" +
            "      databaseId\\n" +
            "      deletions\\n" +
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
            "      headRef{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      headRefName\\n" +
            "      headRefOid\\n" +
            "      headRepository{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      headRepositoryOwner{\\n" +
            "        __typename\\n" +
            "        ... on Organization{\\n" +
            "          id\\n" +
            "        }\\n" +
            "        ... on User{\\n" +
            "          id\\n" +
            "        }\\n" +
            "      }\\n" +
            "      id\\n" +
            "      includesCreatedEdit\\n" +
            "      isCrossRepository\\n" +
            "      lastEditedAt\\n" +
            "      locked\\n" +
            "      maintainerCanModify\\n" +
            "      mergeCommit{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      mergeable\\n" +
            "      merged\\n" +
            "      mergedAt\\n" +
            "      mergedBy{\\n" +
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
            "      milestone{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      number\\n" +
            "      permalink\\n" +
            "      potentialMergeCommit{\\n" +
            "        id\\n" +
            "      }\\n" +
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
            "      revertResourcePath\\n" +
            "      revertUrl\\n" +
            "      state\\n" +
            "      suggestedReviewers{\\n" +
            "        isAuthor\\n" +
            "        isCommenter\\n" +
            "        reviewer{\\n" +
            "          id\\n" +
            "        }\\n" +
            "      }\\n" +
            "      title\\n" +
            "      updatedAt\\n" +
            "      url\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";

    public static final String TIMELINE_FIRST = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on PullRequest{\\n" +
            "      timeline(first:100){\\n" +
            "        edges{\\n" +
            "          cursor\\n" +
            "          node{\\n" +
            "            __typename\\n" +
            "            ... on AssignedEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on BaseRefForcePushedEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on ClosedEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on Commit{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on CommitCommentThread{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on CrossReferencedEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on DemilestonedEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on DeployedEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on DeploymentEnvironmentChangedEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on HeadRefDeletedEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on HeadRefForcePushedEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on HeadRefRestoredEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on IssueComment{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on LabeledEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on LockedEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on MergedEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on MilestonedEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on PullRequestReview{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on PullRequestReviewComment{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on PullRequestReviewThread{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on ReferencedEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on RenamedTitleEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on ReopenedEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on ReviewDismissedEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on ReviewRequestRemovedEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on ReviewRequestedEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on SubscribedEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on UnassignedEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on UnlabeledEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on UnlockedEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on UnsubscribedEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "          }\\n" +
            "        }\\n" +
            "        pageInfo{\\n" +
            "          startCursor\\n" +
            "          endCursor\\n" +
            "          hasPreviousPage\\n" +
            "          hasNextPage\\n" +
            "        }\\n" +
            "        totalCount\\n" +
            "      }\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";

    public static final String TIMELINE_AFTER = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on PullRequest{\\n" +
            "      timeline(first:100,after:\\\"" + NODE_CURSOR + "\\\"){\\n" +
            "        edges{\\n" +
            "          cursor\\n" +
            "          node{\\n" +
            "            __typename\\n" +
            "            ... on AssignedEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on BaseRefForcePushedEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on ClosedEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on Commit{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on CommitCommentThread{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on CrossReferencedEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on DemilestonedEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on DeployedEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on DeploymentEnvironmentChangedEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on HeadRefDeletedEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on HeadRefForcePushedEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on HeadRefRestoredEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on IssueComment{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on LabeledEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on LockedEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on MergedEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on MilestonedEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on PullRequestReview{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on PullRequestReviewComment{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on PullRequestReviewThread{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on ReferencedEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on RenamedTitleEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on ReopenedEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on ReviewDismissedEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on ReviewRequestRemovedEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on ReviewRequestedEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on SubscribedEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on UnassignedEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on UnlabeledEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on UnlockedEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "            ... on UnsubscribedEvent{\\n" +
            "              id\\n" +
            "            }\\n" +
            "          }\\n" +
            "        }\\n" +
            "        pageInfo{\\n" +
            "          startCursor\\n" +
            "          endCursor\\n" +
            "          hasPreviousPage\\n" +
            "          hasNextPage\\n" +
            "        }\\n" +
            "      }\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";
}
