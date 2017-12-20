package com.example.demo.controller;

import com.example.demo.service.ReserveService;
import com.example.demo.until.ResponseResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ningcs on 2017/10/30.
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    Logger logger = Logger.getLogger(getClass());

    @Autowired
    private ReserveService reserveService;

    @ApiOperation(value = "1",notes = "获取商品列表")
    @RequestMapping(value = "/getProductList",method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", paramType = "query",value = "页数", required = true, dataType = "String",defaultValue = "1"),
            @ApiImplicitParam(name = "page_size", paramType = "query",value = "条数", required = true, dataType = "String",defaultValue = "10"),
    })
    public ResponseResult getProductList(Integer page, Integer page_size){
        return  new ResponseResult(ResponseResult.SUCCESS,"获取商品列表成功",reserveService.getProductList(page, page_size));
    }

    @ApiOperation(value = "1",notes = "获取商品的库存")
    @RequestMapping(value = "/getReserveCount",method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productId", paramType = "query",value = "商品id", required = true, dataType = "String",defaultValue = "1"),
    })
    public ResponseResult getReserveCount(Integer productId){
        return  new ResponseResult(ResponseResult.SUCCESS,"获取商品的库存成功",reserveService.getReserveCount(productId));
    }


}
