package com.sdcsoft.cn.module.endUser.controller;

import com.sdcsoft.cn.module.endUser.service.EndUserService;
import com.sdcsoft.cn.module.system.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RequestMapping("/endUser")
@Controller
public class EndUserController {
    @Autowired
    private EndUserService endUserService;
    @Autowired
    private HttpServletRequest request;
    //查找企业信息
    @RequestMapping("/findEnterpriseInfo")
    @ResponseBody
    public Map<String,Object> findEnterpriseInfo(){
        List<Map<String,Object>> list =endUserService.findEnterpriseInfo();
        Integer count = endUserService.selectEntepriseInfoCount();
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","数据获取成功");
        map.put("count",count);
        map.put("data",list);
        return map;
    }

    //查找客户信息

    @RequestMapping("/findCustomerInfo")
    @ResponseBody
    public Map<String,Object> findCustomerInfo(){
        List<Map<String,Object>> list =endUserService.findCustomerInfo();
        Integer count = endUserService.selectCustomerInfo();
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","数据获取成功");
        map.put("count",count);
        map.put("data",list);
        return map;
    }

    //查找企业处购买产品信息
    @RequestMapping("/findProductFromE")
    @ResponseBody
    public Map<String,Object> findProductFromE(int page,int limit,String nameLike){
        Integer endUserId =((User) request.getSession().getAttribute("user")).getOrgId();
        List<Map<String,Object>> list =endUserService.findProductFromE(endUserId,page,limit,nameLike);
        Integer count = endUserService.selectCountFromE(endUserId,nameLike);
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","数据获取成功");
        map.put("count",count);
        map.put("data",list);
        return map;
    }
    //查找客户处购买产品信息
    @RequestMapping("/findProductFromC")
    @ResponseBody
    public Map<String,Object> findProductFromC(int page,int limit,String nameLike){
        Integer endUserId =((User) request.getSession().getAttribute("user")).getOrgId();
        List<Map<String,Object>> list =endUserService.findProductFromC(endUserId,page,limit,nameLike);
        Integer count = endUserService.selectCountFromC(endUserId,nameLike);
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","数据获取成功");
        map.put("count",count);
        map.put("data",list);
        return map;
    }
}
