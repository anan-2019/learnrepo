package com.self.javalearn.redislearn.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

/**
 * @ClassName Normal
 * @Author 51205
 * @Date 2020/7/10 15:38
 * @Version 1.0
 * @Description Class Function Description Here
 */
public class Normal {
    private static Logger logger = LoggerFactory.getLogger(Normal.class);
    public void normal(){
        // 1. 设置IP地址和端口
        Jedis jedis = new Jedis("10.64.200.186",6379);
        jedis.auth("red14@pa44");
        jedis.select(1);
        // 2. 保存数据
        jedis.set("name","imooc");
        // 3. 获取数据
        String value = jedis.get("name");
        System.out.println(value);
        // 4.释放资源
        jedis.close();
    }
}
