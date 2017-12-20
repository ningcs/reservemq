package com.example.demo.conf;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ningcs on 2017/10/30.
 */
@Configuration
public class SenderConf {
    @Bean
    public Queue queueOrder() {
        return new Queue("queueOrder1");
    }

    @Bean
    public Queue queueOrder2() {
        return new Queue("queueOrder2");
    }
}