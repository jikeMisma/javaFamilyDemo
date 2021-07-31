package com.mzc.function;

import java.util.function.Function;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: javajuc
 * @Package: com.mzc.function
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/7/31 11:30
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/7/31 11:30
 * @UpdateRemark: The modified content
 * 编制部门 EPG 代码质量组
 * 批准日期 2020/04/07
 * 密级：内部
 * @Version: 1.0* @Version: 1.0
 * *
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved* Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/

/*
    Function：函数型接口，有一个输入参数，有一个输出参数
    只要是函数式接口，就可以用lambda表达式简化
 */
public class Demo01 {

    public static void main(String[] args) {
        //工具方法，输出输入的值
//        Function function = new Function<String,String>() {
//            @Override
//            public String apply(String str) {
//                return str;
//            }
//        };

        //使用lambda简化函数式接口
        Function function = (str) -> {return str;};

        System.out.println(function.apply("123"));//返回123
    }
}
