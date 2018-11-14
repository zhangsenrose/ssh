package com.zhang.common.filter;

/**
 * Create By ZhangSenWei on 2018/11/13
 **/
 class BaseTwo {



     void print(){
         System.out.println("default修饰的类default修饰的方法被调用");
     }

     int age;
     String name;

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
