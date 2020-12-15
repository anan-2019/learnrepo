package com.self.javalearn.kafkastarter.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName Main
 * @Author 51205
 * @Date 2020/7/8 17:20
 * @Version 1.0
 * @Description Class Function Description Here
 */
@Data
@ConfigurationProperties(prefix = "demo")
public class KafkaConfig {
    private String name;
}
