package com.self.javalearn.redislearn.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;
 
import java.io.File;
 
/**
 * redis 消息过期异步通知监听器
 *
 * */
@Component
public class RedisMessageListener extends KeyExpirationEventMessageListener {
 
    private static Logger logger = LoggerFactory.getLogger(RedisMessageListener.class);
 
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
 
    public RedisMessageListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }
 
    @Override
    public void onMessage(Message message, byte[] pattern) {
        logger.info("收到 redis 过期异步通知：{}", message.toString());
 
        String redisKey = (String) redisTemplate.getValueSerializer().deserialize(message.getBody());
        logger.info("redisKey : {}", redisKey);
        //针对特定的key进行处理
        if (redisKey.startsWith("rediskey")){
            try {              
             //TODO
 
            }catch (Exception exp){
                logger.info("业务处理失败：" + exp.getMessage());
            }
        }
    }
}