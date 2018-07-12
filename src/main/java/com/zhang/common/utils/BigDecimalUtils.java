package com.zhang.common.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Create By ZhangSenWei on 2018/7/12
 **/
public class BigDecimalUtils {

    public static final int DEFAULT_SCALE = 16;
    public static final RoundingMode DEFAULT_ROUNDING_MODE = RoundingMode.HALF_UP;


    /**
     *  BigDecimal加法
     * @param adds 加数
     * @return  和
     */
    public static BigDecimal add (double... adds){
        if (adds == null || adds.length == 0){
            return BigDecimal.ZERO;
        }
        BigDecimal result = BigDecimal.ZERO;
        for (double a : adds){
            result = result.add(BigDecimal.valueOf(a));
        }
        return result;
    }


    /**
     * BigDecimal减法运算
     * @param subs 只有第一为被减数 其余的都为减数
     * @return 差
     */
    public static BigDecimal sub(double... subs){
        if (subs == null || subs.length == 0){
            return BigDecimal.ZERO;
        }
        BigDecimal result = BigDecimal.valueOf(subs[0]);
        for (int n = 1; n < subs.length; n ++){
            result = result.subtract(BigDecimal.valueOf(subs[n]));
        }
        return result;
    }



    public static void main(String[] args) {
//        int a = 10;
//        int b = 20;
//        int c = 30;
//        int d = 60;
//        BigDecimal ba = new BigDecimal(a);
//        BigDecimal bb = new BigDecimal(b);
//        BigDecimal bc = new BigDecimal(c);
//        BigDecimal bd = new BigDecimal(d);
        double a= 10;
        double b = 50;

        System.out.println(add(a,b));





    }







}
