package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_CURSOR;
import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class TeamTemplate {
    public static final String TEAM_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on Team{\\n" +
            "      avatarUrl\\n" +
            "      combinedSlug\\n" +
            "      createdAt\\n" +
            "      description\\n" +
            "      discussionsResourcePath\\n" +
            "      discussionsUrl\\n" +
            "      editTeamResourcePath\\n" +
            "      editTeamUrl\\n" +
            "      id\\n" +
            "      membersResourcePath\\n" +
            "      membersUrl\\n" +
            "      name\\n" +
            "      newTeamResourcePath\\n" +
            "      newTeamUrl\\n" +
            "      organization{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      parentTeam{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      privacy\\n" +
            "      repositoriesResourcePath\\n" +
            "      repositoriesUrl\\n" +
            "      resourcePath\\n" +
            "      slug\\n" +
            "      teamsResourcePath\\n" +
            "      teamsUrl\\n" +
            "      updatedAt\\n" +
            "      url\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";

    public static final String MEMBERS_FIRST =
            "{\"query\":\"query{\\n" +
                    "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
                    "    __typename\\n" +
                    "    ... on Team{\\n" +
                    "      members(first:100){\\n" +
                    "        edges{\\n" +
                    "          cursor\\n" +
                    "          memberAccessResourcePath\\n" +
                    "          memberAccessUrl\\n" +
                    "          role\\n" +
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

    public static final String MEMBERS_AFTER =
            "{\"query\":\"query{\\n" +
                    "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
                    "    __typename\\n" +
                    "    ... on Team{\\n" +
                    "      members(first:100,after:\\\"" + NODE_CURSOR + "\\\"){\\n" +
                    "        edges{\\n" +
                    "          cursor\\n" +
                    "          memberAccessResourcePath\\n" +
                    "          memberAccessUrl\\n" +
                    "          role\\n" +
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

    public static final String REPOSITORIES_FIRST =
            "{\"query\":\"query{\\n" +
                    "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
                    "    __typename\\n" +
                    "    ... on Team{\\n" +
                    "      repositories(first:100){\\n" +
                    "        edges{\\n" +
                    "          cursor\\n" +
                    "          permission\\n" +
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

    public static final String REPOSITORIES_AFTER =
            "{\"query\":\"query{\\n" +
                    "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
                    "    __typename\\n" +
                    "    ... on Team{\\n" +
                    "      repositories(first:100,after:\\\"" + NODE_CURSOR + "\\\"){\\n" +
                    "        edges{\\n" +
                    "          cursor\\n" +
                    "          permission\\n" +
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
