package com.mzc.BehavioralModel.TemplateMethodPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/**
 * 场景类
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: design-pattern
 * @Package: com.mzc.BehavioralModel.TemplateMethodPattern
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/4/2 9:04
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/4/2 9:04
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
public class Client {

    private BigDecimal count;
    public static void main(String[] args) throws IOException {
        System.out.println("-------------H1型号悍马-------------");
        System.out.println("H1型号悍马是否需要喇叭声响？0-不需要   1-需要");
        String type = (new BufferedReader(new InputStreamReader(System.in))).readLine();
        HummerModel h1 = new HummerH1Model();
        if(type.equals("0")){
            ((HummerH1Model) h1).setAlarm(false);
        }
        h1.run();

        System.out.println("-------------H2型号悍马-------------");
        HummerModel h2 = new HummerH2Model();
        h2.run();

    }
}