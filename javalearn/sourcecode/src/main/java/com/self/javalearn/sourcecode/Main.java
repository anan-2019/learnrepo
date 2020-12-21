package com.self.javalearn.sourcecode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @ClassName Main
 * @Author 51205 TRN
 * @Date 2020/12/1 10:17
 * @Version 1.0
 * @Description Class Function Description Here
 */
@SpringBootApplication
@EnableTransactionManagement
public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        SpringApplication.run(Main.class);

//        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Config.class);
//        Object user = annotationConfigApplicationContext.getBean("User");
//        String s = user.toString();
//        System.out.println(s);
//        SpringApplication.run(Main.class);
    }
}
