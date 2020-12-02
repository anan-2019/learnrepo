package com.self.javalearn.config;

import java.lang.annotation.*;

/**
 * @ClassName SwatchSource
 * @Author 51205 TRN
 * @Date 2020/12/2 10:39
 * @Version 1.0
 * @Description Class Function Description Here
 */
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface SwatchSource {
    String DEFALULT_NAME = "";
    String value() default DEFALULT_NAME;
}
