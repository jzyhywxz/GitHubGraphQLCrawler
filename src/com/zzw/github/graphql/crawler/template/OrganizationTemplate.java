package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class OrganizationTemplate {
    public static final String ORGANIZATION_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on Organization{\\n" +
            "      avatarUrl\\n" +
            "      databaseId\\n" +
            "      description\\n" +
            "      email\\n" +
            "      id\\n" +
            "      isVerified\\n" +
            "      location\\n" +
            "      login\\n" +
            "      name\\n" +
            "      newTeamResourcePath\\n" +
            "      newTeamUrl\\n" +
            "      organizationBillingEmail\\n" +
            "      projectsResourcePath\\n" +
            "      projectsUrl\\n" +
            "      resourcePath\\n" +
            "      samlIdentityProvider{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      teamsResourcePath\\n" +
            "      teamsUrl\\n" +
            "      url\\n" +
            "      websiteUrl\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";

    public static final String PINNED_REPOSITORIES_FIRST =
            "{\"query\":\"query{\\n" +
                    "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
                    "    __typename\\n" +
                    "    ... on Organization{\\n" +
                    "      pinnedRepositories(first:100){\\n" +
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

    public static final String REPOSITORIES_FIRST =
            "{\"query\":\"query{\\n" +
                    "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
                    "    __typename\\n" +
                    "    ... on Organization{\\n" +
                    "      repositories(first:100){\\n" +
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
}
