package com.self.javalearn.sourcecode.beanfactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

/**
 * @ClassName FactoryTest
 * @Author 51205 TRN
 * @Date 2020/12/14 17:34
 * @Version 1.0
 * @Description Class Function Description Here
 */
public class FactoryTest implements InstantiationAwareBeanPostProcessor {
    private static Logger logger = LoggerFactory.getLogger(FactoryTest.class);

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return false;
    }
}
