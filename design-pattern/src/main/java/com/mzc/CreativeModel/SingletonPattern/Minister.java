package com.mzc.CreativeModel.SingletonPattern;

/**
 * 臣子类
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: design-pattern
 * @Package: com.mzc.CreativeModel.SingletonPattern
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/4/9 9:24
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/4/9 9:24
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
public class Minister {

    public static void main(String[] args) {
        for (int day = 0; day < 3; day++) {
            Emperor emperor = Emperor.getInstance();
            emperor.say();
        }
    }
}