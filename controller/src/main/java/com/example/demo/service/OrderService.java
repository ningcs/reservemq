package com.example.demo.service;

import com.example.demo.dto.OrderInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ningcs on 2017/11/8.
 */
@FeignClient(value = "reserver-order-provider-service")
public interface OrderService {
    // 添加订单
    @RequestMapping(value = "/order/createOrder",method = RequestMethod.POST)
    public void createOrder(OrderInfo orderInfo);



}
