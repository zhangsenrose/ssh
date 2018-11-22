package com.zhang.personal.test.proxy2;

/**
 * Create By ZhangSenWei on 2018/11/21
 **/
public class MonitorUtil {


    private static ThreadLocal<Long> t1 = new ThreadLocal<>();

    public static void start(){
        t1.set(System.currentTimeMillis());
    }

    //结束打印耗时
    public static void finish(String methodName){
        long finishTime = System.currentTimeMillis();
        System.out.println(methodName + "方法耗时" +(finishTime - t1.get())+ "ms");
    }

}
