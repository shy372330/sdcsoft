package com.sdcsoft.cn.module.customer.entity;



import java.io.Serializable;
import java.util.Date;

public class CustomerBuyRecord implements Serializable {
    private int id, enterpriseId, customerId, endUserId,enterpriseProductId;
    private String enterpriseProductCode,categoryName,enterpriseName,customerName;

    private String saleDatetime;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getEnterpriseProductId() {
        return enterpriseProductId;
    }

    public void setEnterpriseProductId(int enterpriseProductId) {
        this.enterpriseProductId = enterpriseProductId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getEndUserId() {
        return endUserId;
    }

    public void setEndUserId(int endUserId) {
        this.endUserId = endUserId;
    }

    public String getEnterpriseProductCode() {
        return enterpriseProductCode;
    }

    public void setEnterpriseProductCode(String enterpriseProductCode) {
        this.enterpriseProductCode = enterpriseProductCode;
    }

    public String getSaleDatetime() {
        return saleDatetime;
    }

    public void setSaleDatetime(String saleDatetime) {
        this.saleDatetime = saleDatetime;
    }
}