package com.zzw.github.graphql.crawler.template;

import com.google.gson.Gson;
import com.zzw.github.graphql.builder.TypeUtil;
import com.zzw.github.graphql.parser.GGParser;
import com.zzw.github.graphql.schema.Error;
import com.zzw.github.graphql.schema.query.QueryEntry;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zzw on 2018/9/2.
 */
public class MetaTemplate {
    public static final String NODE_ID = "NODE_ID";
    public static final String NODE_CURSOR = "NODE_CURSOR";
    public static final String TYPE_NAME = "TYPE_NAME";
    public static final String FIELD_CONNECTION = "FIELD_CONNECTION";

    public static final String CONNECTION_FIRST =
            "{\"query\":\"query{\\n" +
                    "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
                    "    __typename\\n" +
                    "    ... on " + TYPE_NAME + "{\\n" +
                    "      " + FIELD_CONNECTION + "(first:100){\\n" +
                    "        edges{\\n" +
                    "          cursor\\n" +
                    "          node{\\n" +
                    "            id\\n" +
                    "          }\\n" +
                    "        }\\n" +
                    "        pageInfo{\\n" +
                    "          startCursor\\n" +
                    "          endCursor\\n" +
                    "          hasPreviousPage\\n" +
                    "          hasNextPage\\n" +
                    "        }\\n" +
                    "        totalCount\\n" +
                    "      }\\n" +
                    "    }\\n" +
                    "  }\\n" +
                    "}\",\"variables\":\"{}\"}";

    public static final String CONNECTION_AFTER =
            "{\"query\":\"query{\\n" +
                    "  node(id:\\\"" + NODE_ID + "\\\"){\\n" +
                    "    __typename\\n" +
                    "    ... on " + TYPE_NAME + "{\\n" +
                    "      " + FIELD_CONNECTION + "(first:100,after:\\\"" + NODE_CURSOR + "\\\"){\\n" +
                    "        edges{\\n" +
                    "          cursor\\n" +
                    "          node{\\n" +
                    "            id\\n" +
                    "          }\\n" +
                    "        }\\n" +
                    "        pageInfo{\\n" +
                    "          startCursor\\n" +
                    "          endCursor\\n" +
                    "          hasPreviousPage\\n" +
                    "          hasNextPage\\n" +
                    "        }\\n" +
                    "      }\\n" +
                    "    }\\n" +
                    "  }\\n" +
                    "}\",\"variables\":\"{}\"}";

    public static boolean isAnyErrorOccurred(String result) {
        if (result == null) {
            return true;
        }
        QueryEntry entry = GGParser.fromJson(result, QueryEntry.class);
        Object[] errors = GGParser.get(entry, QueryEntry.class, "errors");
        if ((errors == null) || (errors.length < 2)) {
            return false;
        }
        Error[] errorsValue = (Error[]) errors[1];
        return ((errorsValue != null) && (errorsValue.length > 0));
    }

    public static List<String> getErrorType(String result) {
        if (result == null) {
            return null;
        }
        QueryEntry entry = GGParser.fromJson(result, QueryEntry.class);
        Object[] errors = GGParser.get(entry, QueryEntry.class, "errors");
        if ((errors == null) || (errors.length < 2)) {
            return null;
        }

        Error[] errorsValue = (Error[]) errors[1];
        if ((errorsValue == null) || (errorsValue.length < 0)) {
            return null;
        }

        List<String> errorTypes = new ArrayList<>();
        for (Error error : errorsValue) {
            if (error == null) {
                continue;
            }
            String errorType = error.getType();
            if (errorType == null) {
                continue;
            }
            errorTypes.add(errorType);
        }
        return errorTypes;
    }

    public static int getTotalCount(String result, String connField) {
        if ((result == null) || (connField == null)) {
            return -1;
        }
        QueryEntry entry = GGParser.fromJson(result, QueryEntry.class);
        Object[] totalCount = GGParser.get(entry, QueryEntry.class, "data/node/" + connField + "/totalCount/value");
        if ((totalCount == null) || (totalCount.length < 2)) {
            return -1;
        }
        Object totalCountValue = totalCount[1];
        return (totalCountValue == null) ? -1 : (Integer) totalCountValue;
    }

