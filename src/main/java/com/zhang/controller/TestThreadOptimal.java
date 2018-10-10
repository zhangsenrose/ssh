package com.zhang.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Create By ZhangSenWei on 2018/9/19
 **/
public class TestThreadOptimal {

    private static final int loopNum = 1*10;


    public static void main(String[] args) {

        Thread testThreadPool = new Thread();

        List<String> list = new ArrayList<>();
        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
    }

    public void method1(List<String> list){
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i< list.size(); i++){
            final String str = list.get(i);
            System.out.println(list.get(i));
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        new Thread().sleep(1000);
                        System.out.println("[1]" + Thread.currentThread().getName()+"---" + str);
                    } catch (InterruptedException e) {
                    }
                }
            };
            pool.execute(runnable);
        }

        System.out.println("[1] done");
    }

}
