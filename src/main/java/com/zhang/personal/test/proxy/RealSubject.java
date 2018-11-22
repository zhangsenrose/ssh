package com.zhang.personal.test.proxy;

/**
 * Create By ZhangSenWei on 2018/11/20
 **/
public class RealSubject implements Subject {

    private String name="realSubject";
    @Override
    public void visit() {
        System.out.println(name);
    }
}
