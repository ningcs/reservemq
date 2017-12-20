package com.example.demo.entity;

import java.util.Date;

/**
 * Created by ningcs on 2017/11/20.
 */
public class Wuliu {
    private Integer id;

    private Integer userId;

    private String orderId;

    private String delievery;

    private Date createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDelievery() {
        return delievery;
    }

    public void setDelievery(String delievery) {
        this.delievery = delievery;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
