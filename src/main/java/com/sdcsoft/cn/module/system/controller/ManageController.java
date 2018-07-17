package com.sdcsoft.cn.module.system.controller;

import com.sdcsoft.cn.module.system.entity.Permission;
import com.sdcsoft.cn.module.system.entity.Role;
import com.sdcsoft.cn.module.system.entity.User;
import com.sdcsoft.cn.module.system.service.impl.SystemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/manage")
public class ManageController {
    @Autowired
    private SystemServiceImpl systemService;
    //查找所有的用户信息
    @RequestMapping("/getUserInfo")
    @ResponseBody
    public  Map<String,Object>  getUserInfo( int page,   int limit,  String realName){
        List<User> list = systemService.getUserInfo(page,limit,realName);
        Map<String,Object> map = new HashMap<>();
        Integer count = systemService.selectUserInfoCount(realName);
        map.put("code",0);
        map.put("msg","数据获取成功");
        map.put("count",count);
        map.put("data",list);
        return map;
    }
    @PostMapping("/addUserInfo")
    @ResponseBody
    //增加用户信息
    public String  addUserInfo( Integer orgType,Integer orgId,String password,
                                String mobile,String email,String weiXin,
                                String qQ,String realName, Integer status,
                                String lastLoginDatetime,String mark,Integer isDeleted){
        User user = new User();
        user.setPassword(password);
        user.setEmail(email);
        user.setIsDeleted(isDeleted);
        user.setLastLoginDatetime(lastLoginDatetime);
        user.setMark(mark);
        user.setMobile(mobile);
        user.setOrgId(orgId);
        user.setOrgType(orgType);
        user.setStatus(status);
        user.setqQ(qQ);
        user.setRealName(realName);
        user.setWeiXin(weiXin);
        systemService.addUserInfo(user);
        return  "success";
    }
    @RequestMapping("/updateUserInfo")
    @ResponseBody
    //修改用户信息
    public String updateUserInfo( User user){
        systemService.updateUserInfo(user);
        return "success";
    }
    @RequestMapping("/delUseInfo")
    @ResponseBody
    //删除用户信息
    public String delUseInfo(Integer userId){
        systemService.delUseInfo(userId);
        return "success";
    }

    //查找所有的角色信息
    @RequestMapping("/getRoleInfo")
    @ResponseBody
    public  Map<String,Object>  getRoleInfo( int page,   int limit,  String roleName){
        List<Role> list = systemService.getRoleInfo(page,limit,roleName);
        Map<String,Object> map = new HashMap<>();
        int count = systemService.selectRoleInfoCount(roleName);
        map.put("code",0);
        map.put("msg","数据获取成功");
        map.put("count",count);
        map.put("data",list);
        return map;
    }  //查找所有的角色信息
    @RequestMapping("/getRoleInfoAll")
    @ResponseBody
    public  List<Role>  getRoleInfoAll(){
        List<Role> list = systemService.getRoleInfoAll();

        return list;
    }
    @PostMapping("/addRoleInfo")
    @ResponseBody
    //增加角色信息
    public String  addRoleInfo( String roleName, String roleDesc ){
        systemService.addRoleInfo(roleName,roleDesc);
        return "success";
    }
    @PostMapping("/updateRoleInfo")
    @ResponseBody
    //修改角色信息
    public String updateRoleInfo( Integer roleId, String roleName, String roleDesc ){
        systemService.updateRoleInfo(roleId,roleName,roleDesc);
        return "success";
    }
    @PostMapping("/delRoleInfo")
    @ResponseBody
    //删除角色信息
    public String delRoleInfo(Integer roleId){
        systemService.delRoleInfo(roleId);
        return "success";
    }
    //查找所有的权限信息
    @RequestMapping("/getPerInfo")
    @ResponseBody
    public  Map<String,Object>  getPerInfo( int page,   int limit,  String resName){
        List<Permission> list = systemService.getResourceInfo(page,limit,resName);
        Map<String,Object> map = new HashMap<>();
        int count = systemService.selecResourceInfoCount(resName);
        map.put("code",0);
        map.put("msg","数据获取成功");
        map.put("count",count);
        map.put("data",list);
        return map;
    }
    //根据用户的id 获取其对应的角色信息
    @RequestMapping("/getRoleInfoByUserId")
    @ResponseBody
    public List<Role> getRoleInfoByUserId(Integer userId){
        return systemService.getRoleInfoByUserId(userId);
    }
    //修改用户角色对应关系
    @RequestMapping("/addUserRole")
    @ResponseBody
    public  String addUserRole(Integer userId,int[] array){
        //先去数据库查询有没有此对应关系，如果有的话就不增加，如果用户取消选择的话那么应该先去清除关系,每次增加前先去清空一下再添加
        systemService.delUserRole(userId);
        List<Map<String,Object>> list = new ArrayList<>();
        for (int arr:array){
            Map<String,Object> map = new HashMap<>();
            map.put("userId",userId);
            map.put("roleId",arr);
            list.add(map);
        }
        systemService.addUserRole(list);
        return  "success";
    }
    //查询所有的角色对应的权限内容
    @RequestMapping("/getRoleResInfo")
    @ResponseBody
    public List<Permission> getRoleResInfo(Integer roleId){
        return  systemService.getRoleResInfo(roleId);
    }
//授权处理所有的角色对应的权限内容
    @PostMapping("/addRoleResInfo")
    @ResponseBody
    public String addRoleResInfo(Integer roleId,int[] array){
        systemService.delRoleRes(roleId);
        List<Map<String,Object>> list = new ArrayList<>();
        for (int arr:array){
            Map<String,Object> map = new HashMap<>();
            map.put("roleId",roleId);
            map.put("resId",arr);
            list.add(map);
        }
        systemService.addRoleRes(list);
        return  "success";

    }


}
