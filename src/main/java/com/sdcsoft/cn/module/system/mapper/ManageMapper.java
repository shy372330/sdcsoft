package com.sdcsoft.cn.module.system.mapper;

import com.sdcsoft.cn.module.system.entity.Permission;
import com.sdcsoft.cn.module.system.entity.Role;
import com.sdcsoft.cn.module.system.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component("manageMapper")
public interface ManageMapper {
    //查找所有的用户信息
    public List<User> getUserInfo(@Param("from") int from, @Param("limit") int limit, @Param("realName") String realName);
    //增加用户信息
    public void  addUserInfo(User user);
    //修改用户信息
    public void updateUserInfo(User user);
    //删除用户信息
    public void delUseInfo(Integer userId);

    //查找所有的角色
    public List<Role> getRoleInfo(@Param("from") int from, @Param("limit") int limit, @Param("roleName") String roleName);
    //增加角色信息
    public void  addRoleInfo(@Param("roleName") String roleName, @Param("roleDesc") String roleDesc);
    //修改角色信息
    public void updateRoleInfo(@Param("roleId") Integer roleId, @Param("roleName") String roleName, @Param("roleDesc") String roleDesc);
    //删除角色信息
    public void delRoleInfo(Integer roleId);

    //查找所有的权限
    public List<Permission> getResourceInfo(@Param("from") int from, @Param("limit") int limit, @Param("resName") String resName);
    //增加权限信息
    public void  addResourceInfo(@Param("resName") String resName, @Param("pId") Integer pId, @Param("url") String url, @Param("permission") String permission);
    //修改权限信息
    public void updateResourceInfo(@Param("resId") Integer resId, @Param("resName") String resName, @Param("pId") Integer pId, @Param("url") String url, @Param("permission") String permission);
    //删除权限信息
    public void delResourceInfo(Integer userId);

    ///*----------------------------------------以下为给用户分配角色操作
    //查找用户对应角色信息
    public List<Role> getUserRoleInfo(Integer userId);
    //删除用户角色对应关系
    public void delUserRole(Integer userId);
    //增加用户角色对应关系
    public  void addUserRole(List<Map<String, Object>> list);
    //修改用户角色对应关系
    public void  updateUserRole(List<Map<String, Object>> list);
    //------------------------------以下为给角色分配权限
    //查询角色对应的权限内容
    public List<Permission> getRoleResInfo(@Param("roleId") Integer roleId);
    //删除角色权限对应的关系
    public void delRolelRes(Integer roleId);
    //    //修改角色对应权限关系
    public void updateRoleRes(List<Map<String, Object>> list);
    //增加角色对应的权限关系
    public void addRoleRes(List<Map<String, Object>> list);
    //获取用户数量
    Integer selectUserInfoCount(@Param("realName") String realName);
    //获取角色数量
    int selectRoleInfoCount(@Param("roleName") String roleName);
    //获取权限数量
    int selecResourceInfoCount(@Param("resName") String resName);
    //获取所有的角色
    List<Role> getRoleInfoAll();
    //修改用户的最后登陆时间
    void updateLastLoginTime(Integer id);
}
