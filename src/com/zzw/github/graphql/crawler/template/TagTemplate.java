package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class TagTemplate {
    public static final String TAG_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on Tag{\\n" +
            "      abbreviatedOid\\n" +
            "      commitResourcePath\\n" +
            "      commitUrl\\n" +
            "      id\\n" +
            "      message\\n" +
            "      name\\n" +
            "      oid\\n" +
            "      repository{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      tagger{\\n" +
            "        avatarUrl\\n" +
            "        date\\n" +
            "        email\\n" +
            "        name\\n" +
            "        user{\\n" +
            "          id\\n" +
            "        }\\n" +
            "      }\\n" +
            "      target{\\n" +
            "        __typename\\n" +
            "        ... on Blob{\\n" +
            "          id\\n" +
            "        }\\n" +
            "        ... on Commit{\\n" +
            "          id\\n" +
            "        }\\n" +
            "        ... on Tag{\\n" +
            "          id\\n" +
            "        }\\n" +
            "        ... on Tree{\\n" +
            "          id\\n" +
            "        }\\n" +
            "      }\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";
}
