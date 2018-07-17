package com.sdcsoft.cn.module.customer.dao;


import com.sdcsoft.cn.module.customer.entity.EndUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("EndUserDao")
public interface EndUserDao {
    List<EndUser> queryEndUser();
    EndUser queryEndUserById(int id);
    int insertEndUser(EndUser endUser);
    int updateEndUser(EndUser endUser);
    int deleteEndUser(int id);
    List<EndUser> queryEndUserNum(String endUserName);
    List<EndUser> queryEndUserByCid(@Param("cid") int cid, @Param("from") int from, @Param("limit") int limit, @Param("endUserNameLike") String endUserNameLike);
    //获取最终用户的数量
    int queryEndUserCountByCid(@Param("customerId") Integer customerId, @Param("endUserNameLike") String endUserNameLike);

    //获取最终用户全部
    List<EndUser> queryEndUserAll(Integer customerId);
}
