package com.self.javalearn.baselearn.function;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * @Classname Supplier
 * @Date 2021/4/12 3:05 下午
 * @Created by anan
 * @Description description here
 */
public class SupplierTest {
    public static void main(String[] args) {
        Supplier<Optional<String>> supplier = ()->{
            System.out.println("123");
            return Optional.of("123");
        };
        Optional<String> s = supplier.get();
        System.out.println(s);


        Runnable supplier1 = ()->{
            System.out.println("123");
        };
    }
}
