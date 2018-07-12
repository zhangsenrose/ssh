package com.zhang.common.utils;

/**
 * Create By ZhangSenWei on 2018/7/12
 **/
public class ConfigUtil {

    public ConfigUtil() {
    }

    private  static FileProperties SystemAttributes = new FileProperties("/config.properties");

    public static String getAttribute(String key){
        if (SystemAttributes != null){
            return SystemAttributes.getProperty(key);
        }else {
            return null;
        }
    }


    public static String getAttribute(String key, String defaultValue){
        if(SystemAttributes != null){
            return SystemAttributes.getProperty(key, defaultValue);
        }else {
            return null;
        }
    }




}
