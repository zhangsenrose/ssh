package com.zhang.controller;

import java.util.Queue;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;

/**
 * Create By ZhangSenWei on 2018/10/9
 **/
public class QueuePractice {

    BlockingQueue<String> basket = new ArrayBlockingQueue<String>(3);


    public void produce() throws InterruptedException {
        basket.put("An apple");
    }

    public String consume() throws InterruptedException {
        String apple = basket.take();
        return apple;
    }

    public int getAppleNumber(){
        return basket.size();
    }



    public static void testBasket(){

        final QueuePractice basket = new QueuePractice();

        class Producer implements Runnable{
            @Override
            public void run() {
                try {
                    while (true){
                        System.out.println("生产者准备生产苹果： " + System.currentTimeMillis());
                    basket.produce();
                    System.out.println("生产者准备生产苹果完毕： " + System.currentTimeMillis());
                    System.out.println("生产后得苹果有： "+ basket.getAppleNumber()+" 个");
                    Thread.sleep(300);
                }
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

        class Consumer implements Runnable{
            @Override
            public void run() {
                try {
                    while (true){
                        System.out.println("消费者消费苹果：" + System.currentTimeMillis());
                        basket.consume();
                        System.out.println("消费者消费苹果完毕：" + System.currentTimeMillis());
                        System.out.println("消费后得苹果有：" + basket.getAppleNumber()+" 个");
                        Thread.sleep(1000);
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }


        ExecutorService service = Executors.newCachedThreadPool();
        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        service.submit(producer);
        service.submit(consumer);
        //程序运行10s
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.shutdownNow();
    }

    public static void main(String[] args) {
        QueuePractice.testBasket();
    }



}
