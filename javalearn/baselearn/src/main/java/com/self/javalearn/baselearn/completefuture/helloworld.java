package com.self.javalearn.baselearn.completefuture;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;

/**
 * @Classname helloworld
 * @Date 2021/4/20 4:13 下午
 * @Created by anan
 * @Description description here
 */
public class helloworld {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("123412");
            return 123;
        });
        completableFuture.thenApply(x->{
            System.out.println(x+1);
            return null;
        });
        completableFuture.thenAccept(x->{
            System.out.println(x);
        });
        completableFuture.thenRun(()->{
            System.out.println("运行结束");
        });
        Thread.sleep(3000);
    }
}
