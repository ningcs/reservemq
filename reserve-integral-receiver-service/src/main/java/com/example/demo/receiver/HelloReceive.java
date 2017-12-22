package com.example.demo.receiver;

import com.example.demo.dto.OrderInfo;
import com.example.demo.service.IntegralService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ningcs on 2017/10/30.
 */
@Component
public class HelloReceive {
    Log log = LogFactory.getLog(getClass());

    @Autowired
    IntegralService integralService;
    @RabbitListener(queues="queuejifen1")    //监听器监听指定的Queue
    public void queueOrder1(OrderInfo orderInfo) {
        Integer count=0;
        if (orderInfo!=null){
            log.info("Receive:队列：queuejifen1 商品名字："+orderInfo.getProductName()+",商品购买数量："+orderInfo.getBuyCount());
            integralService.addIntegral(orderInfo);
        }
    }

//    @RabbitListener(queues="queuejifen2")    //监听器监听指定的Queue
//    public void queueOrder2(OrderInfo orderInfo) {
//        Integer count=0;
//        if (orderInfo!=null){
//            log.info("Receive:队列：queuejifen2 商品名字："+orderInfo.getProductName()+",商品购买数量："+orderInfo.getBuyCount());
//            integralService.addIntegral(orderInfo);
//        }
//    }

}