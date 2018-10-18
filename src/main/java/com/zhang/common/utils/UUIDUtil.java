package com.zhang.common.utils;

import java.text.SimpleDateFormat;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Create By ZhangSenWei on 2018/7/12
 **/
public class UUIDUtil {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    private static StringBuffer buf = new StringBuffer();

    //锁对象
    private static Lock lock= new ReentrantLock();


    /**
     * 随机产生32位16进制的字符串
     * @return
     */
    public static String getRandom32PK(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }




}
