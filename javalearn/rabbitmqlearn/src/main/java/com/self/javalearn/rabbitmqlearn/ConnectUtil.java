package com.self.javalearn.rabbitmqlearn;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName ConnectUtil
 * @Author 51205
 * @Date 2021/1/5 21:38
 * @Version 1.0
 * @Description Class Function Description Here
 */
public class ConnectUtil {
    private static Logger logger = LoggerFactory.getLogger(ConnectUtil.class);

    public static Connection getConnection() throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("121.4.38.55");
        connectionFactory.setUsername("root");
        connectionFactory.setPassword("root");
        connectionFactory.setVirtualHost("host1");
        connectionFactory.setPort(5672);
        return connectionFactory.newConnection();
    }
}
