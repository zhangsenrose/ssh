package com.zhang.controller;

import java.util.concurrent.*;

/**
 * Create By ZhangSenWei on 2018/10/16
 *  线程池的规则，为何使用线程池
 *
 *  线程池的线程执行规则跟任务队列有很大的关系。
 * 下面都假设任务队列没有大小限制：
 * 1. 如果线程数量<=核心线程数量，那么直接启动一个核心线程来执行任务，不会放入队列中。
 * 2. 如果线程数量>核心线程数，但<=最大线程数，并且任务队列是LinkedBlockingDeque的时候，超过核心线程数量的任务会放在任务队列中排队。
 * 3. 如果线程数量>核心线程数，但<=最大线程数，并且任务队列是SynchronousQueue的时候，线程池会创建新线程执行任务，这些任务也不会被放在任务队列中。这些线程属于非核心线程，在任务完成后，闲置时间达到了超时时间就会被清除。
 * 4. 如果线程数量>核心线程数，并且>最大线程数，当任务队列是LinkedBlockingDeque，会将超过核心线程的任务放在任务队列中排队。也就是当任务队列是LinkedBlockingDeque并且没有大小限制时，线程池的最大线程数设置是无效的，他的线程数最多不会超过核心线程数。
 * 5. 如果线程数量>核心线程数，并且>最大线程数，当任务队列是SynchronousQueue的时候，会因为线程池拒绝添加任务而抛出异常。
 * 任务队列大小有限时
 * 1. 当LinkedBlockingDeque塞满时，新增的任务会直接创建新线程来执行，当创建的线程数量超过最大线程数量时会抛异常。
 * 2. SynchronousQueue没有数量限制。因为他根本不保持这些任务，而是直接交给线程池去执行。当任务数量超过最大线程数时会直接抛异常。
 **/
public class Thread02 {

    public static void main(String[] args) throws InterruptedException {
        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + " run");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        /**验证1：LinkedBlockingDeque-------当LinkedBlockingDeque塞满时，
         * 新增的任务会直接创建线程来执行，当线程的数量大于最大线程数量时候会
         * 抛出异常（LinkedBlockingDeque默认是无穷大的，除非指定队列大小）**/
        //ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 6, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());

        /**验证2： SynchronousQueue --SynchronousQueue没有数量限制，因为它根本不保持这些任务，
         * 而是直接交给线程池去执行，当任务数量超过最大线程池数量会抛出异常。(核心线程数量6，最大线程数量10，超时时间为5秒) **/

        //ThreadPoolExecutor executor = new ThreadPoolExecutor(6,10,5,TimeUnit.SECONDS,new SynchronousQueue<Runnable>());

        /**验证3：核心线程3，最大线程6，超时时间为5，队列SynchronousQueue当队列是SynchronousQueue时，超出核心线程的任务会创建新的线程来执行，
         * 看到一共有6个线程。但是这些线程是费核心线程，收超时时间限制，在任务完成后限制超过5秒就会被回收。所以最后看到线程池还是只有三个线程。**/
        //ThreadPoolExecutor executor = new ThreadPoolExecutor(3,6,5,TimeUnit.SECONDS,new SynchronousQueue<Runnable>());

        /**验证4：核心线程3，最大线程4，队列是LinkedBlockingDeque，此时LinkedBlockingDeque根本不会受最大线程影响，直接放入队列中 **/
        //ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 4, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());

        /**验证5：如验证4，但是指定队列是LinkedBlockingDeque的大小为2,这是线程池创建了队列不能容纳的第六个线程为:非核线程池**/
        //ThreadPoolExecutor executor = new ThreadPoolExecutor(3,4,5,TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(2));

        /**验证6：将队列大小变为1,结果是创建第六个的时候出现了异常，因为创建第五个时候，是创建的非核心线程，当创建第六个的时候，线程池再次
         * 创建时候，超过最大线程数量4个，所以直接出现异常 **/
        //ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 4, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(1));

        /**验证7：核心线程数量3，最大线程数量4，队列是队列SynchronousQueue当队列是SynchronousQueue时同步队列
         *在创建第五个的线程时候抛出异常，因为同步队列不保存线程，当创建第五个的时候超过最大线程数量，抛出异常**/
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 4, 5, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());





        executor.execute(myRunnable);
        executor.execute(myRunnable);
        executor.execute(myRunnable);
        System.out.println("---先开三个---");
        System.out.println("核心线程数" + executor.getCorePoolSize());
        System.out.println("线程池线程数" + executor.getPoolSize());
        System.out.println("队列任务数" + executor.getQueue().size());
        executor.execute(myRunnable);
        executor.execute(myRunnable);
        executor.execute(myRunnable);
        System.out.println("---再开三个---");
        System.out.println("核心线程数" + executor.getCorePoolSize());
        System.out.println("线程池线程数" + executor.getPoolSize());
        System.out.println("队列任务数" + executor.getQueue().size());
        Thread.sleep(8000);
        System.out.println("----8秒之后----");
        System.out.println("核心线程数" + executor.getCorePoolSize());
        System.out.println("线程池线程数" + executor.getPoolSize());
        System.out.println("队列任务数" + executor.getQueue().size());

    }
}
