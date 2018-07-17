package com.sdcsoft.cn.module.customer.service.impl;

import com.sdcsoft.cn.module.customer.dao.DeviceDao;
import com.sdcsoft.cn.module.customer.entity.Device;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DeviceServiceImpl")
public class DeviceServiceImpl {

    @Autowired
    private DeviceDao deviceDao;

    public Device findDeviceById(int id) {
        return deviceDao.findDeviceById(id);
    }
    public List<Device> findDeviceAll() {
        return deviceDao.findDeviceAll();
    }
    public List<Device>  findDeviceByName(String nickName) { return deviceDao.findDeviceByName(nickName); }


    public int addDevice(Device device) {
        return deviceDao.addDevice(device);
    }


    public int updateDevice(Device device) {
        return deviceDao.updateDevice(device);
    }


    public int deteleDevice(int id) {
        return deviceDao.deteleDevice(id);
    }
    //更改(增加)控制器所属关系
    public void updateDeviceMap(  Integer id,   Integer enduserId){
        deviceDao.updateDeviceMap(id,enduserId);
    }
}
