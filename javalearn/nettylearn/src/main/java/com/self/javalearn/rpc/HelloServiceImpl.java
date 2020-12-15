package com.self.javalearn.rpc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName HelloServiceImpl
 * @Author 51205
 * @Date 2020/12/12 15:39
 * @Version 1.0
 * @Description Class Function Description Here
 */
public class HelloServiceImpl implements HelloService{
    private static Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Override
    public String hello(String msg) {
        if (msg != null){
            return "你好客户端，我收到了 " + msg;
        }
        return "你好客户端，我收到了 " + msg;
    }
}
