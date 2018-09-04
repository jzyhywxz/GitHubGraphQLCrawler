package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class ExternalIdentityTemplate {
    public static final String EXTERNAL_IDENTITY_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on ExternalIdentity{\\n" +
            "      guid\\n" +
            "      id\\n" +
            "      organizationInvitation{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      samlIdentity{\\n" +
            "        nameId\\n" +
            "      }\\n" +
            "      scimIdentity{\\n" +
            "        username\\n" +
            "      }\\n" +
            "      user{\\n" +
            "        id\\n" +
            "      }\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";
}
