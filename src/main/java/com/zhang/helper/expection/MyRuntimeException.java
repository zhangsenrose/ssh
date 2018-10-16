package com.zhang.helper.expection;

import com.zhang.helper.enums.RespDtoEnum;

/**
 * Create By ZhangSenWei on 2018/10/16
 **/
public class MyRuntimeException extends RuntimeException {

    private static final long serialVersionUID = -9051224575302774431L;

    //错误码
    private String errorCode;

    //错误信息
    private String errorMessage;

    //异常
    private Throwable targetException;

    //业务对象
    private Object obj;


    public MyRuntimeException(RespDtoEnum respDtoEnum) {
        this.errorCode = respDtoEnum.getCode();
        this.errorMessage = respDtoEnum.getMessage();
    }

    public MyRuntimeException(RespDtoEnum respDtoEnum, Throwable targetException) {
        this(respDtoEnum);
        this.targetException = targetException;
    }

    public MyRuntimeException(RespDtoEnum respDtoEnum, Object obj) {
        this(respDtoEnum);
        this.obj = obj;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Throwable getTargetException() {
        return targetException;
    }

    public void setTargetException(Throwable targetException) {
        this.targetException = targetException;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    @Override
    public String getMessage() {
        return this.errorMessage;
    }
}
