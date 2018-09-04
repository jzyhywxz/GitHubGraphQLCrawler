package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class LicenseTemplate {
    public static final String LICENSE_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on License{\\n" +
            "      body\\n" +
            "      conditions{\\n" +
            "        description\\n" +
            "        key\\n" +
            "        label\\n" +
            "      }\\n" +
            "      description\\n" +
            "      featured\\n" +
            "      hidden\\n" +
            "      id\\n" +
            "      implementation\\n" +
            "      key\\n" +
            "      limitations{\\n" +
            "        description\\n" +
            "        key\\n" +
            "        label\\n" +
            "      }\\n" +
            "      name\\n" +
            "      nickname\\n" +
            "      permissions{\\n" +
            "        description\\n" +
            "        key\\n" +
            "        label\\n" +
            "      }\\n" +
            "      pseudoLicense\\n" +
            "      spdxId\\n" +
            "      url\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";
}
