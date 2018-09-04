package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_CURSOR;
import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class GistTemplate {
    public static final String GIST_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on Gist{\\n" +
            "      createdAt\\n" +
            "      description\\n" +
            "      id\\n" +
            "      isPublic\\n" +
            "      name\\n" +
            "      owner{\\n" +
            "        __typename\\n" +
            "        ... on Organization{\\n" +
            "          id\\n" +
            "        }\\n" +
            "        ... on User{\\n" +
            "          id\\n" +
            "        }\\n" +
            "      }\\n" +
            "      pushedAt\\n" +
            "      updatedAt\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";

    public static final String STARGAZERS_FIRST =
            "{\"query\":\"query{\\n" +
                    "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
                    "    __typename\\n" +
                    "    ... on Gist{\\n" +
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
                    "    ... on Gist{\\n" +
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
