package com.example.tutoria.service;

public interface RedisService {
    void saveKeyValue(String key, String value, int exp);
    String getValueByKey(String key);
    void deleteByKey(String key);
}
