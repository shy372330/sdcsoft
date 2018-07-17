package com.sdcsoft.cn.module.endUser.service.impl;

import com.sdcsoft.cn.module.endUser.mapper.EndUserMapper;
import com.sdcsoft.cn.module.endUser.service.EndUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service("endUserService")
public class EndUserServiceImpl implements EndUserService {
@Autowired
private EndUserMapper endUserMapper;
        //查找企业信息
    @Override
    public List<Map<String, Object>> findEnterpriseInfo() {
        return endUserMapper.findEnterpriseInfo();
    }
    //增加企业信息
    @Override
    public void addEnterpriseInfo(Integer enterpriseId, Integer customerId, String endUserName) {
        endUserMapper.addEnterpriseInfo(enterpriseId,customerId,endUserName);
    }
    //删除企业信息
    @Override
    public void delEnterpriseInfo(Integer endUserId) {
        endUserMapper.delEnterpriseInfo(endUserId);
    }
    //修改企业信息
    @Override
    public void updateEnterpriseInfo(Integer endUserId, Integer enterpriseId) {
        endUserMapper.updateEnterpriseInfo(endUserId,enterpriseId);
    }
    //查找企业信息总行数
    @Override
    public int selectEntepriseInfoCount() {

        return endUserMapper.selectEntepriseInfoCount();
    }
//查找企业客户信息
    @Override
    public List<Map<String, Object>> findCustomerInfo() {
       return  endUserMapper.findCustomerInfo();

    }

    @Override
    public void addCustomerInfo(Integer enterpriseId, Integer customerId, String endUserName) {
        endUserMapper.addCustomerInfo(enterpriseId,customerId,endUserName);
    }

    @Override
    public void delCustomerInfo(Integer endUserId) {
        endUserMapper.delCustomerInfo(endUserId);
    }

    @Override
    public void updateCustomerInfo(Integer endUserId, Integer customerId) {
        endUserMapper.updateCustomerInfo(endUserId,customerId);
    }

    @Override
    public int selectCustomerInfo() {
        return endUserMapper.selectCustomerInfo();
    }

    @Override
    public List<Map<String, Object>> findProductFromE(Integer endUserId,int page,int limit,String nameLike) {
        int from = (page-1) *limit;
        return endUserMapper.findProductFromE(endUserId,from,limit,nameLike);
    }

    @Override
    public int selectCountFromE(Integer endUserId,String nameLike) {
        return endUserMapper.selectCountFromE(endUserId,nameLike);
    }

    @Override
    public int selectCountFromC(Integer endUserId,String nameLike) {
        return endUserMapper.selectCountFromC(endUserId,nameLike);
    }

    @Override
    public List<Map<String, Object>> findProductFromC(Integer endUserId,int page,int limit,String nameLike) {
        int from = (page-1) *limit;
        return endUserMapper.findProductFromC(endUserId,from,limit,nameLike);
    }
}
