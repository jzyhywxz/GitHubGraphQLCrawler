package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class LabelTemplate {
    public static final String LABEL_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on Label{\\n" +
            "      color\\n" +
            "      createdAt\\n" +
            "      description\\n" +
            "      id\\n" +
            "      isDefault\\n" +
            "      name\\n" +
            "      repository{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      resourcePath\\n" +
            "      updatedAt\\n" +
            "      url\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";
}
