package com.get.example;

/**
 * Create By ZhangSenWei on 2019/1/17
 **/
public class MergerSort {


    public static void main(String[] args) {
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 50 };
        mergeSort(a, 0, a.length-1);
        System.out.println("排好序的数组：");
        for (int e : a)
            System.out.print(e+" ");
    }

    //两路归并算法，两个排好的子序合并为一个子序列
    public static void merge(int[] arr, int left, int mid,int right){
        //辅助数组
        int[] temp = new int[arr.length];
        //p1 p2是检测指针，k是存放指针
        int p1 = left, p2 = mid+1,k = left;

        while (p1 <= mid && p2 <=right){
            if (arr[p1] <= arr[p2]){
                temp[k++] = arr[p1++];
            }else {
                temp[k++] = arr[p2++];
            }
        }

        while (p1 <= mid)
            temp[k++] = arr[p1++];
        while (p2 <= right)
            temp[k++] = arr[p2++];

        //复制回原来数组
        for (int i =left; i < right; i++ ){
            arr[i] = temp[i];
        }
    }

    public static void mergeSort(int[] arr, int start, int end){
        //当元素只有一个元素的时候结束递归
        if (start < end){
            //划分子序列
            int mid = (start + end)/2;
            //对左侧子序列进行递归排序
            mergeSort(arr, start, mid);
            //对右侧子序列进行递归排序
            mergeSort(arr, mid+1, end);
            //合并
            merge(arr, start, mid, end);
        }
    }

}
