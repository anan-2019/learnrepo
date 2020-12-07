package com.self.javalearn;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName DataDao
 * @Author 51205 TRN
 * @Date 2020/12/2 18:28
 * @Version 1.0
 * @Description Class Function Description Here
 */
@Mapper
public interface DataDao {
    @Select("select jobID from pjm_job")
    public List<String> selectTest();
}
