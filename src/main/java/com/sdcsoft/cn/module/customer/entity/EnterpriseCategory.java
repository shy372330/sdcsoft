package com.sdcsoft.cn.module.customer.entity;

import java.io.Serializable;

public class EnterpriseCategory implements Serializable {
    private  int id,enterpriseId;
    private String categoryName;
    public int getId() {
        return id;
    }

    public int getEnterpriseId() {
        return enterpriseId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }



}
