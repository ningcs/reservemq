package com.example.demo.dao;

import com.example.demo.dto.OrderInfo;

import java.util.Map;

/**
 * Created by ningcs on 2017/11/6.
 */
public interface IntegralDao {
    public void  addIntegral(OrderInfo orderInfo);

    /**
     * 获取用户积分记录
     * @param userId
     * @return
     */
    public Map<String,Object> getIntegralListByUserId(Integer userId,Integer page,Integer page_size);

}