    public static boolean getHasNextPage(String result, String connField) {
        if ((result == null) || (connField == null)) {
            return false;
        }
        QueryEntry entry = GGParser.fromJson(result, QueryEntry.class);
        Object[] hasNextPage = GGParser.get(entry, QueryEntry.class, "data/node/" + connField + "/pageInfo/hasNextPage/value");
        if ((hasNextPage == null) || (hasNextPage.length < 2)) {
            return false;
        }
        Object hasNextPageValue = hasNextPage[1];
        return (hasNextPageValue == null) ? false : (Boolean) hasNextPageValue;
    }

    public static String getEndCursor(String result, String connField) {
        if ((result == null) || (connField == null)) {
            return null;
        }
        QueryEntry entry = GGParser.fromJson(result, QueryEntry.class);
        Object[] endCursor = GGParser.get(entry, QueryEntry.class, "data/node/" + connField + "/pageInfo/endCursor/value");
        if ((endCursor == null) || (endCursor.length < 2)) {
            return null;
        }
        return (String) endCursor[1];
    }

    public static List<TypeIdBean> getInfoNodeIds(String result) {
        if (result == null) {
            return null;
        }

        QueryEntry entry = GGParser.fromJson(result, QueryEntry.class);
        Object[] infoNode = GGParser.get(entry, QueryEntry.class, "data/node");
        if ((infoNode == null) || (infoNode.length < 2)) {
            return null;
        }
        Class infoNodeType = (Class) infoNode[0];
        Object infoNodeValue = infoNode[1];

        List<Field> infoFields = getInfoFields(infoNodeType);
        if ((infoFields == null) || (infoFields.isEmpty())) {
            return null;
        }

        List<TypeIdBean> typeIdBeans = new ArrayList<>();
        for (Field infoField : infoFields) {
            Object[] obj = GGParser.get(infoNodeValue, infoNodeType, infoField.getName());
            if ((obj == null) || (obj.length < 2)) {
                continue;
            }
            Class objType = (Class) obj[0];
            Object objValue = obj[1];

            if (objType.isArray()) {
                Class objComponentType = objType.getComponentType();
                int length = Array.getLength(objValue);
                for (int i = 0; i < length; i++) {
                    Object objComponentValue = Array.get(objValue, i);
                    Object[] objId = GGParser.get(objComponentValue, objComponentType, "id/value");
                    if ((objId == null) || (objId.length < 2)) {
                        continue;
                    }
//                    Class objIdType = (Class) objId[0];
                    String objIdValue = (String) objId[1];
                    typeIdBeans.add(new TypeIdBean(objComponentType, objIdValue));
                }
            } else {
                Object[] objId = GGParser.get(objValue, objType, "id/value");
                if ((objId == null) || (objId.length < 2)) {
                    continue;
                }
//                Class objIdType = (Class) objId[0];
                String objIdValue = (String) objId[1];
                typeIdBeans.add(new TypeIdBean(objType, objIdValue));
            }
        }
        return typeIdBeans;
    }

