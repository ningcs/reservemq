package com.example.demo.service.impl;

import com.example.demo.dao.ProductDao;
import com.example.demo.dto.ProductInfo;
import com.example.demo.dto.ReserveInfo;
import com.example.demo.entity.Product;
import com.example.demo.entity.Reserve;
import com.example.demo.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by ningcs on 2017/11/6.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public ReserveInfo getReserveCount(Integer  productId) {
        Reserve reserve= productDao.getReserveCount(productId);
        ReserveInfo reserveInfo =new ReserveInfo();
        BeanUtils.copyProperties(reserve,reserveInfo);
        return reserveInfo;
    }

    @Override
    @Transactional
    public Integer updateReserveCount(Integer count, Integer  productId) {
        return productDao.updateReserveCount(count,productId);
    }

    @Override
    public Map<String, Object> getProductList(Integer page, Integer page_size) {
        return productDao.getProductList(page,page_size);
    }

    @Override
    public ProductInfo getProduct(Integer productId) {
        Product product= productDao.getProduct(productId);
        ProductInfo productInfo=null;
        if (product!=null){
            productInfo =new ProductInfo();
            BeanUtils.copyProperties(product,productInfo);
            productInfo.setCreateTime(product.getCreateTime());
        }
        return productInfo;
    }
}
