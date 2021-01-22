package com.mzc;

import com.mzc.pojo.MettingPub;
import com.mzc.service.MettingPubService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:consumer.xml"});
        context.start();

        MettingPubService bean = context.getBean(MettingPubService.class);

        //通过会议编号查询信息
        MettingPub mettingPub = bean.findByPcode("1001");

        System.out.println(mettingPub);

        System.in.read();

    }
}
