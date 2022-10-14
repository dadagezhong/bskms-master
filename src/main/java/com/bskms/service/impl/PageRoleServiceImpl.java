/*
 * All rights Reserved, Copyright (C) Aisino LIMITED 2019
 * FileName: PageRoleServiceImpl.java
 * Version:  1.0
 * Modify record:
 * NO. |     Date       |    Name        |      Content
 * 1   | 2019年1月29日        | Aisino)Jack    | original version
 */
package com.bskms.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.bskms.bean.RolePage;
import com.bskms.bean.RolePageExample;
import com.bskms.mapper.RolePageMapper;
import com.bskms.service.PageRoleService;

/**
 * class name: PageRoleServiceImpl <BR>
 * class description: please write your description <BR>
 * 
 * @version 1.0 2019年1月29日 下午2:54:56
 * @author Aisino)weihaohao
 */
@Service
public class PageRoleServiceImpl implements PageRoleService {
	@Autowired
	private RolePageMapper rolePageMapper;
	/** logback日志记录 */
	private static final Logger logger = LoggerFactory.getLogger(PageRoleServiceImpl.class);

	/**
	 * @Override
	 * @see com.aisino.arrms.service.PageRoleService#delPageRoleByRoleId(int) <BR>
	 *      Method name: delPageRoleByRoleId <BR>
	 *      Description: 根据权限id删除权限页面表 <BR>
	 *      Remark: <BR>
	 * @param id
	 * @return <BR>
	 */
	@Override
	@Transactional
	public boolean delPageRoleByRoleId(Integer id) {
		RolePageExample excExample = new RolePageExample();
		excExample.createCriteria().andRoleIdEqualTo(id).andRpIdGreaterThan(4);
		try {
			rolePageMapper.deleteByExample(excExample);
			return true;
		} catch (Exception e) {
			logger.error("删除页面-权限出错!", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return false;
		}
	}

	/**
	 * @Override
	 * @see com.aisino.arrms.service.PageRoleService#addPageRoles(int[]) <BR>
	 *      Method name: addPageRoles <BR>
	 *      Description: 根据角色id添加页面角色表 <BR>
	 *      Remark: <BR>
	 * @param pageIds
	 * @return <BR>
	 */
	@Override
	@Transactional
	public boolean addPageRoles(Integer roleId, Integer[] pageIds) {
		try {
			if (pageIds != null && pageIds.length > 0) {
				for (int pageId : pageIds) {
					RolePage rolePage = new RolePage();
					rolePage.setRoleId(roleId);
					rolePage.setPageId(pageId);
					rolePageMapper.insert(rolePage);
				}
			}
			return true;
		} catch (Exception e) {
			logger.error("添加页面-权限出错!", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return false;
		}
	}
}
