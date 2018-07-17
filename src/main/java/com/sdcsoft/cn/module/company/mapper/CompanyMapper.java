package com.sdcsoft.cn.module.company.mapper;

import com.sdcsoft.cn.module.company.entity.Customer;
import com.sdcsoft.cn.module.company.entity.EndUser;
import com.sdcsoft.cn.module.company.entity.Enterprise;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Mapper
@Component("commpanyMapper")
public interface CompanyMapper {
    //查找企业信息
      List<Map<String,Object>> getEnterpriseInfo(@Param("from") int from, @Param("limit") int limit, @Param("nameLike") String nameLike);
    //添加企业信息
    void insertEnterpriseInfo(Enterprise enterprise);
    //根据id查询公司信息
    List<Map<String,Object>> getEnterpriseInfoById(Integer enterpriseId);
    //删除企业信息
    void delEnterpriseInfo(Integer enterpriseId);
    //修改企业信息
    void updateEnterpriseInfo(Enterprise enterprise);
    //查找企业总行数
    int selectCompanyCount(@Param("nameLike") String nameLike);

    //查看所有客户信息
    List<Map<String,Object>> getCustomerInfo();
    //查找客户数量
    int selectCustomerCount(@Param("nameLike") String nameLike);

    //查看最终用户信息
    List<Map<String,Object>> getEndUserInfo();
    //查看最终用户数量
    int selectEndUserCount(@Param("nameLike") String nameLike);

    //分页查找 企业信息
    List<Enterprise> findInfoByEnterprisePage(@Param("f") int fromRows, @Param("l") Integer limit, @Param("nameLike") String nameLike);

    List<Customer> getCustomerInfoByPage(@Param("f") int fromRows, @Param("l") Integer limit, @Param("nameLike") String nameLike);
    //分页查找 最终用户信息
    List<EndUser> getEndUserInfoByPage(@Param("f") int fromRows, @Param("l") Integer limit, @Param("nameLike") String nameLike);
}
