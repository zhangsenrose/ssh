package com.zhang.common.filter;

/**
 * Create By ZhangSenWei on 2018/11/13
 **/
public class BaseProtected {


    protected void  print(){
        System.out.println("public修饰类protected的方法被调用");
    }

    protected int age;
    protected String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
