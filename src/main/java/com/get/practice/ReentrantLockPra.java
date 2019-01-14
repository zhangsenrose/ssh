package com.get.practice;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Create By ZhangSenWei on 2019/1/4
 **/
public class ReentrantLockPra {

    public static void main(String[] args) {
        //实现公平锁，只要资源被其他线程占用，公平锁就会将线程加入sync的queue尾部，而不是尝试获取锁
        Lock lock = new ReentrantLock(true);
        //Lock lock = new ReentrantLock();
        MyThread t1 = new MyThread("t1", lock);
        MyThread t2 = new MyThread("t2", lock);
        MyThread t3 = new MyThread("t3", lock);

        t1.start();
        t2.start();
        t3.start();

    }
}


class MyThread extends Thread{
    private Lock lock;

    public MyThread(String name, Lock lock) {
        super(name);
        this.lock = lock;
    }

    public void  run(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread() + "Running");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }finally {
            lock.unlock();
        }

    }


}
