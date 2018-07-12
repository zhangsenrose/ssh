package com.zhang.common.utils;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Properties;

/**
 * Create By ZhangSenWei on 2018/7/12
 **/
public class FileProperties extends Properties {


    public FileProperties(Properties defaults) {
        super(defaults);
    }

    public FileProperties(String path) {

        try {
            Resource resource = new DefaultResourceLoader().getResource(path);
            load(resource.getInputStream());
        } catch (IOException e) {
            System.err.println("Exception in Fileproperties(String): "+ e.toString() + "for filename= " + path);
        }
    }

    public static void main(String[] args) {
        FileProperties fp = new FileProperties("/config.properties");
        System.out.println(fp.getProperty("send.url","000"));
    }

}
