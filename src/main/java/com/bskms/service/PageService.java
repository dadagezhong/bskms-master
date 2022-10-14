/*
 * All rights Reserved, Copyright (C) Aisino LIMITED 2019
 * FileName: PageService.java
 * Version:  1.0
 * Modify record:
 * NO. |     Date       |    Name        |      Content
 * 1   | Jan 27, 2019        | Aisino)19604    | original version
 */
package com.bskms.service;

import java.util.List;

import com.bskms.bean.Page;
import com.bskms.model.ResultMap;

/**
 * class name:PageService <BR>
 * class description: 页面管理 <BR>
 * 
 * @version 1.0 Jan 27, 2019 10:22:01 AM
 * @author Aisino)Jack魏
 */
public interface PageService {
	public List<Page> getAllPageByRoleId(Integer roleId);

	public List<Page> getAllPage();

	public ResultMap updatePageById(Page page);

	public Page addPage(Page page);

	public ResultMap delPageById(Integer id);

	public List<Page> getAllRolePageByUserId(String userId);
}
