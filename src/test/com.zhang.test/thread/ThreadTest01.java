package com.zhang.test.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的三种方式
 * Create By ZhangSenWei on 2018/7/20
 **/
public class ThreadTest01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Thread t1 = new Thread(){
            public void run(){
                System.out.println("new Thread 1");
            }
        };
        t1.start();
        System.out.println(t1.getName());





        //2
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("new Thread2");
            }
        });
        t2.start();
        System.out.println(Thread.currentThread().getName());




        //3
        FutureTask<String> ft = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("new Thread3");
                return "aaa";

            }
        });

        Thread t3 = new Thread(ft);
        t3.start();
        String result = ft.get();
        System.out.println(result);




    }

}
