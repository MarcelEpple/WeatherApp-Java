package com.example.demo3;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;



public class gsonPrettyPrint {
    public static String getPrettyJson(String urlStr2) {
        try {
            String answer = IOUtils.toString(new URL(urlStr2), StandardCharsets.UTF_8);
            return new GsonBuilder().setPrettyPrinting().create().toJson(JsonParser.parseString(answer));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}