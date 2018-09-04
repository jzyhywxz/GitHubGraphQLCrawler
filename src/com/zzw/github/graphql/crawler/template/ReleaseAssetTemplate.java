package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class ReleaseAssetTemplate {
    public static final String RELEASE_ASSET_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "  node{\\n" +
            "    __typename\\n" +
            "    ... on ReleaseAsset{\\n" +
            "      contentType\\n" +
            "      createdAt\\n" +
            "      downloadCount\\n" +
            "      downloadUrl\\n" +
            "      id\\n" +
            "      name\\n" +
            "      release{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      size\\n" +
            "      updatedAt\\n" +
            "      uploadedBy{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      url\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";
}
