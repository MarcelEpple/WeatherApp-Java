package com.example.demo3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonParser {
    private String jsonStr;

    public JsonParser(String jsonStr) {
        this.jsonStr = jsonStr;
    }

    public ArrayList<String> getChildren() {
        ArrayList<String> children = new ArrayList<String>();

        JSONObject jsonObj = new JSONObject(jsonStr);
        children.add("lat: " + jsonObj.getDouble("lat"));
        children.add("lon: " + jsonObj.getDouble("lon"));
        children.add("timezone: " + jsonObj.getString("timezone"));
        children.add("timezone_offset: " + jsonObj.getInt("timezone_offset"));

        JSONObject currentObj = jsonObj.getJSONObject("current");
        children.add("current.dt: " + currentObj.getLong("dt"));
        children.add("current.sunrise: " + currentObj.getLong("sunrise"));
        children.add("current.sunset: " + currentObj.getLong("sunset"));
        children.add("current.temp: " + currentObj.getDouble("temp"));
        children.add("current.feels_like: " + currentObj.getDouble("feels_like"));
        children.add("current.pressure: " + currentObj.getInt("pressure"));
        children.add("current.humidity: " + currentObj.getInt("humidity"));
        children.add("current.dew_point: " + currentObj.getDouble("dew_point"));
        children.add("current.uvi: " + currentObj.getDouble("uvi"));
        children.add("current.clouds: " + currentObj.getInt("clouds"));
        children.add("current.visibility: " + currentObj.getInt("visibility"));
        children.add("current.wind_speed: " + currentObj.getDouble("wind_speed"));
        children.add("current.wind_deg: " + currentObj.getInt("wind_deg"));
        children.add("current.wind_gust: " + currentObj.getDouble("wind_gust"));

        JSONArray weatherArr = currentObj.getJSONArray("weather");
        JSONObject weatherObj = weatherArr.getJSONObject(0);
        children.add("current.weather.id: " + weatherObj.getInt("id"));
        children.add("current.weather.main: " + weatherObj.getString("main"));
        children.add("current.weather.description: " + weatherObj.getString("description"));
        children.add("current.weather.icon: " + weatherObj.getString("icon"));

        return children;
    }
}