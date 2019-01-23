package com.get.example;

/**
 * Create By ZhangSenWei on 2019/1/17
 **/
public class InsertSort {

    public static void insertSort(int[] arr){
        int i, j ;

        for (i =1; i < arr.length; i++){

            //temp为循环插入列表中的数
            int temp = arr[i];

            //寻找temp插入的正确位置
            for (j = i-1; j >=0 && arr[j] > temp; j--){
                arr[j+1] = arr[j];
            }
            //插入temp
            arr[j+1] = temp;
            print(arr,arr.length,i);
        }
        printResult(arr,arr.length);
    }


    private static  void printResult(int[] a, int n){
        System.out.print("最终排序结果：");
        for(int j=0;j<n;j++){
            System.out.print(" "+a[j]);
        }
        System.out.println();
    }
    private static void print(int[] a, int n, int i) {
        System.out.print("第"+i+"次：");
        for(int j=0;j<n;j++){
            System.out.print(" "+a[j]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
            int[] arr = {8,4,9,23,13,9,66};
            insertSort(arr);
    }

}
