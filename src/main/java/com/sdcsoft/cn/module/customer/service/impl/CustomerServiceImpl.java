package com.sdcsoft.cn.module.customer.service.impl;

import com.sdcsoft.cn.module.customer.dao.CustomerDao;
import com.sdcsoft.cn.module.company.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CustomerServiceImpl")
public class CustomerServiceImpl {

    @Autowired
    private CustomerDao customerDao;

    public Customer findCustomerById(int id) {
        return customerDao.findCustomerById(id);
    }
    public List<Customer> findCustomerAll() {
        return customerDao.findCustomerAll();
    }



    public int addCustomer(Customer customer) {
        return customerDao.addCustomer(customer);
    }


    public int updateCustomer(Customer customer) {
        return customerDao.updateCustomer(customer);
    }


    public int deteleCustomer(int id) {
        return customerDao.deteleCustomer(id);
    }
}
