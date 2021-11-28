package com.blazings.suanfa.component.fastjson;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class MyFastjson {
    public static void Fun() {
        User user = new User();
        user.setName("校长");
        user.setAge(3);
        user.setSalary(new BigDecimal("123456789.0123"));
        User user2 = new User();
        user2.setName("校长23232323");
        user2.setAge(32323233);
        user2.setSalary(new BigDecimal("1313232323123456789.0123"));

//        String toJSONString = JSON.toJSONString(user);
//        System.out.println(toJSONString);
//        User jsonObjecUser = JSON.parseObject(toJSONString,User.class);
//        System.out.println(jsonObjecUser);
//        toJSONString+="]";
//        toJSONString = "["+toJSONString;
//        List<User> user1 = JSON.parseArray(toJSONString, User.class);
//        System.out.println(user1);

        Map<String,User> maps = Maps.newHashMap();
        maps.put("张三", user);
        maps.put("李四", user2);
        String jsonStringMaps = JSON.toJSONString(maps);
        System.out.println(jsonStringMaps);
        Map<String,User> parseObject = JSON.parseObject(jsonStringMaps, Map.class);
        System.out.println(parseObject);

        List<Map<String, User>> listMap = Lists.newArrayList();
        listMap.add(maps);
        String toJSONString = JSON.toJSONString(listMap);
        System.out.println(toJSONString);

        List<Map<String, User>> lists = JSON.parseObject(toJSONString, List.class);
        System.out.println(lists);
    }

    @Data
    private static class User {
        String name;
        int age;
        BigDecimal salary;
    }
}
