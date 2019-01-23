package com.queue;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Create By ZhangSenWei on 2019/1/18
 **/
public class LinkedBlockingQueueT {

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>(1);
        linkedBlockingQueue.put("11");
    }
}
