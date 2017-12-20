package com.example.demo.controller;

import com.example.demo.dto.OrderInfo;
import com.example.demo.dto.ProductInfo;
import com.example.demo.service.OrderService;
import com.example.demo.service.ReserveService;
import com.example.demo.util.ResponseResult;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ningcs on 2017/10/30.
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    Logger logger = Logger.getLogger(getClass());

    @Autowired
    private ReserveService reserveService;

    @Autowired
    private OrderService orderService;

    //将lock声明为类的属性
    private Lock lock = new ReentrantLock();

    @RequestMapping(value = "/createOrder",method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ResponseResult createOrder(@RequestBody OrderInfo orderInfo)throws Exception{
        if (orderInfo.getBuyCount()==null || orderInfo.getBuyCount()<=0){
            return ResponseResult.errorResult("购买数量不能为空或为0");
        }
        DecimalFormat df = new DecimalFormat("#.00");
        ProductInfo productInfo = reserveService.getProductByProductId(orderInfo.getProductId());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
        //保留两位小数
        orderInfo.setMonetary("" + df.format(productInfo.getPrice() * orderInfo.getBuyCount()));
        orderInfo.setOrderId(getTenRandomLetter() + sdf.format(new Date()) + "_" + orderInfo.getUserId() + "_" + orderInfo.getProductId());
        orderInfo.setProductName(productInfo.getProductName());
//        lock.lock();
//        logger.info("获取锁...............");
        //获取不到锁，就等2秒，如果2秒后还是获取不到就返回false
        if (lock.tryLock(2000, TimeUnit.MILLISECONDS)) {
            logger.info("线程：" + Thread.currentThread().getName() + "获取锁...............");
            try {
                //创建订单 向库存系统 和物流系统发送消息
                orderService.addOrder(orderInfo);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                logger.info("线程：" + Thread.currentThread().getName() + "释放锁...............");
            }
        } else {
            logger.info("线程：" + Thread.currentThread().getName() + "获取锁失败...............");
            return ResponseResult.errorResult("获取锁失败");
        }

        return ResponseResult.successResult("生成订单成功");
    }

    /**
     * 从26为字母中获得一个6位随机数（纯字母）
     * ok
     */
    public static String getTenRandomLetter() {
        String word = "abcdefghijklmnopqrstuvwxyz";
        String tmp = "";

        for (int i = 0; i < 6; i++) {
            Random random = new Random();
            Integer index = random.nextInt(word.length());
            char c = word.charAt(index);
            tmp = tmp + c;
        }
        return tmp;
    }
}
