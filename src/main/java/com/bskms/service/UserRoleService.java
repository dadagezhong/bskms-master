package com.bskms.service;

import java.util.List;

import com.bskms.bean.UserRole;
import com.bskms.model.ResultMap;

/**
 * @author zwg
 * @version 创建时间：2019年1月25日 下午2:06:11
 * @ClassName UserRoleService
 * @Description 类描述
 */
public interface UserRoleService {
	List<UserRole> getRoleByUserId(String userId);

	boolean delUserRoleByRoleId(int id);

	ResultMap delUserRoleByUserIdAndRoleId(String userId, Integer roleId);

	String addUserRole(Integer roleId, String[] userIds);

	UserRole getUserRole(String userId);
}
