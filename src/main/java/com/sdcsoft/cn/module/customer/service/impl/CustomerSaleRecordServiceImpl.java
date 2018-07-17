package com.sdcsoft.cn.module.customer.service.impl;

import com.sdcsoft.cn.module.customer.dao.CustomerProductDao;
import com.sdcsoft.cn.module.customer.dao.CustomerSaleRecordDao;
import com.sdcsoft.cn.module.customer.entity.CustomerBuyRecord;
import com.sdcsoft.cn.module.customer.entity.CustomerSaleRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("CustomerSaleRecordServiceImpl")
public class CustomerSaleRecordServiceImpl {

    @Autowired
    private CustomerSaleRecordDao customerSaleRecordDao;
    @Autowired
    private CustomerProductDao customerProductDao;

    public   List<CustomerSaleRecord> queryByCid(int cid) { return customerSaleRecordDao.queryByCid(cid); }


    public int add(CustomerSaleRecord customerSaleRecord) {
        return customerSaleRecordDao.addCustomerSR(customerSaleRecord);
    }

    public List<CustomerSaleRecord> selectCustomerSale(int customerId, int page, int limit, String nameLike, String endUserLike) {
        int from = (page-1)* limit;
        return customerSaleRecordDao.selectCustomerSale(customerId,from,limit,nameLike,endUserLike);
    }

    public Integer selectCustomerSaleCount(int customerId,String nameLike,String endUserLike) {
        return customerSaleRecordDao.selectCustomerSaleCount(customerId,nameLike,endUserLike);
    }


    public void addSaleRecord(Integer customerProductId, Integer customerId,Integer endUserId, String saleDatetime) {
        customerSaleRecordDao.addSaleRecord(customerProductId,customerId,endUserId,saleDatetime);
        //更改销售状态
        customerProductDao.updateProductSale(customerProductId);
    }
}
