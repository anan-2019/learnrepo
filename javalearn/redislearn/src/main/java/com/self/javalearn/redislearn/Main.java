package com.self.javalearn.redislearn;

import com.self.javalearn.redislearn.business.ExpireKey;
import com.self.javalearn.redislearn.business.Normal;
import com.self.javalearn.redislearn.business.Pool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName Main
 * @Author 51205
 * @Date 2020/7/10 14:05
 * @Version 1.0
 * @Description Class Function Description Here
 */
public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        //常规测试，单个连接测试
        Normal normal = new Normal();
        normal.normal();
        //连接池测试
        Pool pool = new Pool();
        pool.redisPool();
        //过期key监控
        ExpireKey expireKey = new ExpireKey();
        expireKey.expireKey();
    }
}
