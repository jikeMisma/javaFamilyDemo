package com.mzc.function;

import java.util.function.Supplier;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: javajuc
 * @Package: com.mzc.function
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/7/31 11:51
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/7/31 11:51
 * @UpdateRemark: The modified content
 * 编制部门 EPG 代码质量组
 * 批准日期 2020/04/07
 * 密级：内部
 * @Version: 1.0* @Version: 1.0
 * *
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved* Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/

/*
    Supplier:供给型接口，没有参数，只有返回值
 */
public class Demo04 {

    public static void main(String[] args) {
//        Supplier supplier = new Supplier<Integer >() {
//            @Override
//            public Integer get() {
//                System.out.println("get()");
//                return 1024;
//            }
//        };

        Supplier supplier = () ->{return 1024;};
                //使用lambda简化


        System.out.println(supplier.get());
    }
}
