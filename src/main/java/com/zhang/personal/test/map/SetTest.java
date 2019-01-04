package com.zhang.personal.test.map;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.junit.platform.commons.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Create By ZhangSenWei on 2018/11/26
 **/
public class SetTest {

    public static void main(String[] args) {
       /* Map<Integer, String> carsMap = Maps.newTreeMap();
        carsMap.put(20, "zhangsenwei");
        carsMap.put(23, "zhangsenwei");
        carsMap.put(26, "zhangsenwei");
        carsMap.put(29, "zsw");
        carsMap.put(32, "zsw");
        Set<Map.Entry<Integer, String>> set = carsMap.entrySet();
        List<Map.Entry<Integer, String>> list = Lists.newArrayList(set);
        for (int i=0; i < list.size(); i++){
            int key = list.get(i).getKey();
            String value = list.get(i).getValue();
            if (StringUtils.isBlank(value)){
                continue;
            }
            for (int j = i + 1; j < list.size(); j++){
                int next_key = list.get(j).getKey();
                String next_value = list.get(j).getValue();
                if (next_value.equals(value)){
                    System.out.println("删除了key " + next_key);
                    list.get(j).setValue("");
                }
            }
        }

        System.out.println(JSON.toJSONString(list));*/


        //ConcurrentHashMap
        String personName = "zhangsenwei";
        String content = (personName == null?"": personName) + "====张森为";
        System.out.println(content);

        List<String> car = Lists.newArrayList();
        car.add("惊与223334");
        car.add("kjdfAASSO");
        car.add("sdmfklkl");

        String carString = listToString(car, ",");
        System.out.println(carString);


    }

    public static String listToString(List list, String separator) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append(separator);
        }
        return sb.toString().substring(0,sb.toString().length()-1);
    }
}
