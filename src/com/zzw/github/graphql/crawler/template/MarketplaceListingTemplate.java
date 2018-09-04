package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class MarketplaceListingTemplate {
    public static final String MARKETPLACE_LISTING_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on MarketplaceListing{\\n" +
            "      app{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      companyUrl\\n" +
            "      configurationResourcePath\\n" +
            "      configurationUrl\\n" +
            "      documentationUrl\\n" +
            "      extendedDescription\\n" +
            "      extendedDescriptionHTML\\n" +
            "      fullDescription\\n" +
            "      fullDescriptionHTML\\n" +
            "      hasApprovalBeenRequested\\n" +
            "      hasPublishedFreeTrialPlans\\n" +
            "      hasTermsOfService\\n" +
            "      howItWorks\\n" +
            "      howItWorksHTML\\n" +
            "      id\\n" +
            "      installationUrl\\n" +
            "      installedForViewer\\n" +
            "      isApproved\\n" +
            "      isDelisted\\n" +
            "      isDraft\\n" +
            "      isPaid\\n" +
            "      isRejected\\n" +
            "      logoBackgroundColor\\n" +
            "      logoUrl\\n" +
            "      name\\n" +
            "      normalizedShortDescription\\n" +
            "      pricingUrl\\n" +
            "      primaryCategory{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      privacyPolicyUrl\\n" +
            "      resourcePath\\n" +
            "      screenshotUrls\\n" +
            "      secondaryCategory{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      shortDescription\\n" +
            "      slug\\n" +
            "      statusUrl\\n" +
            "      supportEmail\\n" +
            "      supportUrl\\n" +
            "      termsOfServiceUrl\\n" +
            "      url\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";
}
