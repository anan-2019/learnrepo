package com.self.javalearn.baselearn.distributlock.zklock;

import org.apache.curator.framework.CuratorFramework;

/**
 * 排它锁实现
 */
public abstract class AbstractZKLockMutex implements ZKLock {

    /**
     * 节点路径
     */
    protected String lockPath;

    /**
     * zk客户端
     */
    protected CuratorFramework zkClient;

    private AbstractZKLockMutex(){}

    public AbstractZKLockMutex(String lockPath, CuratorFramework client){
        this.lockPath=lockPath;
        this.zkClient=client;
    }

    /**
     * 模板方法，搭建的获取锁的框架，具体逻辑交于子类实现
     * @throws Exception
     */
    @Override
    public final void lock() throws Exception {
        //获取锁成功
        if (tryLock()){
            System.out.println(Thread.currentThread().getName()+"获取锁成功");
        }else{  //获取锁失败
            //阻塞一直等待
            waitLock();
            //递归，再次获取锁
            lock();
        }
    }

    /**
     * 尝试获取锁，子类实现
     */
    protected abstract boolean tryLock() ;


    /**
     * 等待获取锁，子类实现
     */
    protected abstract void waitLock() throws Exception;


    /**
     * 解锁：删除节点或者直接断开连接
     */
    @Override
    public  abstract void unlock() throws Exception;
}