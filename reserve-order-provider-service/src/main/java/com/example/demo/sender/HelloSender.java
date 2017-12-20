package com.example.demo.sender;

import com.example.demo.dto.OrderInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

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
        boolean checkResult=getRandom();
        if (checkResult){
            logger.info(orderInfo);
            //向库存系统发送消息
            template.convertAndSend("queueOrder1",orderInfo);
            //向物流系统发送消息
            template.convertAndSend("queueWuLiu1",orderInfo);
            //向积分系统发送消息
            template.convertAndSend("queuejifen1",orderInfo);
        }else {
            logger.info(orderInfo);
            //向库存系统发送消息
            template.convertAndSend("queueOrder2",orderInfo);
            //向物流系统发送消息
            template.convertAndSend("queueWuLiu2",orderInfo);
            //向积分系统发送消息
            template.convertAndSend("queuejifen2",orderInfo);
        }

    }
    private boolean getRandom(){
        Random random = new Random();
        Integer result =random.nextInt(10000);
        boolean checkResult =false;
        if (result%2==0){
            checkResult=true;
        }
        return checkResult;
    }
}