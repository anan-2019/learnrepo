package com.self.javalearn.baselearn.limit.locallimit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Main
 * @Author 51205 TRN
 * @Date 2020/12/2 13:38
 * @Version 1.0
 * @Description 在guava中提供了RateLimit可以直接使用此处只是学习
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        TokenLimiter tokenLimiter = new TokenLimiter(10, TimeUnit.SECONDS,1);
        while (true){
            if (tokenLimiter.getToken()){
                System.out.println("获取到令牌直接进行处理");
            }else {
                System.out.println("未获取到令牌，将会被丢弃");
            }
            Thread.sleep(200);
        }
    }
}
