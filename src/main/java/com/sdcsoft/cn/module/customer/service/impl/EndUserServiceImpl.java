package com.sdcsoft.cn.module.customer.service.impl;


import com.sdcsoft.cn.module.customer.dao.EndUserDao;
import com.sdcsoft.cn.module.customer.entity.EndUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("EndUserServiceImpl")
public class EndUserServiceImpl {
    @Autowired
    private EndUserDao endUserDao;

    @Transactional

    public List<EndUser> getEndUserList() {
        return endUserDao.queryEndUser();
    }

    @Transactional

    public EndUser getEndUserById(int id) {
        return endUserDao.queryEndUserById(id);
    }

    @Transactional

    public int addEndUser(EndUser endUser) {
        return endUserDao.insertEndUser(endUser);
    }

    @Transactional

    public int updateEndUser(EndUser endUser) {
        return endUserDao.updateEndUser(endUser);
    }

    @Transactional

    public int deleteEndUser(int id) {
        return endUserDao.deleteEndUser(id);
    }

    public List<EndUser> queryEndUserNum(String endUserName) {
        return endUserDao.queryEndUserNum(endUserName);
    }
    public List<EndUser> queryEndUserByCid(int cid,int page,int limit,String endUserNameLike) {
        int from = (page-1)*limit;
        return endUserDao.queryEndUserByCid(cid,from,limit,endUserNameLike);
    }

    //获取最终用户的数量
    public int queryEndUserCountByCid(Integer customerId, String endUserNameLike) {
        return endUserDao .queryEndUserCountByCid(customerId,endUserNameLike);
    }

    public List<EndUser> queryEndUserAll(Integer customerId) {
        return endUserDao.queryEndUserAll(customerId);
    }
}
