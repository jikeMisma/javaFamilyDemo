package com.mzc.function;

import java.util.function.Consumer;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: javajuc
 * @Package: com.mzc.function
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/7/31 11:47
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/7/31 11:47
 * @UpdateRemark: The modified content
 * 编制部门 EPG 代码质量组
 * 批准日期 2020/04/07
 * 密级：内部
 * @Version: 1.0* @Version: 1.0
 * *
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved* Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/

/*
    Consumer接口：只有输入，没有返回值
 */
public class Demo03 {

    public static void main(String[] args) {
//        Consumer<String> consumer = new Consumer<String>() {
//            @Override
//            public void accept(String str) {
//                System.out.println(str);
//            }
//        };

        //使用lambda表达式简化
        Consumer<String> consumer = (str) -> {
            System.out.println(str);
        };

        consumer.accept("asg");
    }
}
