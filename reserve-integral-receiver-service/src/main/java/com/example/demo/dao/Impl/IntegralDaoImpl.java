package com.example.demo.dao.Impl;

/**
 * Created by ningcs on 2017/11/6.
 */

import com.example.demo.dao.IntegralDao;
import com.example.demo.dto.OrderInfo;
import com.example.demo.entity.Integral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

    @Override
    public Map<String, Object> getIntegralListByUserId(Integer userId,Integer page,Integer page_size) {
        Map<String,Object> params =new HashMap<>();
        Map<String,Object> map =new HashMap<>();
        String sql ="select * from Integral where id=:userId";
        String count_sql ="select count(*) from Integral where id=:userId";
        if (page != null && page_size != null && page != 0 && page_size != 0) {
            sql = sql + " limit :row , :page_size ";
            Integer row = (page - 1) * page_size;
            params.put("row", row);
            params.put("page_size", page_size);
        }
        params.put("userId",userId);
        List<Integral> integrals = null;
        Integer total=0;
        try {
            integrals = jdbcTemplate.query(sql,params,new BeanPropertyRowMapper<Integral>(Integral.class));
            total = jdbcTemplate.queryForObject(count_sql,params,Integer.class);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
        map.put("page",page);
        map.put("page_size", page_size);
        map.put("total",total);
        map.put("list",integrals);
        return map;
    }
}
