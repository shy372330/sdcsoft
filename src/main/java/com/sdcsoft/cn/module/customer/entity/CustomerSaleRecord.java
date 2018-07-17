package com.sdcsoft.cn.module.customer.entity;
import java.io.Serializable;

public class CustomerSaleRecord implements Serializable {
    private int id,customerId,endUserId,customerproductId;
    private String saleDatetime;
    private String customerProductCode,categoryName,endUserName;
    public int getCustomerproductId() {
        return customerproductId;
    }
    public void setCustomerproductId(int customerproductId) {
        this.customerproductId = customerproductId;
    }
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public String getEndUserName() {
        return endUserName;
    }

    public void setEndUserName(String endUserName) {
        this.endUserName = endUserName;
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
    public int getEndUserId() {
        return endUserId;
    }

    public void setEndUserId(int endUserId) {
        this.endUserId = endUserId;
    }

    public String getCustomerProductCode() {
        return customerProductCode;
    }

    public void setCustomerProductCode(String customerProductCode) {
        this.customerProductCode = customerProductCode;
    }

    public String getSaleDatetime() {
        return saleDatetime;
    }
    public void setSaleDatetime(String saleDatetime) {
        this.saleDatetime = saleDatetime;
    }
}
