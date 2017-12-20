package com.example.demo.dao.Impl;

/**
 * Created by ningcs on 2017/11/6.
 */

import com.example.demo.dao.IntegralDao;
import com.example.demo.dto.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class IntegralDaoImpl implements IntegralDao {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


    @Override
    public void addIntegral(OrderInfo orderInfo) {
        Map<String,Object> params =new HashMap<>();
        String sql="insert into Integral(userId,integralNumber,`type`,createTime) values(:userId,:integralNumber,:type,:createTime)";
        params.put("userId",orderInfo.getUserId());
        params.put("integralNumber",Double.parseDouble(orderInfo.getMonetary()) * 10);
        params.put("type",1);
        params.put("createTime",new Date());
        jdbcTemplate.update(sql,params);
    }




}
