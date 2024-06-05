package com.example.demo3;

import org.json.JSONArray;
import org.json.JSONObject;

public class ComboBoxSelection {

    public String getValue(String selectedOption, String APIresponse) {
        String input1 = APIresponse;
        String input2 = selectedOption;
        input2 = input2.replace("\"", "");

        String result = extractChildValue(input1, input2);
        return result;
    }

    private String extractChildValue(String input1, String input2) {
        JSONObject json = new JSONObject(input1);

        String[] keys = input2.split("\\.");

        Object currentObject = json;
        for (String key : keys) {
            if (currentObject instanceof JSONObject) {
                currentObject = ((JSONObject) currentObject).opt(key);
            } else if (currentObject instanceof JSONArray) {
                int index = Integer.parseInt(key.substring(1, key.length() - 1));
                currentObject = ((JSONArray) currentObject).optJSONObject(index);
            }

            if (currentObject == null) {
                break;
            }
        }

        return currentObject != null ? currentObject.toString() : null;
    }

}
