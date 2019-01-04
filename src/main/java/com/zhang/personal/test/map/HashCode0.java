package com.zhang.personal.test.map;

import java.util.Vector;

/**
 * Create By ZhangSenWei on 2018/11/22
 **/
public class HashCode0 {



    public  static  int hashCode1(char value[]){
         int hash = 0;
        int h = hash;
        if (h ==0 && value.length >0){
            char val[] = value;

            for (int i= 0; i< value.length; i++){
                h = 31 * h + val[i];
            }
        }
        return h;
    }

    public static void main(String[] args) {
        char value[] = {'z'};
        int hashcode = hashCode1(value);
        System.out.println(hashcode);

        Vector<String> vector = new Vector<>();
    }
}
