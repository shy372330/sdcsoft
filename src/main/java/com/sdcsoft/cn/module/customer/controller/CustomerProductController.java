package com.sdcsoft.cn.module.customer.controller;
import com.sdcsoft.cn.module.customer.entity.CustomerProduct;
import com.sdcsoft.cn.module.customer.entity.Device;
import com.sdcsoft.cn.module.customer.service.impl.*;
import com.sdcsoft.cn.module.system.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/customer")
public class CustomerProductController {
    @Autowired
    private CustomerProductServiceImpl customerProductService;
    @Autowired
    private HttpServletRequest request;
    //查找二次产品
    @RequestMapping(value = "/customerProduct", method = RequestMethod.GET)
    public  Map<String,Object> queryCustomerProduct(int page,int limit,String productNameLike ) {
        //获取组织id
        Integer customerId =((User) request.getSession().getAttribute("user")).getOrgId();
        List<CustomerProduct> list =customerProductService.queryCustomerProductByCustomerId(customerId,page,limit,productNameLike );
        int count = customerProductService.selectCustomerProductCount(customerId,productNameLike );
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","数据获取成功");
        map.put("count",count);
        map.put("data",list);
        return map;
    }
   //增加客户产品信息
    @PostMapping(value = "/savecProduct" )
    public String save( String productCode,Integer enterpriseProductCodeId,Integer categoryId) {
         //获取组织id
         Integer customerId =((User) request.getSession().getAttribute("user")).getOrgId();
        CustomerProduct cProduct =new CustomerProduct();
         cProduct.setCustomerId(customerId);
          cProduct.setProductCode(productCode);
          cProduct.setCategoryId(categoryId);
        cProduct.setEnterpriseProductCodeId(enterpriseProductCodeId);
        customerProductService.insertCustomerProduct(cProduct);
        return "success";
    }

    /*修改*/
    @RequestMapping(value = "/updatecProduct",method = RequestMethod.GET)
    public String update( String productCode , Integer deviceId,Integer enterpriseProductCodeId,
                         Integer categoryId,Integer status,Integer enterpriseProductCodeIdBefore  ) {
        //获取组织id
        Integer customerId =((User) request.getSession().getAttribute("user")).getOrgId();
        CustomerProduct c =new CustomerProduct();
        c.setDeviceId(deviceId);
        c.setCustomerId(customerId);
        c.setCategoryId(categoryId);
        c.setProductCode(productCode);
        c.setStatus(status);
        c.setEnterpriseProductCodeId(enterpriseProductCodeId);
        customerProductService.updateCustomerProduct(productCode,c,enterpriseProductCodeId,
                enterpriseProductCodeIdBefore );
        return "success";
    }
    /*删除设备*/
    @PostMapping(value = "/detelecProduct")
    public String detele(Integer id ,Integer enterpriseProductCodeId) {
        customerProductService.deleteCustomerProductByProductCode(id,enterpriseProductCodeId);
        return "success";
    }
    @RequestMapping("/findDeviceInfo")
    public List<Device> findDeviceInfo(){
        Integer customerId =((User) request.getSession().getAttribute("user")).getOrgId();
        return customerProductService.findDeviceInfo( customerId);
    }
    //查找企业产品
    @RequestMapping("/findEnterpriseProductInfo")
    public List<Map<String,Object>> findEnterpriseProductInfo(){
        //获取组织id
        Integer customerId =((User) request.getSession().getAttribute("user")).getOrgId();
        return customerProductService.findEnterpriseProductInfo(customerId);
    }
    //查找客户二次产品
    @RequestMapping("/findCustomerProductInfo")
    public List<Map<String,Object>> findCustomerProductInfo(){
        //获取组织id
        Integer customerId =((User) request.getSession().getAttribute("user")).getOrgId();
        return customerProductService.findCustomerProductInfo(customerId);
    }
}
