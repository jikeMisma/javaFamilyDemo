package com.mzc.CreativeModel.PrototypePattern;

/**
 * @author MaZhiCheng
 * @date 2021/6/3 - 22:29
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */

import java.util.Random;

/**
 * 场景类
 */
public class Client {
    //发送账单的数量，这个值是从数据库获得
    private static int Max_COUNT = 6;

    public static void main(String[] args) {
        //模拟发送邮件
        int i = 0;
        //把模板定义出来，这个是从数据库获得
        Mail mail = new Mail(new AdvTemplate());
        mail.setTail("XXX银行版权所有！");
        while (i < Max_COUNT){
            //以下是没封邮件不同的地方
            mail.setAppellation(getRandString(5)+" 先生(女士)");
            mail.setReceiver(getRandString(5)+"@"+getRandString(8)+".com");
            //然后发送邮件
            sendMain(mail);
            i++;
        }
    }

    //发送邮件
    private static void sendMain(Mail mail) {
        System.out.println("标题：" + mail.getSubject() + "\t收件人：" + mail.getReceiver() + "\t...发送成功！");
    }
    //获得指定长度的随机字符串
    private static String getRandString(int maxLength) {
        String source = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuffer sb = new StringBuffer();
        Random rand = new Random();
        for(int i = 0;i < maxLength;i++){
            sb.append(source.charAt(rand.nextInt(source.length())));
        }
        return sb.toString();
    }

}
