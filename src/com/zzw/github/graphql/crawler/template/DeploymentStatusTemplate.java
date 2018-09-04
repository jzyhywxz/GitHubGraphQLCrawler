package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class DeploymentStatusTemplate {
    public static final String DEPLOYMENT_STATUS_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on DeploymentStatus{\\n" +
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
            "      deployment{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      description\\n" +
            "      environment\\n" +
            "      environmentUrl\\n" +
            "      id\\n" +
            "      logUrl\\n" +
            "      state\\n" +
            "      updatedAt\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";
}
