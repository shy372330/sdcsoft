package com.sdcsoft.cn.module.customer.controller;

import com.sdcsoft.cn.module.customer.entity.CustomerBuyRecord;
import com.sdcsoft.cn.module.customer.service.impl.CustomerBuyRecordImpl;
import com.sdcsoft.cn.module.system.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController("customerBuy")
@RequestMapping("/customer")
public class CustomerBuyRecordController {
    @Autowired
    private CustomerBuyRecordImpl customerBuyRecordImpl;
    @Autowired
    private HttpServletRequest request;
    //获取客户的购买记录
    @RequestMapping("/getBuyRecord")
    public Map<String,Object> getBuyRecord(int page,int limit, String productNameLike){
        //获取组织id
        Integer customerId =((User) request.getSession().getAttribute("user")).getOrgId();
        List<CustomerBuyRecord> list =customerBuyRecordImpl.getBuyRecord(customerId,page,limit,productNameLike );
        Integer count = customerBuyRecordImpl.getBuyRecordCount(customerId,productNameLike );
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","数据获取成功");
        map.put("count",count);
        map.put("data",list);
        return map;
    }
}
