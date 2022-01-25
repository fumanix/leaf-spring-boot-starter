package com.fumanix.framework.leaf.support;

import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

public class RedisRepository {

    private static StringRedisTemplate stringRedisTemplate;

    private static final String REDIS_SN_KEY = "leaf.generator:";

    public void setRedisTemplate(StringRedisTemplate redisTemplate) {
        stringRedisTemplate = redisTemplate;
    }


    public static Long increment(String key) {
        String cacheKey = buildKey(key);
        return stringRedisTemplate.opsForValue().increment(cacheKey, 1);
    }

    public static boolean isSetMember(String key, String value) {
        return stringRedisTemplate.opsForSet().isMember(buildKey(key), value);
    }

    public static Long addToSet(String key, String value) {
        return stringRedisTemplate.opsForSet().add(buildKey(key), value);
    }

    public static void expire(String key) {
        stringRedisTemplate.expire(buildKey(key), 24, TimeUnit.HOURS);
    }

    private static String buildKey(String key) {
        return REDIS_SN_KEY + key;
    }

}
