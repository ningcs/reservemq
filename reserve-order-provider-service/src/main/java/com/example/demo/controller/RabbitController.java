//package com.example.demo.controller;
//
//import com.example.demo.dto.OrderInfo;
//import com.example.demo.dto.ProductInfo;
//import com.example.demo.dto.ReserveInfo;
//import com.example.demo.service.OrderService;
//import com.example.demo.service.ReserveService;
//import com.example.demo.util.ResponseResult;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.text.DecimalFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Random;
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
///**
// * Created by ningcs on 2017/10/30.
// */
//@Controller
//@RequestMapping("rabbit")
//public class RabbitController {
//    Logger logger = Logger.getLogger(getClass());
//
//    @Autowired
//    private ReserveService reserveService;
//
//    @Autowired
//    private OrderService orderService;
//
//    //将lock声明为类的属性
//    private Lock lock = new ReentrantLock();
//
//
//    //
////    @RequestMapping(value = "/hello",method = {RequestMethod.GET, RequestMethod.POST})
////    public String helloSender(){
////        helloSender.send("hello,rabbit~");
////        return "发送成功";
////    }
//    @RequestMapping(value = "/createOrderPage",method = {RequestMethod.GET, RequestMethod.POST})
//    public ModelAndView createOrderPage(Integer productId){
//        productId=1;
//        ModelAndView modelAndView =new ModelAndView("/index");
//        //获取库存余量
//        ReserveInfo reserve =reserveService.getReserveCount(productId);
//        ProductInfo productInfo =orderService.getProductById(productId);
//        if (reserve!=null && product!=null){
//            modelAndView.addObject("total",reserve.getTotalCount()-reserve.getCurrentCount());
//            modelAndView.addObject("product",product);
//            modelAndView.addObject("userId",2);
//        }
//
//        return modelAndView;
//    }
//
//
//    @RequestMapping(value = "/createOrder",method = {RequestMethod.GET, RequestMethod.POST})
//    @ResponseBody
//    public ResponseResult createOrder(Integer productId, Integer  count,Integer userId)throws Exception{
//        if (count==null || count<=0){
//            return ResponseResult.errorResult("购买数量不能为空或为0");
//        }
//        Thread thread =new Thread();
//         DecimalFormat df   = new DecimalFormat("#.00");
//        Product product =orderService.getProductById(productId);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
//        OrderInfo orderInfo =new OrderInfo();
//        orderInfo.setProductId(productId);
//        orderInfo.setBuyCount(count);
//        orderInfo.setUserId(userId);
//        //保留两位小数
//        orderInfo.setMonetary(""+df.format(Double.parseDouble(product.getProductPrice())*count));
//        orderInfo.setOrderId(getTenRandomLetter()+sdf.format(new Date())+"_"+userId+"_"+productId);
//        orderInfo.setProductName(product.getProductName());
////        lock.lock();
////        logger.info("获取锁...............");
//
//        /**
//         * MICROSECONDS    微秒   一百万分之一秒（就是毫秒/1000）
//         MILLISECONDS    毫秒   千分之一秒
//         NANOSECONDS   毫微秒  十亿分之一秒（就是微秒/1000）
//         SECONDS          秒
//         MINUTES     分钟
//         HOURS      小时
//         DAYS      天
//         */
//        //获取不到锁，就等1秒，如果1秒后还是获取不到就返回false
//        if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
//            logger.info("线程："+Thread.currentThread().getName()+"获取锁...............");
//            try {
////            thread.sleep(5000);
//                //创建订单 向库存系统 和物流系统发送消息
//                orderService.addOrder(orderInfo);
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                lock.unlock();
//                logger.info("线程："+Thread.currentThread().getName()+"释放锁...............");
//            }
//        } else {
//            logger.info("线程："+Thread.currentThread().getName()+"获取锁失败...............");
//            return ResponseResult.errorResult("获取锁失败");
//        }
//
//        return ResponseResult.successResult("生成订单成功");
//    }
//
//    /**
//     * 从26为字母中获得一个6位随机数（纯字母）
//     * ok
//     */
//    public static String getTenRandomLetter() {
//        String word = "abcdefghijklmnopqrstuvwxyz";
//        String tmp = "";
//
//        for (int i = 0; i < 6; i++) {
//            Random random = new Random();
//            Integer index = random.nextInt(word.length());
//            char c = word.charAt(index);
//            tmp = tmp + c;
//        }
//        return tmp;
//    }
//}
