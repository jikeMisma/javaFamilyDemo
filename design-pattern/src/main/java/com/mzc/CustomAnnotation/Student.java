package com.mzc.CustomAnnotation;

import org.springframework.web.bind.annotation.CrossOrigin;

import java.lang.annotation.Documented;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: design-pattern
 * @Package: com.mzc.CustomAnnotation
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/4/8 13:56
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/4/8 13:56
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
public class Student {

    @CherryAnnotation(name = "My test", age = 19, score = {90, 98, 88})
    public void study(int times) {
        for (int i = 0; i < times; i++) {
            System.out.println("Good Good Study, Day Day Up!");
        }
    }

}