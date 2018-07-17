package com.sdcsoft.cn.module.customer.service.impl;

import com.sdcsoft.cn.module.customer.dao.CustomerCategoryDao;
import com.sdcsoft.cn.module.customer.entity.CustomerCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CustomerCategoryServiceImpl")
public class CustomerCategoryServiceImpl {

    @Autowired
    private CustomerCategoryDao customerCategoryDao;

    public CustomerCategory findCustomerCgById(int id) {
        return customerCategoryDao.findCustomerCgById(id);
    }
    public List<CustomerCategory> findCustomerCgAll() {
        return customerCategoryDao.findCustomerCgAll();
    }
    public List<CustomerCategory> findCustomerCgByCId(int customerId,int page,int limit,String nameLike) {
        int from = (page-1)* limit;
        return customerCategoryDao.findCustomerCgByCId(customerId,from,limit,nameLike);
    }

    public int addCustomerCg(CustomerCategory customerCategory) {
        return customerCategoryDao.addCustomerCg(customerCategory);
    }
    public int updateCustomerCg(CustomerCategory customerCategory) {
        return customerCategoryDao.updateCustomerCg(customerCategory);
    }
    public int deteleCustomerCg(int id) {
        return customerCategoryDao.deteleCustomerCg(id);
    }

    public Integer findCustomerCgCountByCId(int customerId,String nameLike) {
        return customerCategoryDao.findCustomerCgCountByCId(customerId,nameLike);
    }
}
