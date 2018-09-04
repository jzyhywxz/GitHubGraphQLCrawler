package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class DeploymentTemplate {
    public static final String DEPLOYMENT_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on Deployment{\\n" +
            "      commit{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      createdAt\\n" +
            "      creator{\\n" +
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
            "      databaseId\\n" +
            "      description\\n" +
            "      environment\\n" +
            "      id\\n" +
            "      latestStatus{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      payload\\n" +
            "      repository{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      state\\n" +
            "      task\\n" +
            "      updatedAt\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";
}
