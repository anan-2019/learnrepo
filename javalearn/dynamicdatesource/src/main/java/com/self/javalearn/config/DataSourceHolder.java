package com.self.javalearn.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName DataSourceHolder
 * @Author 51205 TRN
 * @Date 2020/12/2 10:32
 * @Version 1.0
 * @Description Class Function Description Here
 */
public class DataSourceHolder {
    private static Logger logger = LoggerFactory.getLogger(DataSourceHolder.class);

    private static final ThreadLocal<String> dataSources = new InheritableThreadLocal<>();

    public static void setDataSource(String dataSource){
        dataSources.set(dataSource);
    }

    public static String getDataSource(){
        return dataSources.get();
    }

    public static void clearDataSource(){
        dataSources.remove();
    }
}
