package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class RepositoryTopicTemplate {
    public static final String REPOSITORY_TOPIC_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on RepositoryTopic{\\n" +
            "      id\\n" +
            "      resourcePath\\n" +
            "      topic{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      url\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";
}
