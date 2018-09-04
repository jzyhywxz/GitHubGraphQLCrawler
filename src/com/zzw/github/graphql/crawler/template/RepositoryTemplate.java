package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_CURSOR;
import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class RepositoryTemplate {
    public static final String REPOSITORY_INFO =
            "{\"query\":\"query{\\n" +
                    "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
                    "    __typename\\n" +
                    "    ... on Repository{\\n" +
                    "      codeOfConduct{\\n" +
                    "        body\\n" +
                    "        key\\n" +
                    "        name\\n" +
                    "        url\\n" +
                    "      }\\n" +
                    "      createdAt\\n" +
                    "      databaseId\\n" +
                    "      defaultBranchRef{\\n" +
                    "        id\\n" +
                    "      }\\n" +
                    "      description\\n" +
                    "      descriptionHTML\\n" +
                    "      diskUsage\\n" +
                    "      forkCount\\n" +
                    "      hasIssuesEnabled\\n" +
                    "      hasWikiEnabled\\n" +
                    "      homepageUrl\\n" +
                    "      id\\n" +
                    "      isArchived\\n" +
                    "      isFork\\n" +
                    "      isLocked\\n" +
                    "      isMirror\\n" +
                    "      isPrivate\\n" +
                    "      licenseInfo{\\n" +
                    "        id\\n" +
                    "      }\\n" +
                    "      lockReason\\n" +
                    "      mergeCommitAllowed\\n" +
                    "      mirrorUrl\\n" +
                    "      name\\n" +
                    "      nameWithOwner\\n" +
                    "      owner{\\n" +
                    "        __typename\\n" +
                    "        ... on Organization{\\n" +
                    "          id\\n" +
                    "        }\\n" +
                    "        ... on User{\\n" +
                    "          id\\n" +
                    "        }\\n" +
                    "      }\\n" +
                    "      parent{\\n" +
                    "        id\\n" +
                    "      }\\n" +
                    "      primaryLanguage{\\n" +
                    "        id\\n" +
                    "      }\\n" +
                    "      projectsResourcePath\\n" +
                    "      projectsUrl\\n" +
                    "      pushedAt\\n" +
                    "      rebaseMergeAllowed\\n" +
                    "      resourcePath\\n" +
                    "      shortDescriptionHTML\\n" +
                    "      squashMergeAllowed\\n" +
                    "      sshUrl\\n" +
                    "      updatedAt\\n" +
                    "      url\\n" +
                    "    }\\n" +
                    "  }\\n" +
                    "}\",\"variables\":\"{}\"}";

    public static final String FORKS_FIRST =
            "{\"query\":\"query{\\n" +
                    "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
                    "    __typename\\n" +
                    "    ... on Repository{\\n" +
                    "      forks(first:100){\\n" +
                    "        edges{\\n" +
                    "          cursor\\n" +
                    "          node{\\n" +
                    "            id\\n" +
                    "          }\\n" +
                    "        }\\n" +
                    "        pageInfo{\\n" +
                    "          startCursor\\n" +
                    "          endCursor\\n" +
                    "          hasPreviousPage\\n" +
                    "          hasNextPage\\n" +
                    "        }\\n" +
                    "        totalCount\\n" +
                    "        totalDiskUsage\\n" +
                    "      }\\n" +
                    "    }\\n" +
                    "  }\\n" +
                    "}\",\"variables\":\"{}\"}";

    public static final String LANGUAGES_FIRST =
            "{\"query\":\"query{\\n" +
                    "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
                    "    __typename\\n" +
                    "    ... on Repository{\\n" +
                    "      languages(first:100){\\n" +
                    "        edges{\\n" +
                    "          cursor\\n" +
                    "          size\\n" +
                    "          node{\\n" +
                    "            id\\n" +
                    "          }\\n" +
                    "        }\\n" +
                    "        pageInfo{\\n" +
                    "          startCursor\\n" +
                    "          endCursor\\n" +
                    "          hasPreviousPage\\n" +
                    "          hasNextPage\\n" +
                    "        }\\n" +
                    "        totalCount\\n" +
                    "        totalSize\\n" +
                    "      }\\n" +
                    "    }\\n" +
                    "  }\\n" +
                    "}\",\"variables\":\"{}\"}";

    public static final String LANGUAGES_AFTER =
            "{\"query\":\"query{\\n" +
                    "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
                    "    __typename\\n" +
                    "    ... on Repository{\\n" +
                    "      languages(first:100,after:\\\"" + NODE_CURSOR + "\\\"){\\n" +
                    "        edges{\\n" +
                    "          cursor\\n" +
                    "          size\\n" +
                    "          node{\\n" +
                    "            id\\n" +
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

    public static final String REFS_FIRST =
            "{\"query\":\"query{\\n" +
                    "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
                    "    __typename\\n" +
                    "    ... on Repository{\\n" +
                    "      refs(first:100,refPrefix:\\\"refs/\\\"){\\n" +
                    "        edges{\\n" +
                    "          cursor\\n" +
                    "          node{\\n" +
                    "            id\\n" +
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

    public static final String REFS_AFTER =
            "{\"query\":\"query{\\n" +
                    "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
                    "    __typename\\n" +
                    "    ... on Repository{\\n" +
                    "      refs(first:100,refPrefix:\\\"refs/\\\",after:\\\"" + NODE_CURSOR + "\\\"){\\n" +
                    "        edges{\\n" +
                    "          cursor\\n" +
                    "          node{\\n" +
                    "            id\\n" +
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

    public static final String STARGAZERS_FIRST =
            "{\"query\":\"query{\\n" +
                    "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
                    "    __typename\\n" +
                    "    ... on Repository{\\n" +
                    "      stargazers(first:100){\\n" +
                    "        edges{\\n" +
                    "          cursor\\n" +
                    "          starredAt\\n" +
                    "          node{\\n" +
                    "            id\\n" +
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

    public static final String STARGAZERS_AFTER =
            "{\"query\":\"query{\\n" +
                    "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
                    "    __typename\\n" +
                    "    ... on Repository{\\n" +
                    "      stargazers(first:100,after:\\\"" + NODE_CURSOR + "\\\"){\\n" +
                    "        edges{\\n" +
                    "          cursor\\n" +
                    "          starredAt\\n" +
                    "          node{\\n" +
                    "            id\\n" +
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
