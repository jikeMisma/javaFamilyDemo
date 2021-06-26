package com.example.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author MaZhiCheng
 * @date 2021/6/14 - 16:46
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */


@Component
public class KafkaProducer {

    @Resource
    private KafkaTemplate<String,String> kafkaTemplate;

    public void send(String topic,String message){
        kafkaTemplate.send(topic,message);
    }
}
