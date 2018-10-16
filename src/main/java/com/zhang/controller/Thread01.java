package com.zhang.controller;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Create By ZhangSenWei on 2018/10/16
 **/
public class Thread01 {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);
        List<String > strings = Lists.newArrayList();
        strings.add("AA");
        strings.add("BBBBB");
        for (final String s : strings){
            service.execute(new Runnable() {
                @Override
                public void run() {
                    delayTimeMethod(s);
                }
            });
        }
    }
    public static void delayTimeMethod(String s){
        for (int i=0; i< 100; i++){
            System.out.println("===" + s);
        }
    }

}
