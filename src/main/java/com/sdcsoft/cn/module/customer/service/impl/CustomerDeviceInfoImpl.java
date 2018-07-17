package com.sdcsoft.cn.module.customer.service.impl;

import com.sdcsoft.cn.module.customer.dao.CustomerDeviceDao;
import com.sdcsoft.cn.module.customer.entity.CustomerCategory;
import com.sdcsoft.cn.module.customer.entity.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CustomerDeviceInfoImpl")
public class CustomerDeviceInfoImpl {
    @Autowired
    private CustomerDeviceDao customerDeviceDao;
    public List<Device> getCusdDviceInfoById(Integer employeeId, int page, int limit, String nameLike) {
          int from = (page-1)*limit;
           return customerDeviceDao.getCusdDviceInfoById(employeeId,from,limit,nameLike);
    }

    public Integer findCustomerDeviceCountByCId(Integer employeeId, String nameLike) {
            return customerDeviceDao.findCustomerDeviceCountByCId(employeeId,nameLike);
    }
}
