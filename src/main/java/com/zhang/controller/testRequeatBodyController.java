package com.zhang.controller;

import com.zhang.entity.TestL;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.xml.registry.infomodel.User;

/**
 * Create By ZhangSenWei on 2018/7/27
 **/
@Controller
public class testRequeatBodyController {


    @RequestMapping(value = "/accept", method = RequestMethod.GET)
    @ResponseBody
    public void accept(@RequestBody TestL testL){
        TestL t = new TestL();
        System.out.println(testL);
    }
}
