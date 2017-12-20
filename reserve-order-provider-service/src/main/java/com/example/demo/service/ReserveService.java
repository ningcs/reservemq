package com.example.demo.service;

import com.example.demo.dto.ProductInfo;
import com.example.demo.dto.ReserveInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by ningcs on 2017/11/8.
 */
@FeignClient(value = "reserve-product-receive-service")
public interface ReserveService {
    // 获取文件
    @RequestMapping(value = "/product/getReserveCount",method = RequestMethod.POST)
    public ReserveInfo getReserveCount(@RequestParam(value = "productId") Integer productId);

    //获取商品信息
    @RequestMapping(value = "/product/getProductByProductId",method = RequestMethod.POST)
    public ProductInfo getProductByProductId(@RequestParam(value = "productId")Integer productId);
}
