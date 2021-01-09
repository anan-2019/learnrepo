package com.self.javalearn.rabbitmqlearn;

import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName Main
 * @Author 51205
 * @Date 2021/1/5 21:35
 * @Version 1.0
 * @Description Class Function Description Here
 */
public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {

        producer();
        Thread.sleep(1000);
        consumer();
        ArrayList<String> objects = new ArrayList<>();
//        objects.add()
    }

    public static void producer() throws IOException, TimeoutException {
        Connection connection = ConnectUtil.getConnection();
        String msg =  "hello rabbitmq";
        Channel channel = connection.createChannel();
        channel.basicPublish("","queue1",null,msg.getBytes());
        channel.close();
        connection.close();
        System.out.println("消息发送成功");
    }

    public static void consumer() throws IOException, TimeoutException {
        Connection connection = ConnectUtil.getConnection();
        Channel channel = connection.createChannel();

        Consumer defaultConsumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("接收到的数据为："+ new String(body));
            }
        };
        channel.basicConsume("queue1",true, defaultConsumer);
//        channel.close();
//        connection.close();
    }
}
