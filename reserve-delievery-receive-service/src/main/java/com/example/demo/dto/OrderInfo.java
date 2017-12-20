package com.example.demo.dto;

import java.io.Serializable;

/**
 * Created by ningcs on 2017/11/6.
 */
public class OrderInfo implements Serializable{
    private String  orderId;
    private Integer userId;

    private String productName;
    private Integer  productId;

    //购买数量
    private Integer buyCount;

    //消费金额
    private String monetary;
    //配送
    private String delivery;

    @Override
    public String toString() {
        return "OrderInfo{" +
                "orderId='" + orderId + '\'' +
                ", userId=" + userId +
                ", productName='" + productName + '\'' +
                ", productId=" + productId +
                ", buyCount=" + buyCount +
                ", monetary='" + monetary + '\'' +
                ", delivery='" + delivery + '\'' +
                '}';
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public String getMonetary() {
        return monetary;
    }

    public void setMonetary(String monetary) {
        this.monetary = monetary;
    }
}
