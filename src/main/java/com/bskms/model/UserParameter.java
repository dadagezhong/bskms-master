/*
 * All rights Reserved, Copyright (C) Aisino LIMITED 2019
 * FileName: UserParameter.java
 * Version:  1.0
 * Modify record:
 * NO. |     Date       |    Name        |      Content
 * 1   | 2019年1月31日        | Aisino)Jack    | original version
 */
package com.bskms.model;

import com.bskms.bean.BaseBean;

/**
 * class name: UserParameter <BR>
 * class description: please write your description <BR>
 * 
 * @version 1.0 2019年1月31日 下午1:14:53
 * @author Aisino)weihaohao
 */
public class UserParameter extends BaseBean {
	/**
	 * define a field serialVersionUID which type is long
	 */
	private static final long serialVersionUID = 1L;
	private String userId;
	private String userName;
	private Integer userSex;
	private String position;
	private String dept;
	private Integer userState;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserSex() {
		return userSex;
	}

	public void setUserSex(Integer userSex) {
		this.userSex = userSex;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Integer getUserState() {
		return userState;
	}

	public void setUserState(Integer userState) {
		this.userState = userState;
	}
}
