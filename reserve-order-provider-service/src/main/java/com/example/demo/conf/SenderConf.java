package com.example.demo.conf;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ningcs on 2017/10/30.
 */
@Configuration
public class SenderConf {

    @Bean(name="delievery")
    public Queue queueDelievery() {
        return new Queue("queueWuLiu1");
    }

    @Bean(name="integral")
    public Queue queueIntegral() {
        return new Queue("queuejifen1");
    }

    @Bean(name="reserve")
    public Queue queueReserve() {
        return new Queue("queueOrder1");
    }

    @Bean
    public TopicExchange delieveryExchange() {
        return new TopicExchange("delievery");
    }

    @Bean
    public TopicExchange integralExchange() {
        return new TopicExchange("integral");
    }

    @Bean
    public TopicExchange reserveExchange() {
        return new TopicExchange("reserve");
    }

//    //积分采用广播形式
//    @Bean
//    FanoutExchange fanoutExchange() {
//        return new FanoutExchange("fanoutExchange");//配置广播路由器
//    }


    @Bean
    Binding bindingExchangeMessage(@Qualifier("delievery") Queue queueMessage, TopicExchange delieveryExchange) {
        return BindingBuilder.bind(queueMessage).to(delieveryExchange).with("*.delievery.#");
    }

    @Bean
    Binding bindingExchangeMessagesIntegral(@Qualifier("integral") Queue queueMessages, TopicExchange integralExchange) {
        return BindingBuilder.bind(queueMessages).to(integralExchange).with("*.integral.#");//*表示一个词,#表示零个或多个词
    }

    @Bean
    Binding bindingExchangeMessageReserve(@Qualifier("reserve") Queue queueMessagess, TopicExchange reserveExchange) {
        return BindingBuilder.bind(queueMessagess).to(reserveExchange).with("*.reserve.#");//*表示一个词,#表示零个或多个词
    }

//    @Bean
//    Binding bindingExchangeMessagess(@Qualifier("integral") Queue queueMessages, FanoutExchange fanoutExchange) {
//        return BindingBuilder.bind(queueMessages).to(fanoutExchange);
//    }

}