package com.zhang.helper.enums;

import com.alibaba.fastjson.JSONObject;

import javax.json.JsonObject;

/**
 * Create By ZhangSenWei on 2018/10/16
 **/
public enum RespDtoEnum {

    MY_ERROR("101", "自定义异常测试");

    String code;
    String message;

    RespDtoEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
