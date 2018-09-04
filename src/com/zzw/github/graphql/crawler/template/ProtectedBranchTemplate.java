package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class ProtectedBranchTemplate {
    public static final String PROTECTED_BRANCH_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on ProtectedBranch{\\n" +
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
            "      hasDismissableStaleReviews\\n" +
            "      hasRequiredReviews\\n" +
            "      hasRequiredSignatures\\n" +
            "      hasRequiredStatusChecks\\n" +
            "      hasRestrictedPushes\\n" +
            "      hasRestrictedReviewDismissals\\n" +
            "      hasStrictRequiredStatusChecks\\n" +
            "      id\\n" +
            "      isAdminEnforced\\n" +
            "      name\\n" +
            "      repository{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      requiredApprovingReviewCount\\n" +
            "      requiredStatusCheckContexts\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";
}
