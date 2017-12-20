package com.example.demo.entity;

/**
 * Created by ningcs on 2017/11/6.
 */
public class Reserve {
    private Integer id;
    private Integer  productId;
    //库存总数
    private Integer totalCount;

    //当前已购买数量
    private Integer currentCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(Integer currentCount) {
        this.currentCount = currentCount;
    }
}
