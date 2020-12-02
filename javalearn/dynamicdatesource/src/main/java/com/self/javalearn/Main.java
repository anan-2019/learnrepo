package com.self.javalearn;

import com.alibaba.druid.spring.boot.autoconfigure.properties.DruidStatProperties;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.Map;

/**
 * @ClassName Main
 * @Author 51205 TRN
 * @Date 2020/12/1 13:45
 * @Version 1.0
 * @Description Class Function Description Here
 */
@SpringBootApplication
@EnableConfigurationProperties({DruidStatProperties.class, DataSourceProperties.class, MybatisProperties.class})
public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        SpringApplication.run(Map.class);
    }
}
