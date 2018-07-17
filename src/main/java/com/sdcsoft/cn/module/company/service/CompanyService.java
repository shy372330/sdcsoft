package com.sdcsoft.cn.module.company.service;

import com.sdcsoft.cn.module.company.entity.Customer;
import com.sdcsoft.cn.module.company.entity.EndUser;
import com.sdcsoft.cn.module.company.entity.Enterprise;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CompanyService {
    //查找企业信息
    List<Map<String,Object>> getEnterpriseInfo();
    //添加企业信息
    void insertEnterpriseInfo(Enterprise enterprise);
    //根据id查询公司信息
    List<Map<String,Object>> getEnterpriseInfoById(Integer enterpriseId);
    //删除企业信息
    void delEnterpriseInfo(Integer enterpriseId);
    //修改企业信息
    void updateEnterpriseInfo(Enterprise enterprise);
    //查找企业总行数
    int selectCompanyCount(String nameLike);

    //查看所有客户信息
    List<Map<String,Object>> getCustomerInfo();
    //查找客户数量
    int selectCustomerCount(String nameLike);

    //查看最终用户信息
    List<Map<String,Object>> getEndUserInfo();
    //查看最终用户数量
    int selectEndUserCount(String nameLike);
    //分页查找企业数量
    List<Enterprise> getEnterpriseInfoByPage(Integer page, Integer limit, String nameLike);
    //分页查看所有客户信息
    List<Customer> getCustomerInfoByPage(Integer page, Integer limit, String nameLike);
    //分页查看所有最终用户信息
    List<EndUser> getEndUserInfoByPage(Integer page, Integer limit, String nameLike);
}
