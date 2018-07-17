package com.sdcsoft.cn.module.customer.dao;

import com.sdcsoft.cn.module.customer.entity.EnterpriseSaleRecord;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("EnterpriseSaleRecordDao")
public interface EnterpriseSaleRecordDao {

    /*
     * 根据客户ID查询
     * */
    List<EnterpriseSaleRecord> findESRecordBycid(int customerId);


}
