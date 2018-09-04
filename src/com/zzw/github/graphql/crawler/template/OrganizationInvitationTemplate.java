package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class OrganizationInvitationTemplate {
    public static final String ORGANIZATION_INVITATION_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on OrganizationInvitation{\\n" +
            "      createdAt\\n" +
            "      email\\n" +
            "      id\\n" +
            "      invitationType\\n" +
            "      invitee{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      inviter{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      organization{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      role\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";
}
