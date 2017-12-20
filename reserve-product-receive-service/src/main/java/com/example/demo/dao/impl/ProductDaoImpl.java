package com.example.demo.dao.impl;

/**
 * Created by ningcs on 2017/11/6.
 */

import com.example.demo.dao.ProductDao;
import com.example.demo.entity.Product;
import com.example.demo.entity.Reserve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public Reserve getReserveCount(Integer  productId) {
        Map<String,Object> params =new HashMap<>();
        String sql ="select * from Reserve where productId=:productId";
        params.put("productId",productId);
        Reserve reserve = null;
        try {
            reserve = jdbcTemplate.queryForObject(sql, params, new BeanPropertyRowMapper<Reserve>(Reserve.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
        return reserve;
    }

    @Override
    public Integer updateReserveCount(Integer count,Integer  productId) {
        Map<String,Object> params =new HashMap<>();
        String sql ="update Reserve set currentCount=currentCount+:count where productId=:productId" ;
        String sql1 ="select count(*) from Reserve where productId=:productId";

        params.put("count",count);
        params.put("productId",  productId);
        Reserve reserve=null;
        Integer currentCount=0;
        try {
             jdbcTemplate.update(sql,params);
            reserve = jdbcTemplate.queryForObject(sql1, params, new BeanPropertyRowMapper<Reserve>(Reserve.class));
            if (reserve!=null ){
                currentCount=reserve.getCurrentCount();
            }
        } catch (EmptyResultDataAccessException e) {
            return null;
        }

        return currentCount;
    }



    @Override
    public Map<String,Object> getProductList(Integer page, Integer page_size){
        Map<String,Object> map =new HashMap<>();
        Map<String,Object> params =new HashMap<>();
        String sql ="select * from Product ";
        String count_sql ="select count(*) from Product ";
        sql = sql + " order by createTime asc";
        if (page != null && page_size != null && page != 0 && page_size != 0) {
            sql = sql + " limit :row , :page_size ";
            Integer row = (page - 1) * page_size;
            params.put("row", row);
            params.put("page_size", page_size);
        }
        List<Product> products = null;
        Integer total=0;
        try {
            products = jdbcTemplate.query(sql,params,new BeanPropertyRowMapper<Product>(Product.class));
            total = jdbcTemplate.queryForObject(count_sql,params,Integer.class);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
        map.put("page",page);
        map.put("page_size", page_size);
        map.put("total",total);
        map.put("list",products);
        return map;
    }

    @Override
    public Product getProduct(Integer productId) {
        Map<String,Object> params =new HashMap<>();
        String sql ="select * from Product where id=:productId";
        params.put("productId",productId);
        Product product = null;
        try {
            product = jdbcTemplate.queryForObject(sql, params, new BeanPropertyRowMapper<Product>(Product.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
        return product;
    }
}
