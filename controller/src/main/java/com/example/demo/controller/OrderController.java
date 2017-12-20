package com.example.demo.controller;

import com.example.demo.dto.OrderInfo;
import com.example.demo.service.OrderService;
import com.example.demo.until.ResponseResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ningcs on 2017/10/30.
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    Logger logger = Logger.getLogger(getClass());

    @Autowired
    private OrderService  orderService;

    @ApiOperation(value = "1",notes = "创建订单")
    @RequestMapping(value = "/getProductList",method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productId", paramType = "query",value = "商品id", required = true, dataType = "Integer",defaultValue = "1"),
            @ApiImplicitParam(name = "count", paramType = "query",value = "购买数量", required = true, dataType = "Integer",defaultValue = "1"),
            @ApiImplicitParam(name = "userId", paramType = "query",value = "用户id", required = true, dataType = "Integer",defaultValue = "1"),
            @ApiImplicitParam(name = "delivery", paramType = "query",value = "物流公司", required = true, dataType = "String",defaultValue = "顺丰公司"),
    })
    public ResponseResult getProductList(Integer productId,Integer  count,Integer userId,String delivery){
        OrderInfo orderInfo=new OrderInfo();
        orderInfo.setProductId(productId);
        orderInfo.setBuyCount(count);
        orderInfo.setUserId(userId);
        orderInfo.setDelivery(delivery);
        orderService.createOrder(orderInfo);
        return  ResponseResult.successResult("创建订单成功");
    }

}
