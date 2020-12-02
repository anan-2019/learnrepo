package com.self.javalearn.baselearn.distributlock.rwzklock;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.listen.ListenerContainer;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

/**
 * 读写锁，读不限制写限制
 * 读逻辑：
 * 创建临时有序节点（当前线程拥有的读锁或称作读节点）。
 *
 * 获取路径下所有的子节点，并进行从小到大排序
 *
 * 获取当前节点前的临近写节点(写锁)。
 *
 * 如果不存在的临近写节点，则成功获取读锁。
 *
 * 如果存在临近写节点，对其监听删除事件。
 *
 * 一旦监听到删除事件，重复2,3,4,5的步骤(递归)。
 *
 * 写逻辑：
 *
 * 创建临时有序节点（当前线程拥有的写锁或称作写节点）。
 *
 * 获取路径下的所有子节点，并进行从小到大排序。
 *
 * 获取当前节点的临近节点(读节点和写节点)。
 *
 * 如果不存在临近节点，则成功获取锁。
 *
 * 如果存在临近节点，对其进行监听删除事件。
 *
 * 一旦监听到删除事件，重复2,3,4,5的步骤(递归)。
 */
public class ZKLockRW  {

    /**
     * 节点路径
     */
    protected String lockPath;

    /**
     * zk客户端
     */
    protected CuratorFramework zkClient;

    /**
     * 用于阻塞线程
     */
    private CountDownLatch countDownLatch=new CountDownLatch(1);


    private final static String WRITE_NAME="_W_LOCK";

    private final static String READ_NAME="_R_LOCK";


    public ZKLockRW(String lockPath, CuratorFramework client) {
        this.lockPath=lockPath;
        this.zkClient=client;
    }

    /**
     * 获取锁，如果获取失败一直阻塞
     * @throws Exception
     */
    public void lock() throws Exception {
        //创建节点
        String node = createNode();
        //阻塞等待获取锁
        tryLock(node);
        countDownLatch.await();
    }

    /**
     * 创建临时有序节点
     * @return
     * @throws Exception
     */
    private String createNode() throws Exception {
        //创建临时有序节点
       return zkClient.create()
                .withMode(CreateMode.EPHEMERAL_SEQUENTIAL)
                .withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE)
                .forPath(lockPath);
    }

    /**
     * 获取写锁
     * @return
     */
    public  ZKLockRW writeLock(){
        return new ZKLockRW(lockPath+WRITE_NAME,zkClient);
    }

    /**
     * 获取读锁
     * @return
     */
    public  ZKLockRW readLock(){
        return new ZKLockRW(lockPath+READ_NAME,zkClient);
    }

    private void tryLock(String nodePath) throws Exception {
        //获取所有的子节点
        List<String> childPaths = zkClient.getChildren()
                .forPath("/")
                .stream().sorted().map(o->"/"+o).collect(Collectors.toList());


        //第一个节点就是当前的锁，直接获取锁。递归结束的条件
        if (nodePath.equals(childPaths.get(0))){
            countDownLatch.countDown();
            return;
        }

        //1. 读锁：监听最前面的写锁，写锁释放了，自然能够读了
        if (nodePath.contains(READ_NAME)){
            //查找临近的写锁
            String preNode = getNearWriteNode(childPaths, childPaths.indexOf(nodePath));
            if (preNode==null){
                countDownLatch.countDown();
                return;
            }
            NodeCache nodeCache=new NodeCache(zkClient,preNode);
            nodeCache.start();
            ListenerContainer<NodeCacheListener> listenable = nodeCache.getListenable();
            listenable.addListener(() -> {
                //节点删除事件
                if (nodeCache.getCurrentData()==null){
                    //继续监听前一个节点
                    String nearWriteNode = getNearWriteNode(childPaths, childPaths.indexOf(preNode));
                    if (nearWriteNode==null){
                        countDownLatch.countDown();
                        return;
                    }
                    tryLock(nearWriteNode);
                }
            });
        }

        //如果是写锁，前面无论是什么锁都不能读，直接循环监听上一个节点即可，直到前面无锁
        if (nodePath.contains(WRITE_NAME)){
            String preNode = childPaths.get(childPaths.indexOf(nodePath) - 1);
            NodeCache nodeCache=new NodeCache(zkClient,preNode);
            nodeCache.start();
            ListenerContainer<NodeCacheListener> listenable = nodeCache.getListenable();
            listenable.addListener(() -> {
                //节点删除事件
                if (nodeCache.getCurrentData()==null){
                    //继续监听前一个节点
                    tryLock(childPaths.get(Math.max(childPaths.indexOf(preNode) - 1, 0)));
                }
            });
        }
    }

    /**
     * 查找临近的写节点
     * @param childPath 全部的子节点
     * @param index 右边界
     * @return
     */
    private String  getNearWriteNode(List<String> childPath,Integer index){
        for (int i = 0; i < index; i++) {
            String node = childPath.get(i);
            if (node.contains(WRITE_NAME)){
                return node;
            }

        }
        return null;
    }

}