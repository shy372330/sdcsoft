package com.sdcsoft.cn.module.customer.dao;

import com.sdcsoft.cn.module.customer.entity.CustomerBuyRecord;
import com.sdcsoft.cn.module.customer.entity.CustomerCategory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("CustomerBuyRecordDao")
public interface CustomerBuyRecordDao {

    List<CustomerBuyRecord> getBuyRecord(@Param("cus") Integer customerId, @Param("from") int from,
                                         @Param("limit") int limit, @Param("productNameLike") String productNameLike);

    Integer getBuyRecordCount(@Param("customerId") Integer customerId, @Param("productNameLike") String productNameLike);
}
