package com.zhang.common;

import javax.security.auth.login.FailedLoginException;

/**
 * Create By ZhangSenWei on 2018/7/12
 * web接口统一返回格式
 **/
public class RespData {
    private Integer code;//标识码
    private String message;//提示信息
    private Object data;//数据

    public static final Integer SUCCESS_CODE = 200;
    public static final Integer FAIL_CODE = 400;

    public RespData() {
    }

    public RespData(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public RespData(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    //get and set

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    //others
    public static RespData success(String message){
        return new RespData(SUCCESS_CODE,message,null);
    }

    public static  RespData success(Integer code, String message,Object data){
        return new RespData(code,message,data);
    }

    public static RespData returnObject(Object object){
        return new RespData(SUCCESS_CODE,"success",object);
    }

    public static RespData fail(String message){
        return new RespData(FAIL_CODE,message);
    }

    public static RespData fail(Integer code,String message){
        return new RespData(code,message);
    }

    public static RespData fail(Integer code, String message, Object object){
        return new RespData(code, message, object);
    }
}
