package com.sdcsoft.cn.module.customer.dao;

import com.sdcsoft.cn.module.customer.entity.Device;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("DeviceDao")
public interface DeviceDao {
      /*
     * 查询所有
     * */
     List<Device> findDeviceAll();
    /*
     * 根据设备名称查询
     * */
    List<Device> findDeviceByName(String nickName);
    /*
     * 根据Id查询
     * */
    Device findDeviceById(int id);
    /*
     * 增加
     * */
    int addDevice(Device device);
    /*
     * 修改
     * */
    int updateDevice(Device device);
    /*
     * 删除
     * */
    int deteleDevice(int id);

    //更改(增加)控制器所属关系
    public void updateDeviceMap(@Param("id") Integer id, @Param("enduserId") Integer enduserId);

}
