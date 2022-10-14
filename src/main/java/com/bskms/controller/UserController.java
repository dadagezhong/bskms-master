/*
 * All rights Reserved, Copyright (C) Aisino LIMITED 2018
 * FileName: WebConfig.java
 * Version:  $Revision$
 * Modify record:
 * NO. |     Date       |    Name         |      Content
 * 1   | 2019年1月16日        | Aisino)Jack    | original version
 */
package com.bskms.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bskms.bean.User;
import com.bskms.bean.UserRole;
import com.bskms.model.Result;
import com.bskms.model.ResultMap;
import com.bskms.service.UserRoleService;
import com.bskms.service.UserService;
import com.bskms.utils.MyUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * class name:UserController <BR>
 * class description: 用户角色 <BR>
 * Remark: <BR>
 * 
 * @version 1.00 2019年1月16日
 * @author Aisino)weihaohao
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
@Controller
@RequestMapping("/user")
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	private final ResultMap resultMap;
	@Autowired
	private UserService userService;

	@Autowired
	private UserRoleService userRoleService;

	@Autowired
	public UserController(ResultMap resultMap) {
		this.resultMap = resultMap;
	}

	@RequestMapping(value = "/getMessage", method = RequestMethod.GET)
	public ResultMap getMessage() {
		return resultMap.success().message("您拥有用户权限，可以获得该接口的信息！");
	}

	@RequestMapping(value = "/editUserPage")
	public String editUserPage(String userId, Model model) {
		model.addAttribute("manageUser", userId);
		if (null != userId) {
			User user = userService.selectByPrimaryKey(userId);
			model.addAttribute("manageUser", user);
		}
		return "user/userEdit";
	}

	@ResponseBody
	@RequestMapping("/updateUser")
	public String updateUser(User user) {
		return userService.updateUser(user);
	}

	// 任务

	/**
	 * Description: 查询所有管理员 <BR>
	 * 
	 * @return List<Project>
	 */
	@ResponseBody
	@RequestMapping(value = "/getAdmins")
	public List<User> getAdmins() {
		return userService.getAdmins();
	}

	/**
	 * Description: 查询所有授权用户<BR>
	 * 
	 * @return List<User>
	 */
	@ResponseBody
	@RequestMapping(value = "/getAllUser")
	public List<User> getAllUser() {
		return userService.getAllUser();
	}
}
