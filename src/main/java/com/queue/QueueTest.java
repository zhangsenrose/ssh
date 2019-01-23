package com.queue;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Create By ZhangSenWei on 2019/1/17
 **/
//add一个元素，如果队列已满，则抛出异常，offer添加元素，队列满，则返回false,put添加元素，如果队列满，则阻塞
public class QueueTest {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue queue = new ArrayBlockingQueue(3);
        String a = "zhangsenwei";
        String b = "zy";
        String c = "aaa";
        queue.add(a);
        queue.add(b);
        queue.add(c);
        queue.put("33333");
    }
}
