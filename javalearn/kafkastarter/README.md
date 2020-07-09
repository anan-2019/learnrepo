## 总结
1. 需要一个配置类：KafkaConfig和平常的配置类一样，加上@ConfigurationProperties(prefix = "kafka"),@Value不可以哦
2. 然后就是自动化配置类了AutoConfig此处需要两个注解<br>
   ``` java
     @Configuration
     @EnableConfigurationProperties(KafkaConfig.class)//此处的类是第一步的配置类哦
   ```
3. 在MEAT-INF中添加spring.factories文件,指定我们的EnableAutoConfiguration标注的类
    ``` java
   org.springframework.boot.autoconfigure.EnableAutoConfiguration=com.self.javalearn.kafkastarter.business.AutoConfig
   ```
4. 至此我们就大工告成了，如果想要自定义一些提示的话可以在MEAT-INF中添加spring-configuration-metadata.json，然后添加对应的json配置即可
    ``` json
    {
      "properties": [
    
        {
          "name": "demo.name",
          "type": "java.lang.String",
          "defaultValue": "浙江大学",
          "description": "当前登录系统租户."
        }
      ],
      "hints": [
        {
          "name": "demo.name",
          "values": [
            {
              "value": "浙江大学",
              "description": "用户浙大."
            },
            {
              "value": "北京大学",
              "description": "用户北大."
            },
            {
              "value": "深圳大学",
              "description": "用户深大."
            }
          ],
          "providers": [
            {
              "name": "any"
            }
          ]
        }
      ]
    }
   ```
参考：[配置方式](https://blog.csdn.net/yanluandai1985/article/details/106660938 "spring-configuration-metadata.json配置方式")