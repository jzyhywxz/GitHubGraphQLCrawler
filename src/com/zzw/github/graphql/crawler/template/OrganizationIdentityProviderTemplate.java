package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class OrganizationIdentityProviderTemplate {
    public static final String ORGANIZATION_IDENTITY_PROVIDER_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on OrganizationIdentityProvider{\\n" +
            "      digestMethod\\n" +
            "      id\\n" +
            "      idpCertificate\\n" +
            "      issuer\\n" +
            "      organization{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      signatureMethod\\n" +
            "      ssoUrl\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";
}
