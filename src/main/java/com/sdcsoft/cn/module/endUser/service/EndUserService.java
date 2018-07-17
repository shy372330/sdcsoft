package com.sdcsoft.cn.module.endUser.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EndUserService {
    //根据id查找相关的企业信息
    List<Map<String, Object>> findEnterpriseInfo();
    //添加对应企业信息
    void addEnterpriseInfo(Integer enterpriseId, Integer customerId,
                           String endUserName);

    //删除企业信息
    void delEnterpriseInfo(Integer endUserId);

    //修改企业信息
    void updateEnterpriseInfo(Integer id, Integer enterpriseId);

    //查找企业信息总行数
    int selectEntepriseInfoCount();


    //查找客户信息
    List<Map<String, Object>> findCustomerInfo();
    //添加客户信息
    void addCustomerInfo(Integer enterpriseId, Integer customerId,
                         String endUserName);

    //删除客户信息
    void delCustomerInfo(Integer endUserId);

    //修改客户信息
    void updateCustomerInfo(Integer endUserId, Integer customerId);

    //查找客户总行数
    int selectCustomerInfo();

    //查找企业处购买产品信息
    List<Map<String, Object>> findProductFromE(Integer endUserId, int page, int limit, String nameLike);
    //查找企业处购买的产品信息数量
    int selectCountFromE(Integer endUserId, String nameLike);

    //查找客户处购买的产品数量
    int selectCountFromC(Integer endUserId, String nameLike);
    //查找客户处购买的产品
    List<Map<String,Object>> findProductFromC(Integer endUserId, int page, int limit, String nameLike);

}
