package com.sdcsoft.cn.module.customer.dao;

import com.sdcsoft.cn.module.customer.entity.Device;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("customerDeviceDao")
public interface CustomerDeviceDao {
    //获取控制器信息
    List<Device> getCusdDviceInfoById(@Param("employeeId") Integer employeeId, @Param("from") int from, @Param("limit") int limit, @Param("nameLike") String nameLike);
    //获取控制器数量
    Integer findCustomerDeviceCountByCId(@Param("employeeId") Integer employeeId, @Param("nameLike") String nameLike);
}
