package com.mzc.stream;

import java.util.Arrays;
import java.util.List;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: javajuc
 * @Package: com.mzc.stream
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/7/31 12:06
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/7/31 12:06
 * @UpdateRemark: The modified content
 * 编制部门 EPG 代码质量组
 * 批准日期 2020/04/07
 * 密级：内部
 * @Version: 1.0* @Version: 1.0
 * *
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved* Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/

/*
    题目要求：
    * 题目要求：一分钟内完成此题，只能用一行代码实现！
    * 现在有5个用户！筛选：
    * 1、ID 必须是偶数
    * 2、年龄必须大于23岁
    * 3、用户名转为大写字母
    * 4、用户名字母倒着排序
    * 5、只输出一个用户！
 */
public class Test01 {

    public static void main(String[] args) {
        User u1 = new User(1,"a",21);
        User u2 = new User(2,"b",22);
        User u3 = new User(3,"c",23);
        User u4 = new User(4,"d",24);
        User u5 = new User(6,"e",25);
        // 集合就是存储
        List<User> list = Arrays.asList(u1, u2, u3, u4, u5);

        //计算交给stream流
        //链式编程
        // lambda表达式、链式编程、函数式接口、Stream流式计算
        list.stream()
                .filter(u -> {return u.getId() %2 == 0;})//ID 必须是偶数
                .filter(u -> {return u.getAge() > 23;})//年龄必须大于23岁
                .map(u -> {return u.getName().toUpperCase();})//用户名转为大写字母
                .sorted((uu1,uu2) -> {return uu2.compareTo(uu1);})//用户名字母倒着排序
                .limit(1)//只输出一个用户！
                .forEach(System.out::println);
    }
}
