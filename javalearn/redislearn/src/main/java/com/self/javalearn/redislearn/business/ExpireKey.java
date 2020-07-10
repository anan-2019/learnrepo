package com.self.javalearn.redislearn.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

/**
 * @ClassName ExpireKey
 * @Author 51205
 * @Date 2020/7/10 15:51
 * @Version 1.0
 * @Description Class Function Description Here
 */
public class ExpireKey {
    private static Logger logger = LoggerFactory.getLogger(ExpireKey.class);
    public void expireKey(){
        Jedis jedis = new Jedis("10.64.200.186",6379);
        jedis.auth("red14@pa44");
        jedis.select(1);

        jedis.set("expireKey","1");
        jedis.psubscribe(new KeyExpiredListener(), "__key*__:*");
        jedis.expire("expireKey",10);
    }
}
