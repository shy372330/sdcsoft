package com.sdcsoft.cn.module.system.controller;

import com.sdcsoft.cn.common.interceptor.MyInterceptor;
import com.sdcsoft.cn.common.utils.JsonResult;

import com.sdcsoft.cn.common.utils.RandomValidateCodeUtil;
import com.sdcsoft.cn.module.system.entity.Permission;
import com.sdcsoft.cn.module.system.entity.User;
import com.sdcsoft.cn.module.system.service.impl.SystemServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;
import java.util.Map;

@SessionAttributes(value={"user"})
@Controller
public class LoginController {
    @Autowired
    private SystemServiceImpl systemService;
    Logger logger = LoggerFactory.getLogger(LoginController.class);
    /**
     * 登录方法
     *
     */
    @RequestMapping(value="/loginin",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult login(String username,
                            String password,
                            String inputStr,
                            HttpServletRequest request){
        User user =systemService.getUserByAccount(username) ;
        if(user == null){
            return new JsonResult(-1,"当前用户"+username+"不存在",null);
        }
      /*  String pwd = DigestUtils.md5DigestAsHex(password.getBytes());*/
        if(!password.equals(user.getPassword())){
            return new JsonResult(-2,"密码错误",null);
        }
       /* if(0 != user.getStatus()){
            return new JsonResult(-3,"当前用户"+username+"异常",null);
        }*/
        user.setPassword(null);
        String random = (String)request.getSession().getAttribute("RANDOMVALIDATECODEKEY");
        boolean isValid =checkVerify(inputStr,random);
        if (isValid==false){
            return new JsonResult(-4,"请输入正确的验证码",null);
        }
        request.getSession().setAttribute("user", user);
        systemService.updateLastLoginTime(user.getId());
        List<Integer> roleList= systemService.getRoleIdsByUserId(user.getId());
        //获取节点内容
        List<Permission> permissionList=  systemService.getPermByRoleIds(roleList);
        request.getSession().setAttribute("permissionList", permissionList);
        return new JsonResult(200,null,user.getOrgId());
    }
    /**
     * 校验验证码
     */
    private boolean checkVerify(String inputStr,String random) {
        try{
            if (random == null) {
                return false;
            }
            if (random.equals(inputStr.toUpperCase())) {
                return true;
            } else {
                return false;
            }
        }catch (Exception e){
            logger.error("验证码校验失败", e);
            return false;
        }
    }
    /**
     * 登出
     * @param session
     */

    @RequestMapping(value="/logout",method=RequestMethod.GET)
    public String logout(SessionStatus session) {
        //清空sessions
        session.setComplete();
        return "redirect:/login";
    }
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/getUserName")
    @ResponseBody
    public String getUserName(HttpServletRequest request){
       return ( (User) request.getSession().getAttribute("user")).getRealName();
    }
    /**
     *进入登录页面
     */
    @RequestMapping(value={"", "/","/login"})
    public String login(){
        return "login";
    }
    /**
     * 生成验证码
     */
    @RequestMapping(value = "/getVerify")
    public void getVerify(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
            response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();
            randomValidateCode.getRandcode(request, response);//输出验证码图片方法
        } catch (Exception e) {
            logger.error("获取验证码失败>>>> ", e);
        }
    }

    /**
     *进入控制器页面
     */
    @RequestMapping("enter_deviceInfo")
    public String enter_deviceInfo(){
        return "enter_deviceInfo";
    }
    /**
     *进入控制器生产厂家页面
     */
    @RequestMapping("enter_manufacturerInfo")
    public String enter_manufacturerInfo(){
        return "enter_manufacturerInfo";
    }
    /**
     *进入企业产品信息页面
     */
    @RequestMapping("enter_enterpriseproduct")
    public String enter_enterpriseproduct(){
        return "enter_enterpriseproduct";
    }
 /**
     *进入销售记录页面
     */
    @RequestMapping("enter_saleInfo")
    public String enter_saleInfo(){
        return "enter_saleInfo";
    }
    //节点获取
    @RequestMapping("permisson")
    @ResponseBody
    public  List<Permission> getPerssions(HttpServletRequest request){
        User user =(User) request.getSession().getAttribute("user");
        //根据用户id获取角色id
        List<Integer> roleList= systemService.getRoleIdsByUserId(user.getId());
        //获取节点内容
        List<Permission> permissionList=  systemService.getPermByRoleIds(roleList);
        return permissionList;
    }

