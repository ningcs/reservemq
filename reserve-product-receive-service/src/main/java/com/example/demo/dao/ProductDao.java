package com.example.demo.dao;

import com.example.demo.entity.Product;
import com.example.demo.entity.Reserve;

import java.util.Map;

/**
 * Created by ningcs on 2017/11/6.
 */
public interface ProductDao {
    /**
     * 获取商品的库存信息
     * @param productId
     * @return
     */
    public Reserve getReserveCount(Integer  productId);

    /**
     * 修改商品库存信息
     * @param count
     * @param productId
     * @return
     */
    public Integer updateReserveCount(Integer count,Integer  productId);

    /**
     * 获取商品列表
     * @param page
     * @param page_size
     * @return
     */

    public Map<String,Object> getProductList(Integer page, Integer page_size);

    /**
     * 获取商品信息
     * @param productId
     * @return
     */
    public Product getProduct(Integer  productId);
}
