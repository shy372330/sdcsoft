package com.sdcsoft.cn.module.customer.controller;

import com.sdcsoft.cn.module.customer.entity.CustomerSaleRecord;
import com.sdcsoft.cn.module.customer.service.impl.CustomerSaleRecordServiceImpl;

import com.sdcsoft.cn.module.system.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController("CustomerSaleRecordController")
@RequestMapping("/customer")
public class CustomerSaleRecordController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private CustomerSaleRecordServiceImpl customerSaleRecordService;
    @RequestMapping(value = "/CustomerSR", method = RequestMethod.GET)
    public Map<String, Object>  queryEndUser(int page,int limit,String nameLike,String endUserLike){
        //获取组织id
        Integer customerId =((User) request.getSession().getAttribute("user")).getOrgId();
        List<CustomerSaleRecord> list =customerSaleRecordService.selectCustomerSale(customerId,page,limit,nameLike,endUserLike);
        Integer count = customerSaleRecordService.selectCustomerSaleCount(customerId,nameLike,endUserLike);
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","数据获取成功");
        map.put("count",count);
        map.put("data",list);
        return map;
    }
    //增加销售记录
    @PostMapping(value = "/addSaleRecord")
    public String addSaleRecord( Integer customerProductId,Integer endUserId, String saleDatetime) {
        Integer customerId = ((User) request.getSession().getAttribute("user")).getOrgId();
        customerSaleRecordService.addSaleRecord(customerProductId, customerId, endUserId, saleDatetime);
        return "success";
    }
}
