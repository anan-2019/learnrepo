package com.self.javalearn.baselearn.function;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ToIntFunction;

/**
 * @Classname PrintTest
 * @Date 2021/4/12 12:59 下午
 * @Created by anan
 * @Description description here
 */
public class PrintTest {

    public static void main(String[] args) {
//        Function<Integer, Integer> f = s -> s++;
//        Function<Integer, Integer> g = s -> s * 2;
//
//        /**
//         * 下面表示在执行F时，先执行G，并且执行F时使用G的输出当作输入。
//         * 相当于以下代码：
//         * Integer a = g.apply(1);
//         * System.out.println(f.apply(a));
//         */
//        System.out.println(f.compose(g).apply(1));
//
//        /**
//         * 表示执行F的Apply后使用其返回的值当作输入再执行G的Apply；
//         * 相当于以下代码
//         * Integer a = f.apply(1);
//         * System.out.println(g.apply(a));
//         */
//        System.out.println(f.andThen(g).apply(1));
//
//        /**
//         * identity方法会返回一个不进行任何处理的Function，即输出与输入值相等；
//         */
//        System.out.println(Function.identity().apply("a"));

        Function<String, String> s = s1 -> s1 +" appenf";

        String apply = collect.apply(s).apply("23456");
        System.out.println(apply);
    }

    public static final Function<Function<String,String>,Function<String,String>> collect = f1 -> f2 -> collects(f1,f2);

    private static String collects(Function<String, String> f1, String f2) {
        return f1.apply(f2);
    }
}

