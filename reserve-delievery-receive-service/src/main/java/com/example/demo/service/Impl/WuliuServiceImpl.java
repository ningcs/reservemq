package com.example.demo.service.Impl;

import com.example.demo.dao.WuliuDao;
import com.example.demo.dto.OrderInfo;
import com.example.demo.service.WuliuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ningcs on 2017/12/20.
 */
@Service
public class WuliuServiceImpl implements WuliuService {

    @Autowired
    private WuliuDao wuliuDao;

    @Override
    @Transactional
    public void add(OrderInfo orderInfo) {
        wuliuDao.add(orderInfo);
    }
}
