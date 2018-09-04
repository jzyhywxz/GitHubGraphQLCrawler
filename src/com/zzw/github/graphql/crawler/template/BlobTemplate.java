package com.zzw.github.graphql.crawler.template;

import static com.zzw.github.graphql.crawler.template.MetaTemplate.NODE_ID;

/**
 * Created by zzw on 2018/8/31.
 */
public class BlobTemplate {
    public static final String BLOB_INFO = "{\"query\":\"query{\\n" +
            "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
            "    __typename\\n" +
            "    ... on Blob{\\n" +
            "      abbreviatedOid\\n" +
            "      byteSize\\n" +
            "      commitResourcePath\\n" +
            "      commitUrl\\n" +
            "      id\\n" +
            "      isBinary\\n" +
            "      isTruncated\\n" +
            "      oid\\n" +
            "      repository{\\n" +
            "        id\\n" +
            "      }\\n" +
            "      text\\n" +
            "    }\\n" +
            "  }\\n" +
            "}\",\"variables\":\"{}\"}";
}
