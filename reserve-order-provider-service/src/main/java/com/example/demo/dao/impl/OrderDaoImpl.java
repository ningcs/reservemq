package com.example.demo.dao.impl;

import com.example.demo.dao.OrderDao;
import com.example.demo.dto.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ningcs on 2017/11/20.
 */
@Repository
public class OrderDaoImpl implements OrderDao{

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;



    @Override
    public void addOrder(OrderInfo orderInfo) {
        Map<String,Object> params =new HashMap<>();
        String sql ="insert into t_order(id,productId,userId,buyCount,monetary,createTime)" +
                " values(:id,:productId,:userId,:buyCount,:monetary,:createTime)";
        params.put("id",orderInfo.getOrderId());
        params.put("productId",orderInfo.getProductId());
        params.put("userId",orderInfo.getUserId());
        params.put("buyCount",orderInfo.getBuyCount());
        params.put("monetary",orderInfo.getMonetary());
        params.put("createTime",new Date());
        try {
            jdbcTemplate.update(sql, params);
        } catch (EmptyResultDataAccessException e) {
            return ;
        }
    }
}