    public static List<TypeIdBean> getConnNodeIds(String result) {
        if (result == null) {
            return null;
        }

        QueryEntry entry = GGParser.fromJson(result, QueryEntry.class);
        Object[] infoNode = GGParser.get(entry, QueryEntry.class, "data/node");
        if ((infoNode == null) || (infoNode.length < 2)) {
            return null;
        }
        Class infoNodeType = (Class) infoNode[0];
        Object infoNodeValue = infoNode[1];

        List<Field> connFields = getConnFields(infoNodeType);
        if ((connFields == null) || (connFields.isEmpty())) {
            return null;
        }

        List<TypeIdBean> typeIdBeans = new ArrayList<>();
        for (Field connField : connFields) {
            Object[] connEdges = GGParser.get(infoNodeValue, infoNodeType, connField.getName() + "/edges");
            if ((connEdges == null) || (connEdges.length < 2)) {
                continue;
            }
            Class connEdgeType = ((Class) connEdges[0]).getComponentType();
            Object connEdgesValue = connEdges[1];

            Object[] connNode0 = GGParser.get(infoNodeValue, infoNodeType, connField.getName() + "/edges[0]/node");
            if ((connNode0 == null) || (connNode0.length < 2)) {
                continue;
            }
            Class connNodeType = (Class) connNode0[0];

            int edgeCount = Array.getLength(connEdgesValue);
            for (int i = 0; i < edgeCount; i++) {
                Object connEdgeValue = Array.get(connEdgesValue, i);
                Object[] connNodeId = GGParser.get(connEdgeValue, connEdgeType, "node/id/value");
                if ((connNodeId == null) || (connNodeId.length < 2)) {
                    break;
                }
                String connNodeIdValue = (String) connNodeId[1];

                typeIdBeans.add(new TypeIdBean(connNodeType, connNodeIdValue));
            }
        }
        return typeIdBeans;
    }

    public static Class getInfoNodeType(String result) {
        if (result == null) {
            return null;
        }

        QueryEntry entry = GGParser.fromJson(result, QueryEntry.class);
        Object[] infoNode = GGParser.get(entry, QueryEntry.class, "data/node");
        if ((infoNode == null) || (infoNode.length < 2)) {
            return null;
        }
        return ((Class) infoNode[0]);
    }

    public static Class getConnNodeType(String result, String connField) {
        if ((result == null) || (connField == null)) {
            return null;
        }

        QueryEntry entry = GGParser.fromJson(result, QueryEntry.class);
        Object[] connNode = GGParser.get(entry, QueryEntry.class, "data/node/" + connField + "/edges[0]/node");
        if ((connNode == null) || (connNode.length < 2)) {
            return null;
        }
        return ((Class) connNode[0]);
    }

    public static String getInstanceFromTemplate(String template, String... args) {
        if ((template == null) || (args == null) || (args.length <= 0) || (args.length % 2 != 0)) {
            return null;
        }

        String temp = template;
        for (int i = 0; i < args.length; i += 2) {
            temp = getInstanceFromTemplate(temp, args[i], args[i + 1]);
        }

        return temp;
    }

    private static String getInstanceFromTemplate(String template, String placeholder, String replace) {
        if ((template == null) || (placeholder == null) || (replace == null)) {
            return null;
        }

        Matcher matcher = Pattern.compile(placeholder).matcher(template);
        StringBuilder builder = new StringBuilder();
        int begIndex;
        int endIndex = 0;
        while (matcher.find()) {
            begIndex = matcher.start();
            builder.append(template.substring(endIndex, begIndex));
            builder.append(replace);
            endIndex = matcher.end();
        }
        builder.append(template.substring(endIndex, template.length()));

        return builder.toString();
    }

    public static List<Field> getInfoFields(Class type) {
        if (type == null) {
            return null;
        }

        Field[] fields = type.getDeclaredFields();
        if ((fields == null) || (fields.length <= 0)) {
            return null;
        }

        List<Field> infoFields = new ArrayList<>();
        for (Field field : fields) {
            Class fieldType = field.getType();
            if (TypeUtil.isEnum(fieldType) || TypeUtil.isUnion(fieldType) || TypeUtil.isScalar(fieldType)) {
                continue;
            }
            if (fieldType.getSimpleName().endsWith("Connection")) {
                continue;
            }
            infoFields.add(field);
        }
        return infoFields;
    }

    public static List<Field> getConnFields(Class type) {
        if (type == null) {
            return null;
        }

        Field[] fields = type.getDeclaredFields();
        if ((fields == null) || (fields.length <= 0)) {
            return null;
        }

        List<Field> connFields = new ArrayList<>();
        for (Field field : fields) {
            String fieldName = field.getType().getSimpleName();
            if (fieldName.endsWith("Connection")) {
                connFields.add(field);
            }
        }
        return connFields;
    }

