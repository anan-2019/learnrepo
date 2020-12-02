package com.self.javalearn.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @ClassName DynamicDataSource
 * @Author 51205 TRN
 * @Date 2020/12/2 10:35
 * @Version 1.0
 * @Description Class Function Description Here
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    private static Logger logger = LoggerFactory.getLogger(DynamicDataSource.class);

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceHolder.getDataSource();
    }

    public DynamicDataSource(DataSource defaultTargetDataSource, Map<Object,Object> targetDatasource){
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        super.setTargetDataSources(targetDatasource);
        super.afterPropertiesSet();
    }
}
