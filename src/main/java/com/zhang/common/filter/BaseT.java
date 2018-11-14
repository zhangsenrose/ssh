package com.zhang.common.filter;

import org.springframework.context.annotation.Primary;

/**
 * Create By ZhangSenWei on 2018/11/13
 **/
public class BaseT {

    public void print(){
        System.out.println("public中的public方法被调用");
    }

    public String name;
    public int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
