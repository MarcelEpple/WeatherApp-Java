package com.example.demo3;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonParse {
    public static String[] getChildren(String jsonString) {
        ArrayList<String> children = new ArrayList<>();

        Pattern pattern = Pattern.compile("\"(.*?)\":");
        Matcher matcher = pattern.matcher(jsonString);
        while (matcher.find()) {
            String child = matcher.group(1);
            children.add(child);
            String subChildren = extractSubChildren(jsonString, child);
            if (!subChildren.isEmpty()) {
                String[] subChildArray = subChildren.split(",");
                for (String subChild : subChildArray) {
                    String subChildName = subChild.split(":")[0].trim();
                    children.add(child + "." + subChildName);
                }
            }
        }

        return children.toArray(new String[0]);
    }

    private static String extractSubChildren(String jsonString, String child) {
        String patternString = "\"" + child + "\":\\{(.*?)\\}";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(jsonString);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }
}
