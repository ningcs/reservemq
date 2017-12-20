package com.example.demo.dao.Impl;

import com.example.demo.dao.WuliuDao;
import com.example.demo.dto.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ningcs on 2017/12/20.
 */
@Repository
public class WuliuDaoImpl implements WuliuDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void add(OrderInfo orderInfo) {
        Map<String,Object> params =new HashMap<>();
        String sql="insert into Wuliu(userId,orderId,delievery,createTime) values(:userId,:orderId,:delievery,:createTime)";
        params.put("userId",orderInfo.getUserId());
        params.put("orderId",orderInfo.getOrderId());
        params.put("delievery",orderInfo.getDelivery());
        params.put("createTime",new Date());
        jdbcTemplate.update(sql,params);
    }
}
