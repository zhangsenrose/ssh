package com.zhang.personal.test.proxy;

/**
 * Create By ZhangSenWei on 2018/11/20
 **/

/**
 * 静态代理，代理类和目标对象都实现同一个接口
 */
public class PproxySubject implements Subject {

    private Subject subject;

    public PproxySubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void visit() {
        subject.visit();
    }
}
