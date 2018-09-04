package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class GistCommentTemplate {
    public static final String GIST_COMMENT_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on GistComment{\\n" +
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
            "      body\\n" +
            "      bodyHTML\\n" +
            "      bodyText\\n" +
            "      createdAt\\n" +
            "      createdViaEmail\\n" +
            "      databaseId\\n" +
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
            "      gist{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      id\\n" +
            "      includesCreatedEdit\\n" +
            "      lastEditedAt\\n" +
            "      publishedAt\\n" +
            "      updatedAt\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";
}
