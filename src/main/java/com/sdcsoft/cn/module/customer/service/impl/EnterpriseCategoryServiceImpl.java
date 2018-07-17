package com.sdcsoft.cn.module.customer.service.impl;

import com.sdcsoft.cn.module.customer.dao.EnterpriseCategoryDao;
import com.sdcsoft.cn.module.customer.entity.EnterpriseCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("EnterpriseCategoryServiceImpl")
public class EnterpriseCategoryServiceImpl {
    @Autowired
    private EnterpriseCategoryDao enterpriseCategoryDao;
    public List<EnterpriseCategory> findEnterpriseCategoryAll(){
        return enterpriseCategoryDao.findEnterpriseCategoryAll();
    }
}
