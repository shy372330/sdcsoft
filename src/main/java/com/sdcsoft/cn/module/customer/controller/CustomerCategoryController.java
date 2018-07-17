package com.sdcsoft.cn.module.customer.controller;

import com.sdcsoft.cn.module.customer.entity.CustomerCategory;
import com.sdcsoft.cn.module.customer.service.impl.CustomerCategoryServiceImpl;
import com.sdcsoft.cn.module.system.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController("CustomerCategoryController")
@RequestMapping("/customer")
public class CustomerCategoryController {
    @Autowired
    private CustomerCategoryServiceImpl customerCategoryService;
    @Autowired
    private HttpServletRequest request;
    /*列表*/
    @RequestMapping(value = "/CustomerCgList",method = RequestMethod.GET)
    public   Map<String,Object> findById( int page,int limit,String nameLike){
        Integer customerId =((User) request.getSession().getAttribute("user")).getOrgId();
        List<CustomerCategory> list =customerCategoryService.findCustomerCgByCId(customerId,page,limit,nameLike);
        Integer count = customerCategoryService.findCustomerCgCountByCId(customerId,nameLike);
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","数据获取成功");
        map.put("count",count);
        map.put("data",list);
        return map;
    }

    /*保存设备*/
    @RequestMapping(value = "/saveCustomerCg",method = RequestMethod.POST)
    private String save( String categoryName ) {
        Integer customerId =((User) request.getSession().getAttribute("user")).getOrgId();
        CustomerCategory customerCategory = new CustomerCategory();
        customerCategory.setCustomerId(customerId);
        customerCategory.setCategoryName(categoryName);
        customerCategory.setLocalId("0");
        customerCategoryService.addCustomerCg(customerCategory);
        return "success";
    }

    /*修改*/
    @RequestMapping(value = "/updateCustomerCg",method = RequestMethod.POST)
    private String update(int id,String categoryName) {
        Integer customerId =((User) request.getSession().getAttribute("user")).getOrgId();
        CustomerCategory c= customerCategoryService.findCustomerCgById(id);
        c.setCategoryName(categoryName);
        c.setCustomerId(customerId);
        c.setLocalId("0");
        customerCategoryService.updateCustomerCg(c);
        return "success";
    }
    /*删除设备*/
    @PostMapping( "/deteleCustomerCg")
    private String detele(@RequestParam int id) {
        customerCategoryService.deteleCustomerCg(id);
        return "success";
    }

}
