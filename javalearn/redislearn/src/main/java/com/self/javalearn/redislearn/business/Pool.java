package com.self.javalearn.redislearn.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @ClassName Pool
 * @Author 51205
 * @Date 2020/7/10 15:40
 * @Version 1.0
 * @Description Class Function Description Here
 */
public class Pool {
    private static Logger logger = LoggerFactory.getLogger(Pool.class);

    public void redisPool() {
        // 获取连接池配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        // 设置最大连接数
        config.setMaxTotal(30);
        // 设置最大的空闲连接数
        config.setMaxIdle(10);

        // 获得连接池: JedisPool jedisPool = new JedisPool(poolConfig,host,port);
        JedisPool jedisPool = new JedisPool(config, "10.64.200.186", 6379,3600,"red14@pa44");

        // 获得核心对象：jedis
        Jedis jedis = null;
        try {
            // 通过连接池来获得连接
            jedis = jedisPool.getResource();
            jedis.select(1);
            // 设置数据
            jedis.set("name1", "张三");
            // 获取数据
            String value = jedis.get("name1");
            System.out.println(value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            if (jedis != null) {
                jedis.close();
            }
            // 释放连接池
            if (jedisPool != null) {
                jedisPool.close();
            }
        }
    }
}
