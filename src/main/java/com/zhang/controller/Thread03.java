package com.zhang.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Create By ZhangSenWei on 2018/10/17
 * 几种线程池的使用
 **/
public class Thread03 {

    public static void main(String[] args) {
        //缓存线程池
        /**通过源码发现
         * 1.核心线程为0，最大核心线程为最大值，可以理解为核心线程是没有限制的
         * 2.队列使用的是同步线程队列，即不会将线程放入队列
         * 3.闲置的线程超过60s，就会被销毁**/
        ExecutorService executorService = Executors.newCachedThreadPool();

        /**定长线程池
         *1.该线程池的最大线程数等于核心线程数
         * 2.该线程池的线程不会因为闲置而被销毁
         * 3.当需要执行的线程大于核心线程数量，该线程需要进入队列**/
        ExecutorService executorService1 = Executors.newFixedThreadPool(20);

        /**单例线程池
         * 1.核心线程池和最大线程数量都为1===有且只有一个线程工作
         * 2.队列为阻塞队列，所有任务按照入队出队规则**/
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();

        /**定时线程池 ScheduledThreadPool
         *DEFAULT_KEEPALIVE_MILLIS就是默认10L，这里就是10秒。
         * 这个线程池有点像是吧CachedThreadPool和FixedThreadPool 结合了一下。
         * 不仅设置了核心线程数，最大线程数也是Integer.MAX_VALUE。
         * 这个线程池是上述4个中为唯一个有延迟执行和周期执行任务的线程池。**/
        ExecutorService executorService3 = Executors.newScheduledThreadPool(10);

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程池的创建方式");
            }
        });
    }
}
