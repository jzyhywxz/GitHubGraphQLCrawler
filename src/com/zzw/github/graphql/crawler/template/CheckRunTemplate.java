package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_CURSOR;
import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class CheckRunTemplate {
    public static final String CHECK_RUN_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on CheckRun{\\n" +
            "      checkSuite{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      completedAt\\n" +
            "      conclusion\\n" +
            "      databaseId\\n" +
            "      detailsUrl\\n" +
            "      externalId\\n" +
            "      id\\n" +
            "      name\\n" +
            "      permalink\\n" +
            "      repository{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      resourcePath\\n" +
            "      startedAt\\n" +
            "      status\\n" +
            "      summary\\n" +
            "      text\\n" +
            "      title\\n" +
            "      url\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";

    public static final String ANNOTATIONS_FIRST =
            "{\"query\":\"query{\\n" +
                    "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
                    "    __typename\\n" +
                    "    ... on CheckRun{\\n" +
                    "      annotations(first:100){\\n" +
                    "        edges{\\n" +
                    "          cursor\\n" +
                    "          node{\\n" +
                    "            annotationLevel\\n" +
                    "            blobUrl\\n" +
                    "            databaseId\\n" +
                    "            location{\\n" +
                    "              start{\\n" +
                    "                line\\n" +
                    "                column\\n" +
                    "              }\\n" +
                    "              end{\\n" +
                    "                line\\n" +
                    "                column\\n" +
                    "              }\\n" +
                    "            }\\n" +
                    "            message\\n" +
                    "            path\\n" +
                    "            rawDetails\\n" +
                    "            title\\n" +
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

    public static final String ANNOTATIONS_AFTER =
            "{\"query\":\"query{\\n" +
                    "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
                    "    __typename\\n" +
                    "    ... on CheckRun{\\n" +
                    "      annotations(first:100,after:\\\"" + NODE_CURSOR + "\\\"){\\n" +
                    "        edges{\\n" +
                    "          cursor\\n" +
                    "          node{\\n" +
                    "            annotationLevel\\n" +
                    "            blobUrl\\n" +
                    "            databaseId\\n" +
                    "            location{\\n" +
                    "              start{\\n" +
                    "                line\\n" +
                    "                column\\n" +
                    "              }\\n" +
                    "              end{\\n" +
                    "                line\\n" +
                    "                column\\n" +
                    "              }\\n" +
                    "            }\\n" +
                    "            message\\n" +
                    "            path\\n" +
                    "            rawDetails\\n" +
                    "            title\\n" +
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
