package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class ReleaseTemplate {
    public static final String RELEASE_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on Release{\\n" +
            "      author{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      createdAt\\n" +
            "      description\\n" +
            "      id\\n" +
            "      isDraft\\n" +
            "      isPrerelease\\n" +
            "      name\\n" +
            "      publishedAt\\n" +
            "      resourcePath\\n" +
            "      tag{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      updatedAt\\n" +
            "      url\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";
}
