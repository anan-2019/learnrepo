package com.self.javalearn.baselearn.function;

/**
 * @Classname Consumer
 * @Date 2021/4/12 1:13 下午
 * @Created by anan
 * @Description description here
 */
public class Consumer {
    public static void main(String[] args) {
        java.util.function.Consumer f = System.out::println;
        java.util.function.Consumer f2 = n -> System.out.println(n + "-F2");

        //执行完F后再执行F2的Accept方法
        f.andThen(f2).accept("test");

        //连续执行F的Accept方法
        f.andThen(f).andThen(f2).andThen(f).accept("test1");
    }
}
