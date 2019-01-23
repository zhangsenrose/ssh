package com.designModes.singleton;

/**
 * Create By ZhangSenWei on 2019/1/16
 **/
//标准懒汉式，私有的静态类变量，私有的构造方法，只有一个public的获取实例的方法发
public class MySingleton {
    private static MySingleton mySingleton = null;
    private MySingleton() {
    }
    public static MySingleton getInstance(){
        if (null == mySingleton){
            mySingleton = new MySingleton();
        }
        return mySingleton;
    }
}