    public static String getInfoTemplate(Class type) {
        if (type == null) {
            return null;
        }

        Class templateType = null;
        try {
            templateType = Class.forName(
                    "com.zzw.github.graphql.crawler.template." +
                            type.getSimpleName() +
                            "Template");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (templateType == null) {
            return null;
        }

        String lineTypeName = hump2line(type.getSimpleName());

        String typeInfoTemplate = null;
        try {
            Field field = templateType.getDeclaredField(lineTypeName + "_INFO");
            field.setAccessible(true);
            typeInfoTemplate = (String) field.get(null);
        } catch (NoSuchFieldException e1) {
            e1.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
        return typeInfoTemplate;
    }

    public static String[] getConnTemplates(Class type, Field connField) {
        if ((type == null) || (connField == null)) {
            return null;
        }

        Class templateType = null;
        try {
            templateType = Class.forName(
                    "com.zzw.github.graphql.crawler.template." +
                            type.getSimpleName() +
                            "Template");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (templateType == null) {
            return null;
        }

        String lineConnFieldName = hump2line(connField.getName());

        String firstConnFieldTemplate = null;
        try {
            Field field = templateType.getDeclaredField(lineConnFieldName + "_FIRST");
            field.setAccessible(true);
            firstConnFieldTemplate = (String) field.get(null);
        } catch (NoSuchFieldException e1) {
            firstConnFieldTemplate = CONNECTION_FIRST;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
        if (firstConnFieldTemplate == null) {
            return null;
        }

        String afterConnFieldTemplate = null;
        try {
            Field field = templateType.getDeclaredField(lineConnFieldName + "_AFTER");
            field.setAccessible(true);
            afterConnFieldTemplate = (String) field.get(null);
        } catch (NoSuchFieldException e1) {
            afterConnFieldTemplate = CONNECTION_AFTER;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
        if (afterConnFieldTemplate == null) {
            return null;
        }

        return new String[]{ firstConnFieldTemplate, afterConnFieldTemplate };
    }

    public static String hump2line(String name) {
        if (name == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if ((c >= 'a') && (c <= 'z')) {
                builder.append((char) (c - 'a' + 'A'));
            } else if ((c >= 'A') && (c <= 'Z')) {
                if (i > 0) {
                    builder.append('_');
                }
                builder.append(c);
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    public static String line2hump(String name) {
        if (name == null) {
            return null;
        }

        String[] subnames = name.split("_");
        if ((subnames == null) || (subnames.length <= 0)) {
            return null;
        }

        StringBuilder builder = new StringBuilder();
        for (String subname : subnames) {
            char c = subname.charAt(0);
            String rest = subname.substring(1);
            if ((c >= 'a') && (c <= 'z')) {
                builder.append((char) (c - 'a' + 'A'));
            } else {
                builder.append(c);
            }
            builder.append(rest.toLowerCase());
        }
        return builder.toString();
    }

    public static class TypeIdBean {
        private Class type;
        private String id;

        public TypeIdBean(Class type, String id) {
            this.type = type;
            this.id = id;
        }

        public Class getType() { return type; }
        public String getId() { return id; }

        @Override
        public String toString() {
            return toJson();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }

            if (!(obj instanceof TypeIdBean)) {
                return false;
            }

            TypeIdBean another = (TypeIdBean) obj;
            if (!this.type.getName().equals(another.type.getName())) {
                return false;
            }
            if (!this.id.equals(another.id)) {
                return false;
            }
            return true;
        }

        public String toJson() {
            return new Gson().toJson(this);
        }

        public static TypeIdBean fromJson(String json) {
            return new Gson().fromJson(json, TypeIdBean.class);
        }
    }

    public static class GGError {
        private String type;
        private String require;
        private String respond;

        public GGError(String type, String require, String respond) {
            this.type = type;
            this.require = require;
            this.respond = respond;
        }

        public String getType() {
            return type;
        }

        public String getRequire() {
            return require;
        }

        public String getRespond() {
            return respond;
        }

        @Override
        public String toString() {
            return toJson();
        }

        public String toJson() {
            return new Gson().toJson(this);
        }

        public static GGError fromJson(String json) {
            return new Gson().fromJson(json, GGError.class);
        }
    }
}
