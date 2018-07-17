package com.sdcsoft.cn.module.customer.service.impl;

import com.sdcsoft.cn.module.customer.dao.EnterpriseProductDao;
import com.sdcsoft.cn.module.customer.entity.EnterpriseProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("EnterpriseProductServiceImpl")
public class EnterpriseProductServiceImpl {

    @Autowired
    private EnterpriseProductDao enterpriseProductDao;

    public EnterpriseProduct findEProductByCode(String productCode) {
        return enterpriseProductDao.findEProductByCode(productCode);
    }

    public List<Map<String,Object>> findEProductAll(Integer customerId) {
        return enterpriseProductDao.findEProductAll( customerId);
    }

    public List<EnterpriseProduct>  findLikeCode(String productCode) { return enterpriseProductDao.findLikeCode(productCode); }

    public int addEProduct(EnterpriseProduct enterpriseProduct) {
        return enterpriseProductDao.addEProduct(enterpriseProduct);
    }

    public int updateEProduct(String pCode,EnterpriseProduct enterpriseProduct) {

        return enterpriseProductDao.updateEProduct(pCode,enterpriseProduct);
    }

    public int deteleEProduct(String productCode) {
        return enterpriseProductDao.deteleEProduct(productCode);
    }
}
