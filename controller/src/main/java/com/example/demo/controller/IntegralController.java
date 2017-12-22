package com.example.demo.controller;

import com.example.demo.service.IntegralService;
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
@RequestMapping("/integral")
public class IntegralController {
    Logger logger = Logger.getLogger(getClass());

    @Autowired
    private IntegralService integralService;

    @ApiOperation(value = "1",notes = "获取积分列表")
    @RequestMapping(value = "/getProductList",method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", paramType = "query",value = "用户id", required = true, dataType = "Integer",defaultValue = "1"),
            @ApiImplicitParam(name = "page", paramType = "query",value = "用户id", required = true, dataType = "Integer",defaultValue = "1"),
            @ApiImplicitParam(name = "page_size", paramType = "query",value = "物流公司", required = true, dataType = "Integer",defaultValue = "10"),
    })
    public ResponseResult getIntegralListByUserId(Integer userId,
                                                  Integer page,
                                                  Integer page_size) {
        if (userId==null || userId==0 ){
            return ResponseResult.errorResult("用户id不能为空");
        }
    return new ResponseResult(ResponseResult.SUCCESS,"获取积分列表成功",integralService.getIntegralListByUserId(userId, page, page_size));
    }

}
