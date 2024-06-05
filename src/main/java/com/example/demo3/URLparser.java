package com.example.demo3;

import java.util.ArrayList;
import java.util.List;

public class URLparser {

    public static String[] validateURL(String urlStr2) {
        String[] result = new String[3];

        // Get the base URL
        String baseUrl = getBaseUrl(urlStr2);
        result[0] = baseUrl;

        // Get the AppID
        String appId = getAppId(urlStr2);
        result[1] = appId;

        // Get the excluded parameters
        List<String> excludedParams = getExcludedParams(urlStr2);
        if (excludedParams != null) {
            result[2] = "exclude=" + String.join(",", excludedParams);
        } else {
            result[2] = "exclude parameter not found in URL";
        }

        return result;
    }


    // Method to extract the base URL from a URL string
    public static String getBaseUrl(String urlStr) {
        int queryIndex = urlStr.indexOf('?');
        if (queryIndex != -1) {
            return urlStr.substring(0, queryIndex);
        }
        return urlStr;
    }

    // Method to extract the AppID from a URL string
    public static String getAppId(String urlStr) {
        int appIdIndex = urlStr.indexOf("&appid=");
        if (appIdIndex != -1) {
            return urlStr.substring(appIdIndex + "&appid=".length());
        }
        return null;
    }

    // Method to extract the excluded parameters from a URL string
    public static List<String> getExcludedParams(String urlStr) {
        int excludeIndex = urlStr.indexOf("&exclude=");
        if (excludeIndex != -1) {
            String excludeParams = urlStr.substring(excludeIndex + "&exclude=".length());
            return new ArrayList<>(List.of(excludeParams.split(",")));
        }
        return null;
    }
}
