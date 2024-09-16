package com.example.tutoria.service.impl;

import com.example.tutoria.service.RedisService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService {

    private final StringRedisTemplate redisTemplate;

    public RedisServiceImpl(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void saveKeyValue(String key, String value, int exp) {
        redisTemplate.opsForValue().set(key, value);
        redisTemplate.expire(key, exp, TimeUnit.MINUTES);
    }

    @Override
    public String getValueByKey(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public void deleteByKey(String key) {
        redisTemplate.delete(key);
    }
}
