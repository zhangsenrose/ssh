package com.zhang.test.queueTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Create By ZhangSenWei on 2018/7/19
 **/
public class ExwcutorServiceTest02 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++){
            executorService.execute(new TestRunable());
            System.out.println("********* a" + i+ "*******");
        }
        executorService.shutdown();

    }
}
class TestRunable implements  Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程被调用了");
        while (true){
            try {
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
