package com.zhang.personal.test.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Create By ZhangSenWei on 2018/11/21
 **/
public class StuInvocationHandle<T> implements InvocationHandler {

    //invocationHandle持有被代理的对象
    T target;

    public StuInvocationHandle(T target) {
        this.target = target;
    }

    /**
     *
     * @param proxy 动态代理对象
     * @param method 正在执行的方法
     * @param args 调用目标方法时候传入的实参
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理执行" + method.getName() + "方法");
        MonitorUtil.start();
        Object result = method.invoke(target, args);
        MonitorUtil.finish(method.getName());
        return result;
    }
}
