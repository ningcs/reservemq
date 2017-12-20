package com.example.demo.controller;

import com.example.demo.dto.ProductInfo;
import com.example.demo.dto.ReserveInfo;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by ningcs on 2017/10/30.
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ResponseBody
    @RequestMapping(value = "/getReserveCount",method = {RequestMethod.GET, RequestMethod.POST})
    public ReserveInfo getReserveCount(Integer productId){
        return  productService.getReserveCount(productId);

    }

    @ResponseBody
    @RequestMapping(value = "/getProductList",method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String,Object> getProductList(Integer page,Integer page_size){
        return  productService.getProductList(page,page_size);
    }
    @ResponseBody
    @RequestMapping(value = "/getProductByProductId",method = {RequestMethod.GET, RequestMethod.POST})
    public ProductInfo getProductList(Integer productId){
        return  productService.getProduct(productId);
    }
}
