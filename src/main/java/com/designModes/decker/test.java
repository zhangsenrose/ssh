package com.designModes.decker;

/**
 * Create By ZhangSenWei on 2019/1/25
 **/
public class test {
    public static void main(String[] args) {
        Man man = new Man();
        ManDecoratorA m1 = new ManDecoratorA();
        ManDecoratorB m2 = new ManDecoratorB();


        m1.setPerson(man);
        m2.setPerson(man);
        m1.eat();
//        m2.eat();
    }
}
