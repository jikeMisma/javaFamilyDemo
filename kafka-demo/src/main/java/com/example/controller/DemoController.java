package com.example.controller;

import com.example.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MaZhiCheng
 * @date 2021/6/14 - 16:48
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */

@RestController
public class DemoController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @RequestMapping("send")
    public String send(String msg){
        kafkaProducer.send("first",msg);
        return "发送成功！";
    }
}
