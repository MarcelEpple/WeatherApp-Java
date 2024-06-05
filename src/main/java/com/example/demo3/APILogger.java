package com.example.demo3;

import org.apache.commons.io.IOUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.net.URL;


public class APILogger {
    private static final String LOG_FILE = "api_logs.txt";

    public static void log(String urlStr2) {
        try {
            String response = makeAPICall(urlStr2);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
                LocalDateTime currentTime = LocalDateTime.now();
                String logEntry = formatLogEntry(currentTime, urlStr2, response);
                writer.write(logEntry);
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String makeAPICall(String urlStr2) throws IOException {
        String response = IOUtils.toString(new URL(urlStr2), StandardCharsets.UTF_8);
        return response;
    }

    private static String formatLogEntry(LocalDateTime currentTime, String urlStr2, String response) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return currentTime.format(formatter) + " INFO - Request sent: \"" + urlStr2 + "\", Response received: \"" + response + "\"";
    }
}
