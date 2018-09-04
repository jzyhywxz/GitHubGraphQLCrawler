package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class MarketplaceCategoryTemplate {
    public static final String MARKETPLACE_CATEGORY_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on MarketplaceCategory{\\n" +
            "      description\\n" +
            "      howItWorks\\n" +
            "      id\\n" +
            "      name\\n" +
            "      primaryListingCount\\n" +
            "      resourcePath\\n" +
            "      secondaryListingCount\\n" +
            "      slug\\n" +
            "      url\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";
}
