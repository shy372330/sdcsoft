package com.sdcsoft.cn.module.customer.dao;

import com.sdcsoft.cn.module.customer.entity.CustomerCategory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("CustomerCategoryDao")
public interface CustomerCategoryDao {
      /*
     * 查询所有
     * */
     List<CustomerCategory> findCustomerCgAll();
    /*
     * 根据Id查询list
     * */
    List<CustomerCategory> findCustomerCgByCId(@Param("customerId") int customerId, @Param("from") int from, @Param("limit") int limit, @Param("nameLike") String nameLike);
    /*
     * 根据Id查询
     * */
    CustomerCategory findCustomerCgById(int id);
    /*
     * 增加
     * */
    int addCustomerCg(CustomerCategory customerCategory);
    /*
     * 修改
     * */
    int updateCustomerCg(CustomerCategory customerCategory);
    /*
     * 删除
     * */
    int deteleCustomerCg(int id);
    //获取客户的产品名称信息
    Integer findCustomerCgCountByCId(@Param("customerId") int customerId, @Param("nameLike") String nameLike);
}
