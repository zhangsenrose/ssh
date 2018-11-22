package com.zhang.personal.test.proxyCGLIB;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Create By ZhangSenWei on 2018/11/21
 **/
public class MyMethodInterceptor implements MethodInterceptor {

    //业务对象，供代理方法中进行真正的业务方法调用
    private Object target;

    public Object getInstance(Object target){
        this.target = target;
        //创建加强器，用来创建动态代理类
        Enhancer enhancer = new Enhancer();
        //为加强类指定要代理的业务对象（为下面生成的代理类指定父类）
        enhancer.setSuperclass(this.target.getClass());
        //设置回调
        enhancer.setCallback(this);

        return enhancer.create();
    }

    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("预处理--------------");
        proxy.invokeSuper(object, args);
        System.out.println("调用后操作----------------");
        return null;
    }
}
