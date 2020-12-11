package com.self.javalearn.sourcecode.beanhandel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName TestFactoryBean
 * @Author 51205 TRN
 * @Date 2020/12/7 20:11
 * @Version 1.0
 * @Description Class Function Description Here
 */
public class TestFactoryBean implements FactoryBean {
    private static Logger logger = LoggerFactory.getLogger(TestFactoryBean.class);

    private Class mapper;

    public TestFactoryBean(Class mapper) {
        this.mapper = mapper;
    }

    @Override
    public Object getObject() throws Exception {
        Object o = Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{mapper}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method.getName());
                return null;
            }
        });
        return o;
    }

    @Override
    public Class<?> getObjectType() {
        return mapper;
    }
}
