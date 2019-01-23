package com.designModes.lock;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 注意：添加zookeeper依赖是版本号应为 3.4.6，否则与logger版本号冲突
 * Create By ZhangSenWei on 2019/1/23
 *有效的解决了单点问题，不可重入问题，非阻塞问题以及锁无法释放问题，实现起来比较简单
 * 缺点：性能上并没有缓存服务器那么高，因为在每次创建锁和释放锁的过程中，都要动态创建，销毁临时节点来实现锁功能，ZK中创建和删除节点
 * 只能通过Leader服务器来执行，然后将数据同步到所有的Follower机器上，还需要对ZK的原理有所了解。
 *
 *
 **/
//基于zookeeper做分布式锁
public class DistributedLock implements Lock, Watcher {

    private ZooKeeper zk;
    //根
    private String root = "/locks";
    //竞争资源的标识
    private String lockName;
    //等待前一个锁
    private String waitNode;
    //当前锁
    private String myZnode;
    //计数器
    private CountDownLatch latch;
    private int sessionTimeout = 30000;
    private List<Exception> exception = new ArrayList<Exception>();


    /**
     * 创建分布式锁，使用前请确认config配置的zookeeper可用
     * @param config 例如：127.0.0.1：2181
     * @param lockName 竞争资源标志，不能包含单词lock
     */
    public DistributedLock(String config, String lockName){
        this.lockName = lockName;

        try {
            //创建一个与服务器的连接
            zk = new ZooKeeper(config, sessionTimeout, this);
            Stat stat = zk.exists(root, false);
            if (stat == null){
                //创建根节点
                zk.create(root, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
        } catch (IOException e) {
            exception.add(e);
        } catch (InterruptedException e) {
            exception.add(e);
        } catch (KeeperException e) {
            exception.add(e);
        }

    }

    /**
     * zookeeper的节点监视器
     * @param watchedEvent
     */
    @Override
    public void process(WatchedEvent watchedEvent) {
        if (this.latch != null){
            this.latch.countDown();
        }

    }


    @Override
    public void lock() {
        if (exception.size() > 0){
            //抛出异常，将异常集合的第一个异常抛出
        }

        if (this.tryLock()){
            System.out.println("Thread " + Thread.currentThread().getId() + " " +myZnode + " get lock true");
            return ;
        }else {
            //等待锁
            try {
                waitForLock(waitNode, sessionTimeout);

            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 获取锁
     * @return
     */
    @Override
    public boolean tryLock() {
        try {
            String splitStr = "_locl_";
            if (lockName.contains(splitStr)){
                //throw new LockException("lockName can not contains \\u000B");
                //创建临时子节点
                myZnode = zk.create(root + "/" + lockName + splitStr, new byte[0],ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL_SEQUENTIAL);
                System.out.println(myZnode + "is created!");
                //取出所有子节点
                List<String> subNodes = zk.getChildren(root, false);
                //取出所有lockName的锁
                List<String> lockObjNodes = new ArrayList<>();
                for (String node : subNodes){
                    String _node = node.split(splitStr)[0];
                    if (_node.equals(lockName)){
                        lockObjNodes.add(_node);
                    }
                }

                //排序
                Collections.sort(lockObjNodes);
                System.out.println(myZnode + "==" + lockObjNodes.get(0));
                if (myZnode.equals(root + "/" + lockObjNodes.get(0))){
                    //如果是最小的节点，则表示获取锁
                    return true;
                }
                //如果不是最小节点，则找到比自己小1的节点
                String subMyZnode = myZnode.substring(myZnode.lastIndexOf("/") + 1);
                waitNode = lockObjNodes.get(Collections.binarySearch(lockObjNodes, subMyZnode) -1);
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean waitForLock(String lower, long waitTime) throws KeeperException, InterruptedException {
        Stat stat = zk.exists(root + "/" + lower, true);
        //判断比自己小的节点是否存在，如果不存在则无需等待锁， 同时注册监听
        if (stat != null){
            System.out.println("Thread " + Thread.currentThread().getId() + " waiting for " + root + "/" + lower);
            this.latch = new CountDownLatch(1);
            this.latch.await(waitTime, TimeUnit.MILLISECONDS);
            this.latch = null;
        }
        return true;
    }


    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        try {
            if(this.tryLock()){
                return true;
            }
            return waitForLock(waitNode,time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }



    @Override
    public void lockInterruptibly() throws InterruptedException {
        this.lock();
    }




    @Override
    public void unlock() {
        try {
            System.out.println("unlock " + myZnode);
            zk.delete(myZnode,-1);
            myZnode = null;
            zk.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Condition newCondition() {
        return null;
    }

    public class LockException extends RuntimeException {
        private static final long serialVersionUID = 1L;
        public LockException(String e){
            super(e);
        }
        public LockException(Exception e){
            super(e);
        }
    }










    /**
     * 原理：上锁改为创建临时有序节点，每个上锁的节点均能创建节点成功，只是其序号不同。只有序号最小的可以拥有锁，如果这个节点序号不是最小的则 watch 序号比本身小的前一个节点 (公平锁)。
     * 步骤：
     *
     * 1.在 /lock 节点下创建一个有序临时节点 (EPHEMERAL_SEQUENTIAL)。
     * 2.判断创建的节点序号是否最小，如果是最小则获取锁成功。不是则取锁失败，然后 watch 序号比本身小的前一个节点。
     * 3.当取锁失败，设置 watch 后则等待 watch 事件到来后，再次判断是否序号最小。
     * 4.取锁成功则执行代码，最后释放锁（删除该节点）。
     * **/
}
