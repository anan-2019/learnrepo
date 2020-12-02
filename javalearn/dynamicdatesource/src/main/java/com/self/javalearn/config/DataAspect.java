package com.self.javalearn.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @ClassName DataAspect
 * @Author 51205 TRN
 * @Date 2020/12/2 10:40
 * @Version 1.0
 * @Description Class Function Description Here
 */
@Aspect
@Component
public class DataAspect {
    private static Logger logger = LoggerFactory.getLogger(DataAspect.class);

    @Pointcut(value = "@annotation(SwatchSource)")
    public void pointcut(){}

    @Before(value = "pointcut()")
    public void beforeOpt(JoinPoint joinPoint){
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        SwatchSource switchSource = method.getAnnotation(SwatchSource.class);
        DataSourceHolder.setDataSource(switchSource.value());
    }

    @After(value = "pointcut()")
    public void afterOpt() {
        DataSourceHolder.clearDataSource();
    }
}
