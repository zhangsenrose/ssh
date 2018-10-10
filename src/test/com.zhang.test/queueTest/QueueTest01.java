package com.zhang.test.queueTest;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.concurrent.*;

/**
 * Create By ZhangSenWei on 2018/7/19
 **/
public class QueueTest01 {

    private final int QUEUE_LENGTH = 10000 * 10;
    //基于内存的阻塞队列
    BlockingQueue<String> queue = new LinkedBlockingDeque<>(QUEUE_LENGTH);
    //创建计划任务执行器
    private ScheduledExecutorService es = Executors.newScheduledThreadPool(1);

    public QueueTest01(){
        execute();
    }

    //添加消息到队列中
    public void addQueue(String contnt){
        queue.add(contnt);
    }


    /**
     * 初始化执行
     */
    public void execute(){
        //每一分执行一次
        es.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                try {
                    String content = queue.take();
                    //处理队列中的消息
                    System.out.println(content);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }, 0, 1, TimeUnit.MINUTES);

    }

    public static void main(String[] args) {
        String content = "基于内存的阻塞队列1"+new Date();
        String content2 = "基于内存的阻塞队列2"+new Date();
        String content3 = "基于内存的阻塞队列3"+new Date();
        QueueTest01 queueTest01 = new QueueTest01();
        queueTest01.addQueue(content);
        queueTest01.addQueue(content2);
        queueTest01.addQueue(content3);
    }

}
