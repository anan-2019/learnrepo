package com.self.javalearn.baselearn.distributlock.zklock;

public interface ZKLock {
    /**
     * 获取锁
     */
    void lock() throws Exception;

    /**
     * 解锁
     */
    void unlock() throws Exception;
}