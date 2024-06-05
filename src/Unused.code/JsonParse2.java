package com.example.demo3;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class JsonParse {
    public static String[] getChildren(String jsonString) {
        jsonString = jsonString.replaceAll("[{}\"0-9.]", "");
        String[] lines = jsonString.split(",");
        ArrayList<String> children = new ArrayList<>();
        for (String line : lines) {
            String[] parts = line.split(":");
            String child = parts[0].trim();
            child = child.split(Pattern.quote("("))[0].trim();
            child = child.split(Pattern.quote("/"))[0].trim();
            children.add(child);
        }
        return children.toArray(new String[0]);
    }
}