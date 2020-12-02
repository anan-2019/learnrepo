package com.self.javalearn.sourcecode.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Author 51205 TRN
 * @Date 2020/12/1 10:23
 * @Version 1.0
 * @Description Class Function Description Here
 */
@RestController
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/user")
    public String getUser(){
        return "trst";
    }
}
