package com.example.demo3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

public class APIcall {

    public static void main(String[] args) {
        String apiKey = "a9d3148166ddaff140d7e71bf3c9a2ed";
        String city = "New York";
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            reader.close();

            String weatherData = result.toString();
            sort(weatherData);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void sort(String weatherdata) {
        String input = weatherdata;

        // extract data from input string
        String[] data = input.split("[{},\":]+");

        String date = "";
        String cityName = "";
        double lon = 0.0;
        double lat = 0.0;
        String weather = "";
        double temp = 0.0;

        for (int i = 0; i < data.length; i++) {
            if (data[i].equals("dt")) {
                date = new Date(Long.parseLong(data[i+1]) * 1000L).toString();
            } else if (data[i].equals("name")) {
                cityName = data[i+1];
            } else if (data[i].equals("lon")) {
                lon = Double.parseDouble(data[i+1]);
            } else if (data[i].equals("lat")) {
                lat = Double.parseDouble(data[i+1]);
            } else if (data[i].equals("description")) {
                weather = data[i+1];
            } else if (data[i].equals("temp")) {
                temp = Double.parseDouble(data[i+1]);
            }
        }

        // print results
        System.out.println("City Name: " + cityName);
        System.out.println("Date: " + date);
        System.out.println("Longitude: " + lon);
        System.out.println("Latitude: " + lat);
        System.out.println("Weather: " + weather);
        System.out.println("Temperature: " + temp);
    }
}
