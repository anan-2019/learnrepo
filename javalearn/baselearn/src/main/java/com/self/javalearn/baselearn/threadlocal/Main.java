package com.self.javalearn.baselearn.threadlocal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName Main
 * @Author 51205 TRN
 * @Date 2020/11/27 15:48
 * @Version 1.0
 * @Description Class Function Description Here
 */
public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
        stringThreadLocal.set("1231");
        stringThreadLocal.set("3435");
        stringThreadLocal.remove();
        String s = stringThreadLocal.get();
        System.out.println(s);
        Thread thread = Thread.currentThread();

    }
}
