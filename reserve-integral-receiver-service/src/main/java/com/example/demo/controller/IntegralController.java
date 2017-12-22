package com.example.demo.controller;

import com.example.demo.service.IntegralService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by ningcs on 2017/10/30.
 */
@RestController
@RequestMapping("/integral")
public class IntegralController {
    Logger logger = Logger.getLogger(getClass());

    @Autowired
    private IntegralService integralService;
    @RequestMapping(value = "/getIntegralListByUserId",method = {RequestMethod.POST})
    public Map<String,Object> getIntegralListByUserId(Integer userId,Integer page, Integer page_size){
        return  integralService.getIntegralListByUserId(userId, page, page_size);
    }


}
