package com.sdcsoft.cn.module.customer.dao;

import com.sdcsoft.cn.module.customer.entity.Enterprise;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("EnterpriseDao")
public interface EnterpriseDao {
    /*
     * 查询所有
     * */
    List<Enterprise> findEnterpriseAll();
    /*
     * 根据Id查询
     * */
    Enterprise findEnterpriseById(int id);
    /*
     * 根据企业名称查询
     * */
    List<Enterprise> findEnterpriseByName(String enterpriseName);
    /*
     * 增加
     * */
    int addEnterprise(Enterprise enterprise);
    /*
     * 修改
     * */
    int updateEnterprise(Enterprise enterprise);
    /*
     * 删除
     * */
    int deteleEnterprise(int id);


}
