package com.sdcsoft.cn.module.customer.service.impl;

import com.sdcsoft.cn.module.customer.dao.EnterpriseSaleRecordDao;
import com.sdcsoft.cn.module.customer.entity.EnterpriseSaleRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("EnterpriseSaleRecordServiceImpl")
public class EnterpriseSaleRecordServiceImpl {

    @Autowired
    private EnterpriseSaleRecordDao enterpriseSaleRecordDao;

    public List<EnterpriseSaleRecord>  findESRecordBycid(int  customerId) { return enterpriseSaleRecordDao.findESRecordBycid(customerId); }

}
