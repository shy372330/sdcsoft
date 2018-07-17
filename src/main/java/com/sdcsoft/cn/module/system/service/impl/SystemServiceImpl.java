package com.sdcsoft.cn.module.system.service.impl;

import com.sdcsoft.cn.module.system.entity.Permission;
import com.sdcsoft.cn.module.system.entity.Role;
import com.sdcsoft.cn.module.system.entity.User;
import com.sdcsoft.cn.module.system.mapper.ManageMapper;
import com.sdcsoft.cn.module.system.mapper.SystemMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class SystemServiceImpl {
    @Autowired
    private SystemMapper systemMapper;
    @Autowired
    ManageMapper manageMapper;
    //根据账号获取用户信息
    public User getUserByAccount(String account){
        return  systemMapper.getUserByAccount(account);
    }
   // 根据用户的id获取其对应的角色id
    public List<Integer > getRoleIdsByUserId(Integer id){
        return systemMapper.getRoleIdsByUserId(id);
    }

    //通过角色ID查找信息
    public List<Permission> findInfoByRoleIds(List<Integer> roleIds){
        return systemMapper.findInfoByRoleIds(roleIds);
    }

    //根据角色id查找功能

    public  List<Permission>	getPermByRoleIds(List<Integer> roleIds){
        return systemMapper.getPermByRoleIds(roleIds);
    }
    //查找所有的用户信息
    public List<User> getUserInfo( int page,   int limit,  String realName){
        int from =( page-1)*limit;
        return manageMapper.getUserInfo(from,limit,realName);
    }
    //增加用户信息
    public void  addUserInfo(  User user){
         manageMapper.addUserInfo(user);
    }
    //修改用户信息
    public void updateUserInfo( User user){
        manageMapper.updateUserInfo(user);
    }
    //删除用户信息
    public void delUseInfo(Integer userId){
        manageMapper.delUseInfo(userId);
    }
    //查找所有的角色
    public List<Role> getRoleInfo(int page, int limit, String roleName){
        int from = (page-1) *limit;
        return manageMapper.getRoleInfo(from ,limit,roleName);
    }
    //查找角色的数量

    //增加角色信息
    public void  addRoleInfo( String roleName, String roleDesc ){
        manageMapper.addRoleInfo(roleName,roleDesc);
    }
    //修改角色信息
    public void updateRoleInfo( Integer roleId, String roleName, String roleDesc ){
        manageMapper.updateRoleInfo(roleId,roleName,roleDesc);
    }
    //删除角色信息
    public void delRoleInfo(Integer roleId){
        manageMapper.delRoleInfo(roleId);
    }

    public Integer selectUserInfoCount(String realName) {
        return  manageMapper.selectUserInfoCount(realName);
    }
    //查找角色信息数量
    public int selectRoleInfoCount(String roleName) {
        return manageMapper.selectRoleInfoCount(roleName);
    }
    //查找所有的权限
    public List<Permission> getResourceInfo(int page, int limit, String resName){
        int from =(page-1)*limit;
        return manageMapper.getResourceInfo(from,limit,resName);
    }
    //获取权限数量
    public int selecResourceInfoCount(String resName) {
        return  manageMapper.selecResourceInfoCount(resName);
    }
    //获取所有的角色信息
    public List<Role> getRoleInfoAll() {
        return manageMapper.getRoleInfoAll();
    }
    //根据用户的Id获取其对应的所有角色信息
    public List<Role> getRoleInfoByUserId(Integer userId){
        return manageMapper.getUserRoleInfo(userId);
    }
    //增加用户角色对应关系
    public  void addUserRole(List<Map<String,Object>> list){
        manageMapper.addUserRole(list);
    }
    //删除用户角色对应关系
    public void delUserRole( Integer userId){
        manageMapper.delUserRole(userId);
    }
    //查询角色对应的权限内容
    public List<Permission> getRoleResInfo(Integer roleId){
        return  manageMapper.getRoleResInfo(roleId);
    }

    //增加角色对应的权限
    public void addRoleRes(List<Map<String,Object>> list){
        manageMapper.addRoleRes(list);
    }
    //删除角色对应的权限
    public void delRoleRes(Integer roleId){
        manageMapper.delRolelRes(roleId);
    }
    //根据用户的id修改最后的登录时间
    public void updateLastLoginTime(Integer id) {
        manageMapper.updateLastLoginTime(id);
    }
    //根据用户信息获取其对应的信息
}
