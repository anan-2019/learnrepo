package com.self.javalearn.sourcecode.beanfactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @ClassName AfterRefreshTest
 * @Author 51205 TRN
 * @Date 2020/12/15 16:52
 * @Version 1.0
 * @Description Class Function Description Here
 */
@Component
public class AfterRefreshTest extends SpringApplication {
    private static Logger logger = LoggerFactory.getLogger(AfterRefreshTest.class);

    @Override
    protected void afterRefresh(ConfigurableApplicationContext context, ApplicationArguments args) {

        System.out.println("我启动了");
    }
}
