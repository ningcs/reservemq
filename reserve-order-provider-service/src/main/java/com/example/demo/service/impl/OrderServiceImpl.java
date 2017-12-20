package com.example.demo.service.impl;

import com.example.demo.dao.OrderDao;
import com.example.demo.dto.OrderInfo;
import com.example.demo.sender.HelloSender;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ningcs on 2017/11/20.
 */
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private HelloSender helloSender;

    @Override
    @Transactional
    public void addOrder(OrderInfo orderInfo) {
        orderDao.addOrder(orderInfo);
        helloSender.send(orderInfo);
    }
}
