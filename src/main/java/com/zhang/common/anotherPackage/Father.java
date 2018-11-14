package com.zhang.common.anotherPackage;

/**
 * Create By ZhangSenWei on 2018/11/13
 * father的static方法能否被子类重写
 **/
public class Father {
    private int age;
    private String name;
    public void walk(){
        System.out.println("父亲会行走");
    }

    public static void say(){
        System.out.println("父亲会说话");
        Integer.parseInt("40");
    }

}
