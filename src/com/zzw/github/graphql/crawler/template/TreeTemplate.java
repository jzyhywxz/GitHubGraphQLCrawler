package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class TreeTemplate {
    public static final String TREE_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on Tree{\\n" +
            "      abbreviatedOid\\n" +
            "      commitResourcePath\\n" +
            "      commitUrl\\n" +
            "      entries{\\n" +
            "        mode\\n" +
            "        name\\n" +
            "        object{\\n" +
            "          __typename\\n" +
            "          ... on Blob{\\n" +
            "            id\\n" +
            "          }\\n" +
            "          ... on Commit{\\n" +
            "            id\\n" +
            "          }\\n" +
            "          ... on Tag{\\n" +
            "            id\\n" +
            "          }\\n" +
            "          ... on Tree{\\n" +
            "            id\\n" +
            "          }\\n" +
            "        }\\n" +
            "        oid\\n" +
            "        repository{\\n" +
            "          id\\n" +
            "        }\\n" +
            "        type\\n" +
            "      }\\n" +
            "      id\\n" +
            "      oid\\n" +
            "      repository{\\n" +
            "        id\\n" +
            "      }\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";
}
