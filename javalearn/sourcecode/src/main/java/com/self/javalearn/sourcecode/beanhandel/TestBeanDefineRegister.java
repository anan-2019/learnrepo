package com.self.javalearn.sourcecode.beanhandel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TestBeanDefineRegister
 * @Author 51205 TRN
 * @Date 2020/12/7 20:08
 * @Version 1.0
 * @Description Class Function Description Here
 */
public class TestBeanDefineRegister implements ImportBeanDefinitionRegistrar {
    private static Logger logger = LoggerFactory.getLogger(TestBeanDefineRegister.class);

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        List<Class> mappers = new ArrayList<>();
        mappers.add(User.class);

        for (Class mapper : mappers) {
            BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition();
            AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
            beanDefinition.setBeanClass(TestFactoryBean.class);
            beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(mapper);
            registry.registerBeanDefinition(mapper.getSimpleName(),beanDefinition);
        }

    }
}
