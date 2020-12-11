package com.self.javalearn.sourcecode.beanhandel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @ClassName Config
 * @Author 51205 TRN
 * @Date 2020/12/7 20:22
 * @Version 1.0
 * @Description Class Function Description Here
 */
@Configuration
@ComponentScan("com.self.javalearn.sourcecode")
@Import({TestBeanDefineRegister.class})
public class Config {
    private static Logger logger = LoggerFactory.getLogger(Config.class);
}
