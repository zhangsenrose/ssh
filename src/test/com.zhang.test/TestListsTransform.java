package com.zhang.test;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.zhang.test.testVo.Avo;
import com.zhang.test.testVo.Bvo;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * Create By ZhangSenWei on 2018/7/19
 * 测试lists.transform语句
 **/

public class TestListsTransform {

    public static void main(String[] args) {
        List<Avo> avos = Lists.newArrayList();
        Avo avo = new Avo();
        avo.setId(1);
        avo.setAge(10);
        avo.setName("彰化");
        avo.setSex("男");
        Avo avo1 = new Avo();
        avo1.setSex("女");
        avo1.setName("丽丽");
        avo1.setAge(18);
        avo1.setId(2);
        avos.add(avo);
        avos.add(avo1);

        List<Bvo> bvos = Lists.newArrayList();

        System.out.println("没有lists.transform转化的Bvo" + bvos);
        //lists复杂转化
        List<Bvo> bvoList = CollectionUtils.isNotEmpty(avos) ? Lists.transform(avos, new Function<Avo, Bvo>() {
            @Override
            public Bvo apply(Avo input) {
                Bvo bvo = JSON.parseObject(JSON.toJSONString(input),Bvo.class);
                return bvo;
            }
        }) : null;

        System.out.println(bvoList);







    }

}
