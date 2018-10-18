package com.zhang.test.queueTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Create By ZhangSenWei on 2018/7/19
 * 测试线程池的submit方法
 **/
public class ExecutorServiceTest01 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> resultList = new ArrayList<Future<String>>();

        //创建10个任务并执行
        for (int i = 0; i < 10; i++){
            //使用ExecutorService执行Callable类型的任务，并将返回的结果存在future变量中
            Future<String> future = executorService.submit(new TaskWithResult(i));
            //将任务集合存储到list中
            resultList.add(future);
        }
        executorService.shutdownNow();

        //遍历任务的结果
        for (Future<String> fs : resultList){
            try {
                //打印各个线程执行的结果
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
                return;
            }
        }



    }
}
class TaskWithResult implements Callable<String>{

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }


    /**
     * 任务的具体过程，一旦任务传给executorService的submit方法，则自动在一个线程上执行
     *
     * @return
     * @throws Exception
     */
    @Override
    public String call() throws Exception {
        System.out.println("call()方法被调用，干活..." + Thread.currentThread().getName());
        if (new Random().nextBoolean())
            throw new TaskException("Meet error in task" + Thread.currentThread().getName());
            //一个模拟耗时的操作
            for (int i = 999999999;i > 0; i--);
            return "call() 方法被自动调用，任务的结是" + id + "  "+ Thread.currentThread().getName();
    }
}


class TaskException extends  Exception{
    public TaskException(String message) {
        super(message);
    }
}