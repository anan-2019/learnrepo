package com.self.javalearn.baselearn.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * https://www.jianshu.com/p/b4de97ca8bb9
 */

public class CollectionApp {
    private static sun.misc.Unsafe UNSAFE;

    public static void main(String[] args) {
        try {
            User instance = (User) UNSAFE.allocateInstance(User.class);

            instance.setName("luoyoub");
            System.err.println("instance:" + instance);
            instance.test();

            Field name = instance.getClass().getDeclaredField("name");
            UNSAFE.putObject(instance, UNSAFE.objectFieldOffset(name), "huanghui");
            instance.test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            UNSAFE = (Unsafe) field.get(null);
        } catch (Exception e) {
        }
    }
}

class User {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void test() {
        System.err.println("hello,world" + name);
    }
}