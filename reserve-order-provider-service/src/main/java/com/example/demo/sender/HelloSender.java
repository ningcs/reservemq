package com.example.demo.sender;

import com.example.demo.dto.OrderInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ningcs on 2017/10/30.
 */
@Component
public class HelloSender {
    @Autowired
    private AmqpTemplate template;

    Log logger =LogFactory.getLog(getClass());

//    public void send(Message message) {
//        boolean checkResult=getRandom();
//        if (checkResult){
//            logger.info(message.getBody());
//            template.convertAndSend("queueOrder1",message.getBody());
//        }else {
//            logger.info(message.getBody());
//            template.convertAndSend("queueOrder2",message.getBody());
//        }
//
//    }

    public void send(OrderInfo orderInfo) {

        logger.info(orderInfo);
        //向库存系统发送消息
        template.convertAndSend("reserve", "product.reserve.event", orderInfo);
//            template.convertAndSend("queueOrder1",orderInfo);
            //向物流系统发送消息
//            template.convertAndSend("queueWuLiu1",orderInfo);
        template.convertAndSend("delievery", "product.delievery.event", orderInfo);
            //向积分系统发送消息
//            template.convertAndSend("queuejifen1",orderInfo);
        template.convertAndSend("integral", "product.integral.event", orderInfo);




    }

}