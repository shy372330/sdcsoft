package com.sdcsoft.cn.module.endUser.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Mapper
@Component("endUserMapper")
public interface EndUserMapper {
	//查找相关的企业信息
	 List<Map<String, Object>> findEnterpriseInfo();
	//添加对应企业信息
	 void addEnterpriseInfo(@Param("enterpriseId") Integer enterpriseId, @Param("customerId") Integer customerId,
                            @Param("endUserName") String endUserName);
	//删除企业信息
	 void delEnterpriseInfo(Integer endUserId);

	//修改企业信息
	 void updateEnterpriseInfo(@Param("endUserId") Integer endUserId, @Param("enterpriseId") Integer enterpriseId
     );
	//查找企业信息总行数
	int selectEntepriseInfoCount();
	//查找客户信息
	List<Map<String, Object>> findCustomerInfo();
	 //添加客户信息
	void addCustomerInfo(@Param("enterpriseId") Integer enterpriseId, @Param("customerId") Integer customerId,
                         @Param("endUserName") String endUserName);
	//删除客户信息
	void delCustomerInfo(Integer endUserId);
	//修改客户信息
	void updateCustomerInfo(@Param("endUserId") Integer endUserId, @Param("customerId") Integer customerId);
	//查找客户总行数
	int selectCustomerInfo();
	//查找企业处购买产品信息
	List<Map<String, Object>> findProductFromE(@Param("endUserId") Integer endUserId, @Param("from") int from, @Param("limit") int limit, @Param("nameLike") String nameLike);
	//查找企业处购买的产品信息数量
	int selectCountFromE(@Param("endUserId") Integer endUserId, @Param("nameLike") String nameLike);
	//查找客户处购买的产品数量
	int selectCountFromC(@Param("endUserId") Integer endUserId, @Param("nameLike") String nameLike);
	//查找客户处购买的产品
	List<Map<String,Object>> findProductFromC(@Param("endUserId") Integer endUserId, @Param("from") int from, @Param("limit") int limit, @Param("nameLike") String nameLike);

}