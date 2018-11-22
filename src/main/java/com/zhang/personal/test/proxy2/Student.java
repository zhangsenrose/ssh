package com.zhang.personal.test.proxy2;

/**
 * Create By ZhangSenWei on 2018/11/21
 **/
public class Student implements Person {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void giveMonry() {
        //花钱消耗了时间
              try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + "上交班费100元");

    }
}
