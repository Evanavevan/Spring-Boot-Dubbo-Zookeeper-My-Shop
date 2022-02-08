package com.evan.myshop.service.redis.api;

public interface RedisService {
    /**
     * 设置缓存
     * @param key 键
     * @param value 值
     */
    void set(String key, Object value);

    /**
     * 设置缓存
     * @param key 键
     * @param value 值
     * @param seconds 缓存有效期
     */
    void set(String key, Object value, int seconds);

    /**
     * 获取缓存
     * @param key 键
     */
    Object get(String key);

    /**
     * 删除缓存
     * @param key 键
     */
    void delete(String key);
}
