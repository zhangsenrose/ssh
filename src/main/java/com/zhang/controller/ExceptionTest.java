package com.zhang.controller;

import com.zhang.helper.enums.RespDtoEnum;
import com.zhang.helper.expection.MyRuntimeException;
import sun.security.util.AuthResources_it;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Create By ZhangSenWei on 2018/10/16
 **/
public class ExceptionTest {


    public static void main(String[] args) {
        int[] arr = {1,2};
        try {
            int aException = arr[1];
            return;
        } catch (Exception e) {
            System.out.println("RunTimeException===异常");
        }finally {
            System.out.println("finally里面的代码执行");
        }
        boolean flag = false;
        System.out.println("========222");
        if (!flag){
            throw new MyRuntimeException(RespDtoEnum.MY_ERROR, "this flag is==" + flag);
        }
        System.out.println("=====888");
    }
}
