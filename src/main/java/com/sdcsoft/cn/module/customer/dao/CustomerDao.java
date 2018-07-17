package com.sdcsoft.cn.module.customer.dao;

import com.sdcsoft.cn.module.company.entity.Customer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("CustomerDao")
public interface CustomerDao {
      /*
     * 查询所有
     * */
     List<Customer> findCustomerAll();

    /*
     * 根据Id查询
     * */
    Customer findCustomerById(int id);
    /*
     * 增加
     * */
    int addCustomer(Customer customer);
    /*
     * 修改
     * */
    int updateCustomer(Customer customer);
    /*
     * 删除
     * */
    int deteleCustomer(int id);
}
