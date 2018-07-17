package com.sdcsoft.cn.module.customer.dao;

import com.sdcsoft.cn.module.customer.entity.CustomerProduct;
import com.sdcsoft.cn.module.customer.entity.Device;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


@Component("CustomerProductDao")
public interface CustomerProductDao {
    //查询列表
    List<CustomerProduct> queryCustomerProduct();
    //根据客户id查询
    List<CustomerProduct> queryCustomerProductByCustomerId(@Param("customerId") int customerId,
                                                           @Param("from") int from, @Param("limit") int limit,
                                                           @Param("productNameLike") String productNameLike);
    //根据产品编码查询
    CustomerProduct queryCustomerProductByCode(String productCode);

    //添加
    void insertCustomerProduct(CustomerProduct customerProduct);
    //修改
    int updateCustomerProduct(@Param("Code") String Code, @Param("customerProduct") CustomerProduct customerProduct);
    //删除(根据客户id删除)
    int deleteCustomerProductByProductCode(Integer id);

   //查找客户产品数量
    int selectCustomerProductCount(@Param("customerId") int customerId, @Param("productNameLike") String productNameLike);
    //查找控制器信息
    List<Device> findDeviceInfo(Integer customerId);
    //查找企业处购买的产品信息
    List<Map<String,Object>> findEnterpriseProductInfo(Integer customerId);
    //查找客户产品名称
    List<Map<String,Object>> findCustomerProductInfo(Integer customerId);
    //更改销售状态
    void updateProductSale(Integer customerProductId);
    //更改企业产品的添加状态
    void updateEnterpriseProAddState(CustomerProduct customerProduct);
    //改变客户对应的企业的产品添加状态
    void updateEnterpriseProAdd(@Param("enterpriseProductCodeId") Integer enterpriseProductCodeId, @Param("status") Integer status);
}
