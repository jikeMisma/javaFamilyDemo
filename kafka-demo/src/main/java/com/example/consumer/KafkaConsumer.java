package com.example.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author MaZhiCheng
 * @date 2021/6/14 - 16:51
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */

@Component
public class KafkaConsumer {

    @KafkaListener(topics = {"first"})
    public void consumer(String message){
        System.out.printf("消费者接收到消息：%s",message);
    }

}
