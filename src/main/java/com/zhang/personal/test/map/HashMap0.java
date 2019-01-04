package com.zhang.personal.test.map;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Create By ZhangSenWei on 2018/11/22
 **/
public class HashMap0 {

    public static void main(String[] args) {
        Map<Integer,Object> map = new HashMap<>();
        Hashtable<String,Object> table = new Hashtable<>();
        String a = "111";
        /*map.put("1", "100");
        Object object = map.get("1");
        System.out.println(object);
        String string1 = "z";
        System.out.println(string1.hashCode());*/
        for (int i = 0; i<= 100000; i++){
            map.put(i, i);
        }

    }



    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++){
            int key = arr[i];
            int j = i-1;
            while (j >= 0 && key < arr[j]){
                arr[j+1] =  arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
}
