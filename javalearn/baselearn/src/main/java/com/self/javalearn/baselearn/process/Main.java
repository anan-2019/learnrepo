package com.self.javalearn.baselearn.process;

import scala.tools.fusesource_embedded.jansi.internal.Kernel32;

import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

/**
 * @Classname Main
 * @Date 2021/4/27 10:44 上午
 * @Created by anan
 * @Description description here
 */
public class Main {
    public static void main(String[] args) {

        for (int i =0; i< 100; i++){

        String[] cmd = {"sh", "-c", "jstack 86556  > /Users/anan/Desktop/result.log"};
//        String[] cmd = {"sh", "-c", "sh /Users/anan/Desktop/run.sh  > /Users/anan/Desktop/result.log"};
        Process p = null;
        try {
            p = Runtime.getRuntime().exec(cmd);
//            p.waitFor(1, TimeUnit.MILLISECONDS);
//            int i = p.waitFor();
//            System.out.println("执行结果为："+i);
//            Thread.sleep(200);
            p.destroyForcibly();
        while (p.isAlive()){
            try {
                Thread.sleep(500);
            System.out.println("线程存活中");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        }


        System.out.println("线程死亡");

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
