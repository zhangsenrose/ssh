package com.designModes.singleton;

/**
 * Create By ZhangSenWei on 2019/1/16
 **/
//加个volidate关键字报纸该对象实例的可见性，就不会出现多线不安全了，也就是我们所说的DCL（double checking locking）
public class MySingleton3 {
    private static volatile MySingleton3 mySingleton3 = null;

    private MySingleton3() {
    }

    public static MySingleton3 getInstance(){
        if (null == mySingleton3){
            synchronized (mySingleton3){
                mySingleton3 = new MySingleton3();
            }
        }
        return mySingleton3;
    }
}
