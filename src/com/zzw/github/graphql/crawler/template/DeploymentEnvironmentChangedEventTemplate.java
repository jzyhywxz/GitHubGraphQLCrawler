package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class DeploymentEnvironmentChangedEventTemplate {
    public static final String DEPLOYMENT_ENVIRONMENT_CHANGED_EVENT_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on DeploymentEnvironmentChangedEvent{\\n" +
            "      actor{\\n" +
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
            "      createdAt\\n" +
            "      deploymentStatus{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      id\\n" +
            "      pullRequest{\\n" +
            "        id\\n" +
            "      }\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";
}
