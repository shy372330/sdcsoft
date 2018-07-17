package com.sdcsoft.cn.module.system.mapper;


import com.sdcsoft.cn.module.permissions.bean.Permissions;
import com.sdcsoft.cn.module.system.entity.Permission;
import com.sdcsoft.cn.module.system.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component("SystemMapper")
public interface SystemMapper {
	/**
	 * 根据qq或
	 * @param qq 或 手机号码 获取登陆用户信息	 */
	public User getUserByAccount(String account);
	/**
	 *
	 *  根据用户的id获取其对应的角色id	 */

	public List<Integer > getRoleIdsByUserId(Integer id);
	/**
	 * 通过角色ID查找信息
	 * @param roleIds
	 * @return
	 */
	public List<Permission> findInfoByRoleIds(List<Integer> roleIds);

	/**
	 * ͨ根据角色id查找功能
	 */
	public List<Permission>	getPermByRoleIds(List<Integer> roleIds);


}
