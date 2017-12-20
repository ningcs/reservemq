package com.example.demo.service;

import com.example.demo.dto.ProductInfo;
import com.example.demo.dto.ReserveInfo;

import java.util.Map;

/**
 * Created by ningcs on 2017/11/6.
 */
public interface ProductService {
    /**
     * 获取商品的库存信息
     * @param productId
     * @return
     */
    public ReserveInfo getReserveCount(Integer  productId);

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
    public ProductInfo getProduct(Integer  productId);
}
