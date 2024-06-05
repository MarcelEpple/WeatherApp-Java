package com.example.demo3;

import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class APIcallLatLon {
    public static String[] getLatLon(String urlStr2) {
        String[] latLon = new String[2];
        try {
            URL url = new URL(urlStr2);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                if (line.contains("\"lat\":")) {
                    String latStr = line.split(":")[1].split(",")[0].trim();
                    latLon[0] = latStr;
                }
                if (line.contains("\"lon\":")) {
                    String lonStr = line.split(":")[2].split(",")[0].trim();
                    latLon[1] = lonStr;
                }
            }
            rd.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return latLon;
    }
}

