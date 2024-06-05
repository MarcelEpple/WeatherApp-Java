package com.example.demo3;

import java.net.MalformedURLException;
import java.net.URL;

public class URLValidator {

    public static boolean isValidURL(String urlStr) {
        try {
            URL url = new URL(urlStr);
            return true;
        } catch (MalformedURLException e) {
            return false;
        }
    }
}
