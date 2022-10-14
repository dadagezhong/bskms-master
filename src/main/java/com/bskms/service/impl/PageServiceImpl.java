/*
 * All rights Reserved, Copyright (C) Aisino LIMITED 2019
 * FileName: PageServiceImpl.java
 * Version:  1.0
 * Modify record:
 * NO. |     Date       |    Name        |      Content
 * 1   | Jan 27, 2019        | Aisino)19604    | original version
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

import com.bskms.bean.Page;
import com.bskms.bean.PageExample;
import com.bskms.mapper.PageMapper;
import com.bskms.model.ResultMap;
import com.bskms.service.PageService;

/**
 * class name:PageServiceImpl <BR>
 * class description: please write your description <BR>
 * 
 * @version 1.0 Jan 27, 2019 10:23:18 AM
 * @author Aisino)Jack魏
 */
@Service
public class PageServiceImpl implements PageService {
	@Autowired
	private PageMapper pageMapper;
	/** logback日志记录 */
	private static final Logger logger = LoggerFactory.getLogger(PageServiceImpl.class);

	/**
	 * @Override
	 * @see com.aisino.arrms.service.PageService#getAllRolePage(java.lang.String)
	 *      <BR>
	 *      Method name: getAllRolePage <BR>
	 *      Description: 根据用户id,获取用户角色下所有的页面 <BR>
	 *      Remark: <BR>
	 * @param userId
	 * @return <BR>
	 */
	@Override
	@Transactional
	public List<Page> getAllPageByRoleId(Integer roleId) {
		try {
			return pageMapper.getAllPageByRoleId(roleId);
		} catch (Exception e) {
			logger.error("查询角色下所有页面异常", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return Collections.emptyList();
		}
	}

	/**
	 * @Override
	 * @see com.aisino.arrms.service.PageService#getAllPage() <BR>
	 *      Method name: getAllPage <BR>
	 *      Description: 获取所有页面 <BR>
	 *      Remark: <BR>
	 * @return <BR>
	 */
	@Override
	@Transactional
	public List<Page> getAllPage() {
		try {
			return pageMapper.getAllPage();
		} catch (Exception e) {
			logger.error("获取所有页面异常", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return Collections.emptyList();
		}
	}

	/**
	 * @Override
	 * @see com.aisino.arrms.service.PageService#updatePageById(com.aisino.arrms.bean.Page)
	 *      <BR>
	 *      Method name: updatePageById <BR>
	 *      Description: 根据页面id修改页面 <BR>
	 *      Remark: <BR>
	 * @param page
	 * @return <BR>
	 */
	@Override
	@Transactional
	public ResultMap updatePageById(Page page) {
		ResultMap map = new ResultMap();
		try {
			PageExample example = new PageExample();
			example.createCriteria().andPageIdEqualTo(page.getPageId());
			pageMapper.updateByExampleSelective(page, example);
			map.success().message("页面修改成功!");
		} catch (Exception e) {
			logger.error("页面修改异常", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			map.fail().message("页面修改失败");
		}

		return map;
	}

	/**
	 * @Override
	 * @see com.aisino.arrms.service.PageService#addPage(com.aisino.arrms.bean.Page)
	 *      <BR>
	 *      Method name: addPage <BR>
	 *      Description: 添加页面<BR>
	 *      Remark: <BR>
	 * @param page
	 * @return <BR>
	 */
	@Override
	public Page addPage(Page page) {
		ResultMap map = new ResultMap();
		try {
			pageMapper.insert(page);
			map.success().message("页面添加成功!");
		} catch (Exception e) {
			logger.error("页面添加异常", e);
			map.fail().message("页面添加失败");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return page;
	}

	/**
	 * @Override
	 * @see com.aisino.arrms.service.PageService#delPageById(java.lang.Integer) <BR>
	 *      Method name: delPageById <BR>
	 *      Description: 更加页面id删除页面 <BR>
	 *      Remark: <BR>
	 * @param id
	 * @return <BR>
	 */
	@Override
	public ResultMap delPageById(Integer id) {
		Page page = new Page();
		page.setDeleteFlag(1);
		PageExample example = new PageExample();
		example.createCriteria().andPageIdEqualTo(id);
		ResultMap map = new ResultMap();

		try {
			pageMapper.deleteByPrimaryKey(id);
			pageMapper.updateByExampleSelective(page, example);
			map.success().message("页面删除成功!");
		} catch (Exception e) {
			logger.error("页面删除异常", e);
			map.fail().message("页面删除失败");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return map;
	}

	/**
	 * @Override
	 * @see com.aisino.arrms.service.PageService#getAllRolePageByUserId(java.lang.String)
	 *      <BR>
	 *      Method name: getAllRolePageByUserId <BR>
	 *      Description: 根据用户id获取页面 <BR>
	 *      Remark: <BR>
	 * @param userId
	 * @return <BR>
	 */
	@Override
	public List<Page> getAllRolePageByUserId(String userId) {
		try {
			return pageMapper.getAllRolePageByUserId(userId);
		} catch (Exception e) {
			logger.error("根据用户id获取页面异常", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return Collections.emptyList();
		}
	}

}
