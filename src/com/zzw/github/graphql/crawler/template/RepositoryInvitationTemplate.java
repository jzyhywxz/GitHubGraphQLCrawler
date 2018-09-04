package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class RepositoryInvitationTemplate {
    public static final String REPOSITORY_INVITATION_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on RepositoryInvitation{\\n" +
            "      id\\n" +
            "      invitee{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      inviter{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      permission\\n" +
            "      repository{\\n" +
            "        __typename\\n" +
            "        ... on Repository{\\n" +
            "          id\\n" +
            "        }\\n" +
            "      }\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";
}
