package com.sdcsoft.cn.module.customer.dao;

import com.sdcsoft.cn.module.customer.entity.EnterpriseProduct;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("EnterpriseProductDao")
public interface EnterpriseProductDao {
      /*
     * 查询所有
     * */
      List<Map<String,Object>> findEProductAll(Integer customerId);
    /*
     * 根据设备编码模糊查询
     * */
    List<EnterpriseProduct> findLikeCode(String productCode);
    /*
     * 根据设备编码查询
     * */
    EnterpriseProduct findEProductByCode(String productCode);
    /*
     * 增加
     * */
    int addEProduct(EnterpriseProduct enterpriseProduct);
    /*
     * 修改
     * */
    int updateEProduct(@Param("pCode") String pCode, @Param("enterpriseProduct") EnterpriseProduct enterpriseProduct);
    /*
     * 删除
     * */
    int deteleEProduct(String productCode);
}
