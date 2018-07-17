package com.sdcsoft.cn.module.customer.dao;

import com.sdcsoft.cn.module.customer.entity.CustomerSaleRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("CustomerSaleRecordDao")
public interface CustomerSaleRecordDao {
    /*
     * 根据客户id查询
     * */
    List<CustomerSaleRecord> queryByCid(int cid);
    /*
     * 增加
     * */
    int addCustomerSR(CustomerSaleRecord customerSaleRecord);
    //查找客户销售记录
    List<CustomerSaleRecord> selectCustomerSale(@Param("customerId") int customerId, @Param("from") int from,
                                                @Param("limit") int limit,
                                                @Param("nameLike") String nameLike, @Param("endUserLike") String endUserLike);
    //查找所有客户销售记录
    Integer selectCustomerSaleCount(@Param("customerId") int customerId, @Param("nameLike") String nameLike, @Param("endUserLike") String endUserLike);
    //增加销售记录
    void addSaleRecord(@Param("customerProductId") Integer customerProductId, @Param("customerId") Integer customerId,
                       @Param("endUserId") Integer endUserId, @Param("saleDatetime") String saleDatetime);
}
