package com.self.javalearn.kafkastarter.business;

import com.self.javalearn.kafkastarter.config.KafkaConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName AutoConfig
 * @Author 51205
 * @Date 2020/7/8 17:26
 * @Version 1.0
 * @Description Class Function Description Here
 */
@Configuration
@EnableConfigurationProperties(KafkaConfig.class)
public class AutoConfig {
    private static Logger logger = LoggerFactory.getLogger(AutoConfig.class);

    @Autowired
    KafkaConfig kafkaConfig;
    @Bean
    public void start(){
        System.out.println(kafkaConfig.getName());
    }
}
