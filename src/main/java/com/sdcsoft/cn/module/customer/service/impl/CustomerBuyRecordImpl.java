package com.sdcsoft.cn.module.customer.service.impl;

import com.sdcsoft.cn.module.customer.dao.CustomerBuyRecordDao;
import com.sdcsoft.cn.module.customer.dao.CustomerCategoryDao;
import com.sdcsoft.cn.module.customer.entity.CustomerBuyRecord;
import com.sdcsoft.cn.module.customer.entity.CustomerCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CustomerBuyRecordImpl {

    @Autowired
    private CustomerBuyRecordDao customerBuyRecordDao;

//获取客户的购买记录
    public List<CustomerBuyRecord> getBuyRecord(Integer customerId, int page, int limit, String productNameLike ) {
        int from = (page-1)*limit;
        return customerBuyRecordDao.getBuyRecord(customerId,from,limit,productNameLike );
    }
    //获取购买数量
    public Integer getBuyRecordCount(Integer customerId,String productNameLike  ) {
        return customerBuyRecordDao.getBuyRecordCount(customerId,productNameLike );
    }
}
