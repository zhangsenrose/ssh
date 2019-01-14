package com.get.practice;

/**
 * Create By ZhangSenWei on 2019/1/11
 **/
public class SyntacticSugarTest {

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a+b));
        System.out.println(c.equals((a+b)));
        //隐式转型，无需强转
        System.out.println(g == (a+b));
        //false
        System.out.println(g.equals((a+b)));

    }
}
