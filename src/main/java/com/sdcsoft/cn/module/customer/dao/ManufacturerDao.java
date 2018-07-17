package com.sdcsoft.cn.module.customer.dao;


import com.sdcsoft.cn.module.customer.entity.Manufacturer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("ManufacturerDao")
public interface ManufacturerDao {
    /*
     * 查询所有
     * */
    List<Manufacturer> findManufacturerAll();
}
