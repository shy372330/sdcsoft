package com.sdcsoft.cn.module.customer.service.impl;

import com.sdcsoft.cn.module.customer.dao.EnterpriseDao;
import com.sdcsoft.cn.module.customer.entity.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("EnterpriseServiceImpl")
public class EnterpriseServiceImpl {

    @Autowired
    private EnterpriseDao enterpriseDao;


    public List<Enterprise> findEnterpriseAll() {
        return enterpriseDao.findEnterpriseAll();
    }


    public Enterprise findEnterpriseById(int id) {
        return enterpriseDao.findEnterpriseById(id);
    }


    public List<Enterprise>  findEnterpriseByName(String enterpriseName) { return enterpriseDao.findEnterpriseByName(enterpriseName); }


    public int addEnterprise(Enterprise enterprise) {
        return enterpriseDao.addEnterprise(enterprise);
    }


    public int updateEnterprise(Enterprise enterprise) {
        return enterpriseDao.updateEnterprise(enterprise);
    }


    public int deteleEnterprise(int id) {
        return enterpriseDao.deteleEnterprise(id);
    }
}
