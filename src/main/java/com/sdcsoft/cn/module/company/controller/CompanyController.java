package com.sdcsoft.cn.module.company.controller;
import com.sdcsoft.cn.module.company.entity.Customer;
import com.sdcsoft.cn.module.company.entity.EndUser;
import com.sdcsoft.cn.module.company.entity.Enterprise;
import com.sdcsoft.cn.module.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller("CompanyController")
@RequestMapping("/company")
public class CompanyController {
   @Autowired
    private CompanyService companyService;
    //分页查找企业信息
    @RequestMapping("/getEnterpriseInfoByPage")
    @ResponseBody
    public Map<String,Object> getEnterpriseInfoByPage(Integer page,Integer limit,String nameLike){
        List<Enterprise> list =companyService.getEnterpriseInfoByPage( page,limit,nameLike);
        Integer count = companyService.selectCompanyCount(nameLike);
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","数据获取成功");
        map.put("count",count);
        map.put("data",list);
        return map;
    }
    //删除企业信息
    @PostMapping( "/delEnterpriseInfo" )
    @ResponseBody
    public String delEnterpriseInfo(Integer enterpriseId){
        companyService.delEnterpriseInfo(enterpriseId);
        return "success";
    }
    //增加企业信息
    @PostMapping("/insertEnterpriseInfo")
    @ResponseBody
    public String insertEnterpriseInfo(String enterpriseName, Integer status){
        Enterprise enterprise = new Enterprise();
        enterprise.setEnterpriseName(enterpriseName);
        enterprise.setStatus(status);
        companyService.insertEnterpriseInfo(enterprise);
        return "success";
    }
    //修改企业信息
    @PostMapping("/updateEnterpriseInfo")
    @ResponseBody
    public String updateEnterpriseInfo(Integer enterpriseId, String enterpriseName, Integer status){
        Enterprise enterprise = new Enterprise();
        enterprise.setId(enterpriseId);
        enterprise.setEnterpriseName(enterpriseName);
        enterprise.setStatus(status);
        companyService.updateEnterpriseInfo(enterprise);
        return "success";
    }
    //分页查找客户信息
    @RequestMapping("/getCustomerInfoByPage")
    @ResponseBody
    public Map<String,Object> getCustomerInfoByPage(Integer page,Integer limit,String nameLike){
        List<Customer> list =companyService.getCustomerInfoByPage(page,limit,nameLike);
        Integer count = companyService.selectCustomerCount(nameLike);
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","数据获取成功");
        map.put("count",count);
        map.put("data",list);
        return map;
    } //分页查找最终用户信息
    @RequestMapping("/getEndUserInfoByPage")
    @ResponseBody
    public Map<String,Object> getEndUserInfoByPage(Integer page,Integer limit,String nameLike){
        List<EndUser> list =companyService.getEndUserInfoByPage(page,limit,nameLike);
        Integer count = companyService.selectEndUserCount(nameLike);
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","数据获取成功");
        map.put("count",count);
        map.put("data",list);
        return map;
    }
}
