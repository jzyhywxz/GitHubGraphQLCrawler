package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class DeployKeyTemplate {
    public static final String DEPLOY_KEY_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on DeployKey{\\n" +
            "      createdAt\\n" +
            "      id\\n" +
            "      key\\n" +
            "      readOnly\\n" +
            "      title\\n" +
            "      verified\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";
}
