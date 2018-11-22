package com.zhang.personal.test;

/**
 * Create By ZhangSenWei on 2018/11/19
 **/

/**
 * 插入排序得研究
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {2,90,77,4,25,88};
            arr = insertSort(arr);
            for (int i : arr){
                System.out.print(i+",");
        }
    }


    public static int[]  insertSort(int[] arr){
        int i,j,key;
        for (i = 1; i < arr.length; i++){
            key = arr[i];
            j = i-1;
            while ( j >= 0 && arr[j] > key){
                arr[j+1]  = arr[j];
                j--;
            }
            arr[j+1] = key;
        }

        return arr;
    }
}

