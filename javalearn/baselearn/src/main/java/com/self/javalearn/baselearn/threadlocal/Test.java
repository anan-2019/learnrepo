package com.self.javalearn.baselearn.threadlocal;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    /**
     * 模拟ThreadLocal内存泄露导致OOM
     * JVM启动参数 -Xms20M -Xmx20M -Xmn10M
     * @param args
     */
    public static void main(String[] args) {
        // 是否调用remove方法
        boolean doRemove = false;
        // 加锁，让多个线程串行执行，避免多个线程同时占用内存导致的内存溢出问题
        Object lockObj = new Object();
        // 开启20个线程
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        // 为了不重复使用线程，用Map标记一下已经已使用过的线程，
        Map<Long, Integer> threadIdMap = new ConcurrentHashMap<>();
        // 循环向线程变量中设置数据 1024 * 1024 = 1M
        for (int i = 0; i < 1000; i++) {
            executorService.execute(() -> {
                synchronized (lockObj) {
                    Integer num = threadIdMap.putIfAbsent(Thread.currentThread().getId(), 1);
                    if (num == null) {
                        ThreadLocal<Byte[]> threadLocal = new ThreadLocal<>();
                        threadLocal.set(new Byte[1024 * 50]);
                        if(doRemove) {
                            // 解决内存泄露关键
                            threadLocal.remove();
                        }
                        // 将threadLocal置为空引用，利于回收
                        threadLocal = null;
                        // 手工回收
                        System.gc();
                        try {
                            // 调用GC后不一定会马上回收
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println(Thread.currentThread().getName());
                }
            });
            // System.out.println(i);
        }
//        executorService.shutdown();
    }
}