    //进入客户管理页面

    @RequestMapping("enter_customeInfo")
    public String enter_customeInfo(){
        return "enter_customeInfo";
    } //进入客户管理页面

    @RequestMapping("company_endUserInfo")
    public String company_endUserInfo(){
        return "company_endUserInfo";
    }
    /**
     *进入企业—客户管理页面
     */
    @RequestMapping("/enter_enterprisecategoryInfo")
    public String enter_enterprisecategoryInfo(){
        return "enter_enterprisecategoryInfo";
    }
    /**
     *进入企业管理页面
     */
    @RequestMapping("/company_enterpriseInfo")
    public String company_enterpriseInfo(){
        return "company_enterpriseInfo";
    }
    /**
     *进入客户管理页面
     */
    @RequestMapping("/company_customerInfo")
    public String company_customerInfo(){
        return "company_customerInfo";
    }
/**
     *进入企业添加页面
     */
    @RequestMapping("/com_enterpriseInfoAdd")
    public String com_enterpriseInfoAdd(){
        return "com_enterpriseInfoAdd";
    }
    /**
     *进入企业修改页面
     */
    @RequestMapping("/com_enterpriseEdit")
    public String com_enterpriseEdit(){
        return "com_enterpriseEdit";
    }
    /**
     *进入最终用户展示页面
     */
    @RequestMapping("/company_enduser")
    public String company_enduser(){
        return "company_enduser";
    }
    /**
     *进入最终用户购买企业产品
     */
    @RequestMapping("/end_enterpriseProductInfo")
    public String end_enterpriseProductInfo(){
        return "end_enterpriseProductInfo";
    }

    /**
     *进入最终用户购买客户产品
     */
    @RequestMapping("/end_customerProductInfo")
    public String end_customerProductInfo(){
        return "end_customerProductInfo";
    }
    /**
     *进入企业--最终用户页面
     */
    @RequestMapping("/enter_enduser")
    public String enter_enduser(){
        return "enter_enduser";
    }
    /**
     *进入客户--最终用户页面
     */
    @RequestMapping("/customer_endUserInfo")
    public String customer_endUserInfo(){
        return "customer_endUserInfo";
    }
    /**
     *进入客户--购买产品页面
     */
    @RequestMapping("/customer_buyInfo")
    public String customer_buyInfo(){
        return "customer_buyInfo";
    }
    /**
     *进入客户--产品类别管理页面
     */
    @RequestMapping("/customer_categoryInfo")
    public String customer_categoryInfo(){
        return "customer_categoryInfo";
    }
    /**
     *进入客户--控制器管理页面
     */
    @RequestMapping("/customer_deviceInfo")
    public String customer_deviceInfo(){
        return "customer_deviceInfo";
    }

    /**
     *进入客户--产品信息管理页面
     */
    @RequestMapping("/customer_product")
    public String customer_product(){
        return "customer_product";
    }
/**
     *进入客户--销售管理页面
     */
    @RequestMapping("/customer_saleInfo")
    public String customer_saleInfo(){
        return "customer_saleInfo";
    }
/**
     *进入系统--用户管理页面
     */
    @RequestMapping("/system_userInfo")
    public String system_userInfo(){
        return "system_userInfo";
    }
    /**
     *进入客户--销售管理页面
     */
    @RequestMapping("/system_roleInfo")
    public String system_roleInfo(){
        return "system_roleInfo";
    }
    /**
     *进入权限页面
     */
    @RequestMapping("/system_PerInfo")
    public String system_PerInfo(){
        return "system_PerInfo";
    }/**
     *进入企业-最终用户页面
     */
    @RequestMapping("/enter_endUserInfo")
    public String enter_endUserInfo(){
        return "enter_endUserInfo";
    }
    @RequestMapping("/nopermission")
    public String nopermission(){
        return "nopermission";
    }
    @RequestMapping("/timeout")
    public String timeout(){
        return "timeout";
    }

}
