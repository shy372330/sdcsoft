package com.sdcsoft.cn.module.customer.entity;

import java.io.Serializable;

public class CustomerProduct implements Serializable {
    private  int id, customerId,deviceId,categoryId,status ,enterpriseProductCodeId ,enterpriseProductCodeIdBefore;
    private String enterpriseProductCode,productCode,categoryName;
    private String deviceNo;

    public int getEnterpriseProductCodeIdBefore() {
        return enterpriseProductCodeIdBefore;
    }

    public void setEnterpriseProductCodeIdBefore(int enterpriseProductCodeIdBefore) {
        this.enterpriseProductCodeIdBefore = enterpriseProductCodeIdBefore;
    }

    public int getEnterpriseProductCodeId() {
        return enterpriseProductCodeId;
    }

    public void setEnterpriseProductCodeId(int enterpriseProductCodeId) {
        this.enterpriseProductCodeId = enterpriseProductCodeId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }


    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getEnterpriseProductCode() {
        return enterpriseProductCode;
    }

    public void setEnterpriseProductCode(String enterpriseProductCode) {
        this.enterpriseProductCode = enterpriseProductCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
}
