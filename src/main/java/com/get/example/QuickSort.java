package com.get.example;

/**
 * Create By ZhangSenWei on 2019/1/17
 **/
public class QuickSort {

    public static void quickSort(int[] arr, int low, int high){
        int i, j, temp, t;
        if (low > high){
            return;
        }
        i = low;
        j = high;
        //temp是基准位
        temp = arr[low];

        while (i < j){

            while (temp <= arr[j] && i < j){
                j--;
            }
            while (temp >= arr[i] && i < j){
                i++;
            }

            if (i < j){
                int z = arr[i];
                int y = arr[j];
                arr[j] = z;
                arr[i] = y;
            }
        }
        //基准位交换
        arr[low] = arr[i];
        arr[i] = temp;

        //递归调用
        quickSort(arr, low, j-1);
        quickSort(arr, j+1, high);
    }

    public static void main(String[] args) {
        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        quickSort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }





}
