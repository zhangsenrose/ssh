package com.zhang.personal.test.proxy;

import java.lang.reflect.Proxy;

/**
 * Create By ZhangSenWei on 2018/11/20
 **/
public class Client {
    public static void main(String[] args) {
        //动态代理
        Subject real = new RealSubject();
        DynamicProxy proxy = new DynamicProxy(real);
        ClassLoader classLoader = real.getClass().getClassLoader();
        /**
         * ClassLoader loader表示当前使用到的appClassloader
         * Class<?>[] interfaces表示目标对象实现的一组接口
         * InvocationHandler h表示当前的InvocationHandler实现实例对象
         * **/
        Subject subject = (Subject) Proxy.newProxyInstance(classLoader, new Class[]{Subject.class}, proxy);
        subject.visit();
    }
}
