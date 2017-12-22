package com.example.demo.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by ningcs on 2017/11/8.
 */
@FeignClient(value = "reserve-Integral-receive-service")
public interface IntegralService {

//    @RequestMapping(value = "/getIntegralListByUserId",method = {RequestMethod.POST})
//    public Map<String,Object> getIntegralListByUserId(Integer userId,Integer page, Integer page_size){

    /**
     * 获取积分列表
     *
     * @param page
     * @param page_size
     * @return
     */
    @RequestMapping(value = "/integral/getIntegralListByUserId", method = {RequestMethod.POST})
    public Map<String, Object> getIntegralListByUserId(@RequestParam(value = "userId") Integer userId,
                                                       @RequestParam(value = "page") Integer page,
                                                       @RequestParam(value = "page_size") Integer page_size);

}
