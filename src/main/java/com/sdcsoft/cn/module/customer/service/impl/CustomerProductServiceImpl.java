package com.sdcsoft.cn.module.customer.service.impl;



import com.sdcsoft.cn.module.customer.dao.CustomerProductDao;
import com.sdcsoft.cn.module.customer.entity.CustomerProduct;
import com.sdcsoft.cn.module.customer.entity.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
import java.util.Map;

@Service("CustomerProductServiceImpl")
public class CustomerProductServiceImpl {

    @Autowired
    private CustomerProductDao customerProductDao;

    //查询列表
    public List<CustomerProduct> queryCustomerProduct(){
        return customerProductDao.queryCustomerProduct();
    };
    //根据客户id查询
    public List<CustomerProduct> queryCustomerProductByCustomerId(int customerId,int page,int limit,String productNameLike ){
        int from =(page-1) * limit;
        return customerProductDao.queryCustomerProductByCustomerId(customerId,from,limit,productNameLike);
    }
    //添加客户产品
    @Transactional(rollbackFor = Exception.class)
    public void insertCustomerProduct(CustomerProduct customerProduct){
        try {
            customerProductDao.insertCustomerProduct(customerProduct);
            //改变企业产品信息的isAdd状态，用来防止客户产品中的企业产品重复
            customerProductDao.updateEnterpriseProAddState(customerProduct);
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }
    //修改
    @Transactional(rollbackFor = Exception.class)
    public void updateCustomerProduct(String Code,CustomerProduct customerProduct,
                                      Integer enterpriseProductCodeId,Integer enterpriseProductCodeIdBefore){
        try {
            customerProductDao.updateCustomerProduct(Code,customerProduct);
            customerProductDao.updateEnterpriseProAdd(enterpriseProductCodeIdBefore,0);
            customerProductDao.updateEnterpriseProAdd(enterpriseProductCodeId,1);

        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }

    }

    //删除(根据客户产品id删除)
    @Transactional(rollbackFor = Exception.class)
    public void deleteCustomerProductByProductCode(Integer id,Integer enterpriseProductCodeId ) {
        try {
             customerProductDao.deleteCustomerProductByProductCode(id);
            customerProductDao.updateEnterpriseProAdd(enterpriseProductCodeId,0);
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }
    public int selectCustomerProductCount(int customerId,String productNameLike ) {
        return customerProductDao.selectCustomerProductCount(customerId,productNameLike);
    }
    //查找控制器信息
    public List<Device> findDeviceInfo(Integer customerId) {
        return customerProductDao.findDeviceInfo( customerId);
    }
    //查找企业处购买的产品
    public List<Map<String,Object>> findEnterpriseProductInfo(Integer customerId) {
        return customerProductDao.findEnterpriseProductInfo(customerId);
    }
    //查找二次产品
    public List<Map<String,Object>> findCustomerProductInfo(Integer customerId) {
        return  customerProductDao.findCustomerProductInfo(customerId);
    }
}
