package com.sdcsoft.cn.module.company.service.impl;

import com.sdcsoft.cn.module.company.entity.Customer;
import com.sdcsoft.cn.module.company.entity.EndUser;
import com.sdcsoft.cn.module.company.entity.Enterprise;
import com.sdcsoft.cn.module.company.mapper.CompanyMapper;
import com.sdcsoft.cn.module.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service("CompanyServiceImpl")
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyMapper companyMapper;
    /*@Override
    public List<Map<String, Object>> getEnterpriseInfo(int page,int limit,String nameLike) {
        int from = (page-1) *limit;
        return  companyMapper.getEnterpriseInfo(page,from,nameLike);
    }
*/
    @Override
    public List<Map<String, Object>> getEnterpriseInfo() {
        return null;
    }

    @Override
    public void insertEnterpriseInfo(Enterprise enterprise) {
        companyMapper.insertEnterpriseInfo(enterprise);
    }

    @Override
    public List<Map<String, Object>> getEnterpriseInfoById(Integer enterpriseId) {
        return companyMapper.getEnterpriseInfoById(enterpriseId);
    }

    @Override
    public void delEnterpriseInfo(Integer enterpriseId) {
        companyMapper.delEnterpriseInfo(enterpriseId);
    }

    @Override
    public void updateEnterpriseInfo(Enterprise enterprise) {
        companyMapper.updateEnterpriseInfo(enterprise);
    }

    @Override
    public int selectCompanyCount(String nameLike) {
        return companyMapper.selectCompanyCount(nameLike);
    }



    @Override
    public List<Map<String, Object>> getCustomerInfo() {
        return companyMapper.getCustomerInfo();
    }

    @Override
    public int selectCustomerCount(String nameLike) {
        return companyMapper.selectCustomerCount(nameLike);
    }

    @Override
    public List<Map<String, Object>> getEndUserInfo() {
        return companyMapper.getEndUserInfo();
    }

    @Override
    public int selectEndUserCount(String nameLike) {
        return companyMapper.selectEndUserCount(nameLike);
    }
    //分页查找企业信息
    @Override
    public List<Enterprise> getEnterpriseInfoByPage(Integer page, Integer limit, String nameLike) {
        //获取开始的行位置下标
        int fromRows =(page-1)*limit;
        List<Enterprise> list = companyMapper.findInfoByEnterprisePage(fromRows,limit,nameLike);
        return list;
    }

    @Override
    public List<Customer> getCustomerInfoByPage(Integer page, Integer limit, String nameLike) {

        //获取开始的行位置下标
        int fromRows =(page-1)*limit;
        return companyMapper.getCustomerInfoByPage(fromRows,limit,nameLike);
    }

    @Override
    public List<EndUser> getEndUserInfoByPage(Integer page, Integer limit, String nameLike) {

        //获取开始的行位置下标
        int fromRows =(page-1)*limit;
        return companyMapper.getEndUserInfoByPage(fromRows,limit,nameLike);

    }
}
