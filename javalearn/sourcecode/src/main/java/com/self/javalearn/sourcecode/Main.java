package com.self.javalearn.sourcecode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName Main
 * @Author 51205 TRN
 * @Date 2020/12/1 10:17
 * @Version 1.0
 * @Description Class Function Description Here
 */
@SpringBootApplication
public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }
}
