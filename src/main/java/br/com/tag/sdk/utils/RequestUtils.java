package br.com.tag.sdk.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class RequestUtils {

    public static String getQueryParams(String path, Map<String, String> params) {
        StringBuffer paramBuffer = new StringBuffer();
        paramBuffer.append(path);
        if (params != null && params.size() > 0) {
            paramBuffer.append("?");
            for (Map.Entry<String, String> entry : params.entrySet()) {
                if (entry.getValue() != null) {
                    paramBuffer
                            .append(entry.getKey())
                            .append("=")
                            .append(entry.getValue())
                            .append("&");
                }
            }
        }
        String paramString = paramBuffer.toString();
        return !paramString.equals(path) ? paramString.substring(0, paramString.length() - 1) : path;
    }

    public static String dateParseAndFormat(Date date, String pattern) {
        if(date == null) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }

}
