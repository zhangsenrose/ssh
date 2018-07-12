package com.zhang.common.utils;

import javax.validation.constraints.Max;
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

    /**
     *  BigDecimal乘法运算
     * @param muls 乘数
     * @return  积
     */
    public static BigDecimal mul(double... muls){
        if (muls == null || muls.length == 0){
            return BigDecimal.ZERO;
        }
        BigDecimal result =  BigDecimal.valueOf(1);
        for (double a : muls){
            result = result.multiply(BigDecimal.valueOf(a));
        }
        return result;
    }


    /**
     * BigDecimal除法运算
     * @param divs 只有第一个是被除数，其余全为除数
     * @return 商
     */
    public static BigDecimal div(BigDecimal... divs){
        if (divs == null || divs.length == 0){
            return BigDecimal.ZERO;
        }
        BigDecimal result = divs[0];
        for (int  n = 1, max = divs.length; n <max; n++ ){
            result = result.divide(divs[n], DEFAULT_SCALE,DEFAULT_ROUNDING_MODE);
        }
        return result;
    }

    /**
     * 判断是否为null值
     * @param b
     * @return
     */
    public static BigDecimal checkAndSetDefault(BigDecimal b){
        if (b == null){
            return BigDecimal.ZERO;
        }
        b = b.setScale(2,BigDecimal.ROUND_UP);
        return  b;
    }



    public static void main(String[] args) {

        double a= 10;
        double b = 50;

        System.out.println(add(a,b));





    }







}
