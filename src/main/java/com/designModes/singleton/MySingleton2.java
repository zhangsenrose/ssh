package com.designModes.singleton;

/**
 * Create By ZhangSenWei on 2019/1/16
 **/
//此时依然不是线程安全的，因为在实例化的时候会发生指令重排序
    //实例化的指令：分配内存空间，初始化对象，将对象执向刚分配的内存空间，发生指令重排序可能会最后初始化对象
    //当多线程的时候，可能会在同步方法的线程还没实例化对象，这个另一个线程获取了还没有完全实例化的对象。
    //所以说这是错误的双重校验锁
public class MySingleton2 {
    private static MySingleton2 mySingleton2 = null;

    private MySingleton2() {
    }

    public static MySingleton2 getInstance(){
        if (null == mySingleton2){
            synchronized (mySingleton2){
                mySingleton2 = new MySingleton2();
            }
        }
        return mySingleton2;
    }

}
