package com.example.demo3;

import org.json.JSONObject;

public class ComboBoxSelection {
    private JSONObject data;

    public ComboBoxSelection (String answer) {
        this.data = new JSONObject(answer);
    }

    public String getValue(String selectedOption) {
        String[] keys = selectedOption.split("\\.");
        JSONObject currentObj = data;
        for (String key : keys) {
            if (currentObj.has(key)) {
                Object val = currentObj.get(key);
                if (val instanceof JSONObject) {
                    currentObj = (JSONObject) val;
                } else {
                    return String.valueOf(val);
                }
            } else {
                return null;
            }
        }
        return null;
    }
}

