package com.example.tutoria.utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.parameters.P;

public class Utils {

    public static String convertToJson(Object object) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static <T> T convertFromJson(String json, Class<T> valueType) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(json, valueType);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
