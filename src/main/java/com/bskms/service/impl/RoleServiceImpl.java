/*
 * All rights Reserved, Copyright (C) Aisino LIMITED 2019
 * FileName: RoleServiceImpl.java
 * Version:  1.0
 * Modify record:
 * NO. |     Date       |    Name        |      Content
 * 1   | 2019年1月29日        | Aisino)Jack    | original version
 */
package com.bskms.service.impl;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.bskms.bean.Role;
import com.bskms.bean.RoleExample;
import com.bskms.mapper.RoleMapper;
import com.bskms.service.RoleService;

/**
 * class name: RoleServiceImpl <BR>
 * class description: please write your description <BR>
 * 
 * @version 1.0 2019年1月29日 下午2:01:04
 * @author Aisino)weihaohao
 */
@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleMapper roleMapper;
	private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

	/**
	 * @Override
	 * @see com.aisino.arrms.service.RoleService#getAllRole() <BR>
	 *      Method name: getAllRole <BR>
	 *      Description: 获取所有角色 <BR>
	 *      Remark: <BR>
	 * @return <BR>
	 */
	@Override
	public List<Role> getAllRole() {
		RoleExample example = new RoleExample();
		example.createCriteria().andRoleIdIsNotNull();
		try {
			return roleMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("获取所有角色异常", e);
			return Collections.emptyList();
		}
	}

	/**
	 * @Override
	 * @see com.aisino.arrms.service.RoleService#addRole(java.lang.String) <BR>
	 *      Method name: addRole <BR>
	 *      Description: 添加角色 <BR>
	 *      Remark: <BR>
	 * @param name
	 * @return <BR>
	 */
	@Override
	@Transactional
	public String addRole(String name) {
		Role record = new Role();
		record.setName(name);
		try {
			roleMapper.insert(record);
			return "SUCCESS";
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error("添加角色异常", e);
			return "ERROR";
		}
	}

	/**
	 * @Override
	 * @see com.aisino.arrms.service.RoleService#delRoleById(int) <BR>
	 *      Method name: delRoleById <BR>
	 *      Description: 根据权限id删除权限 <BR>
	 *      Remark: <BR>
	 * @param id
	 * @return <BR>
	 */
	@Override
	@Transactional
	public boolean delRoleById(Integer id) {
		try {
			roleMapper.deleteByPrimaryKey(id);
			return true;
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error("根据权限id删除权限异常", e);
			return false;
		}
	}

	/**
	 * @Override
	 * @see com.aisino.arrms.service.RoleService#updateRoleById(int,
	 *      java.lang.String) <BR>
	 *      Method name: updateRoleById <BR>
	 *      Description: 根据权限id更新权限 <BR>
	 *      Remark: <BR>
	 * @param id
	 * @param name
	 * @return <BR>
	 */
	@Override
	@Transactional
	public int updateRoleById(Integer id, String name) {
		Role record = new Role();
		record.setName(name);

		RoleExample example = new RoleExample();

		example.createCriteria().andRoleIdEqualTo(id);

		try {
			roleMapper.updateByExampleSelective(record, example);
			return 1;
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error("根据权限id更新权限异常", e);
			return 0;
		}
	}
}