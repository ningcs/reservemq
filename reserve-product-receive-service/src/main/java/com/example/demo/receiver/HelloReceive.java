package com.example.demo.receiver;

import com.example.demo.dto.OrderInfo;
import com.example.demo.service.ProductService;
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
    ProductService productService;
    @RabbitListener(queues="queueOrder1")    //监听器监听指定的Queue
    public void queueOrder1(OrderInfo orderInfo) {
        Integer count=0;
        if (orderInfo!=null){
            count=  productService.updateReserveCount(orderInfo.getBuyCount(),orderInfo.getProductId());
            log.info("Receive:队列：queueOrder1 商品名字："+orderInfo.getProductName()+",商品购买数量："+orderInfo.getBuyCount());
        }
    }

//    @RabbitListener(queues="queueOrder2")    //监听器监听指定的Queue
//    public void queueOrder2(OrderInfo orderInfo) {
//        Integer count=0;
//        if (orderInfo!=null){
//           count=  productService.updateReserveCount(orderInfo.getBuyCount(),orderInfo.getProductId());
//            log.info("Receive:队列：queueOrder2 商品名字："+orderInfo.getProductName()+",商品购买数量："+orderInfo.getBuyCount());
//        }
//    }

}