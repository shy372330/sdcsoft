package com.sdcsoft.cn.module.customer.dao;


import com.sdcsoft.cn.module.customer.entity.EnterpriseCategory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("EnterpriseCategoryDao")
public interface EnterpriseCategoryDao {
    /*
     * 查询所有
     * */
    List<EnterpriseCategory> findEnterpriseCategoryAll();
}
