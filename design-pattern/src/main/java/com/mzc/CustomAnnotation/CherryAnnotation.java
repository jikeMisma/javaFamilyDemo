package com.mzc.CustomAnnotation;

import java.lang.annotation.*;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: design-pattern
 * @Package: com.mzc.CustomAnnotation
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/4/8 13:54
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/4/8 13:54
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/

@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD})
@Documented
public @interface CherryAnnotation {

    String name();
    int age() default 18;
    int[] score();

}
