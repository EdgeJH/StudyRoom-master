package com.example.studyroom.Auth.Utility;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 남대영 on 2018-07-09.
 */

public class AuthSerialize {

    private Map<String, String> serializeData;
    private String serial;

    public AuthSerialize(Map<String, String> serializeData) {
        this.serializeData = serializeData;
    }

    public AuthSerialize(String serial) {
        this.serial = serial;
    }

    public String serialize() {
        StringBuilder sb = new StringBuilder();
        sb.append("AuthData<");
        for(Map.Entry<String,String> entry : serializeData.entrySet()) {
            sb.append(entry.getKey() + "=" + entry.getValue() + ".");
        }
        sb.append(">");
        return sb.toString();
    }

    public Map<String, String> deserialize() {
        String[] split = serial.substring(serial.indexOf('<') + 1, serial.indexOf('>')).split("[.]");
        HashMap<String, String> map = new HashMap<>();

        for(String key : split) {
            String[] keySplit = key.split("=");
            map.put(keySplit[0], keySplit[1]);
        }
        return map;
    }

}
