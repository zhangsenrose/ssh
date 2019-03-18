package com.zhang.personal.test.string;

/**
 * Create By ZhangSenWei on 2019/2/18
 **/
public class StringMethodsHandle {

    public static void main(String[] args) {
        String string = "qwehbnbbslddkflkjdkjfgjjhtu093473747637488sdhfjhd36747%%%**>><<kjdfkjdhfj--jhdfjgu";
        char c = string.charAt(0);
        System.out.println(c);
        String substring = string.substring(1, 3);
        System.out.println(substring);


        System.out.println(string.lastIndexOf("j"));

    }
}
