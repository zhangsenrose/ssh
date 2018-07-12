package com.zhang.entity;

/**
 * Create By ZhangSenWei on 2018/7/12
 **/
public enum  StatusEnum {

    ALREADY_HANDLE(1,"已办理"),
    OVER_HAND(2,"已过期");



    public static StatusEnum fromValue(int value){
        for (StatusEnum s : StatusEnum.values())
            if (s.value == value)return  s;
            return null;
    }

    StatusEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    private  int value;
    private String desc;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }




}
