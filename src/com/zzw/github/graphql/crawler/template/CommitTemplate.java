package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class CommitTemplate {
    public static final String COMMIT_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on Commit{\\n" +
            "      abbreviatedOid\\n" +
            "      additions\\n" +
            "      author{\\n" +
            "        avatarUrl\\n" +
            "        date\\n" +
            "        email\\n" +
            "        name\\n" +
            "        user{\\n" +
            "          id\\n" +
            "        }\\n" +
            "      }\\n" +
            "      authoredByCommitter\\n" +
            "      authoredDate\\n" +
            "      blame{\\n" +
            "        ranges{\\n" +
            "          age\\n" +
            "          commit{\\n" +
            "            id\\n" +
            "          }\\n" +
            "          startingLine\\n" +
            "          endingLine\\n" +
            "        }\\n" +
            "      }\\n" +
            "      changedFiles\\n" +
            "      commitResourcePath\\n" +
            "      commitUrl\\n" +
            "      committedDate\\n" +
            "      committedViaWeb\\n" +
            "      committer{\\n" +
            "        avatarUrl\\n" +
            "        date\\n" +
            "        email\\n" +
            "        name\\n" +
            "        user{\\n" +
            "          id\\n" +
            "        }\\n" +
            "      }\\n" +
            "      deletions\\n" +
            "      id\\n" +
            "      message\\n" +
            "      messageBody\\n" +
            "      messageBodyHTML\\n" +
            "      messageHeadline\\n" +
            "      messageHeadlineHTML\\n" +
            "      oid\\n" +
            "      pushedDate\\n" +
            "      repository{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      resourcePath\\n" +
            "      signature{\\n" +
            "        __typename\\n" +
            "        ... on GpgSignature{\\n" +
            "          keyId\\n" +
            "        }\\n" +
            "        state\\n" +
            "        signature\\n" +
            "        wasSignedByGitHub\\n" +
            "        payload\\n" +
            "        email\\n" +
            "        isValid\\n" +
            "        signer{\\n" +
            "          id\\n" +
            "        }\\n" +
            "      }\\n" +
            "      status{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      tarballUrl\\n" +
            "      tree{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      treeResourcePath\\n" +
            "      treeUrl\\n" +
            "      url\\n" +
            "      zipballUrl\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";
}
