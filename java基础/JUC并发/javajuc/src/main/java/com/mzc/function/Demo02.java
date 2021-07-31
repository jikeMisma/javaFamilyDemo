package com.mzc.function;

import java.util.function.Predicate;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: javajuc
 * @Package: com.mzc.function
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/7/31 11:39
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/7/31 11:39
 * @UpdateRemark: The modified content
 * 编制部门 EPG 代码质量组
 * 批准日期 2020/04/07
 * 密级：内部
 * @Version: 1.0* @Version: 1.0
 * *
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved* Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/

/*
    段定型接口：有一个输入参数，返回值只能是boolean值
 */
public class Demo02 {

    public static void main(String[] args) {
        //判断字符串是否为空
//        Predicate<String> predicate = new Predicate<String>() {
//            @Override
//            public boolean test(String str) {
//                if(str.isEmpty()){
//                    return true;
//                }else{
//                    return false;
//                }
//            }
//        };

        //使用lambda表达式简化
        Predicate<String> predicate = (str) -> {return str.isEmpty();};

        System.out.println(predicate.test("123"));
        System.out.println(predicate.test(""));
    }
}
