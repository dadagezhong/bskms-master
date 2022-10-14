/*
 * All rights Reserved, Copyright (C) Aisino LIMITED 2019
 * FileName: RoleService.java
 * Version:  1.0
 * Modify record:
 * NO. |     Date       |    Name        |      Content
 * 1   | 2019年1月29日        | Aisino)Jack    | original version
 */
package com.bskms.service;

import java.util.List;

import com.bskms.bean.Role;

/**
 * class name: RoleService <BR>
 * class description: 角色管理 <BR>
 * 
 * @version 1.0 2019年1月29日 下午2:00:19
 * @author Aisino)weihaohao
 */
public interface RoleService {

	List<Role> getAllRole();

	String addRole(String name);

	boolean delRoleById(Integer id);

	int updateRoleById(Integer id, String name);

}
