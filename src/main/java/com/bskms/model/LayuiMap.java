/*
 * All rights Reserved, Copyright (C) Aisino LIMITED 2019
 * FileName: LayuiMap.java
 * Version:  1.0
 * Modify record:
 * NO. |     Date       |    Name        |      Content
 * 1   | 2019年2月1日        | Aisino)Jack    | original version
 */
package com.bskms.model;

import java.util.HashMap;

/**
 * class name: LayuiMap <BR>
 * class description: please write your description <BR>
 * 
 * @version 1.0 2019年2月1日 上午9:38:01
 * @author Aisino)weihaohao
 */
public class LayuiMap extends HashMap<String, Object> {

	/**
	 * define a field serialVersionUID which type is long
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Method name: success <BR>
	 * Description: 返回成功 <BR>
	 * 
	 * @return LayuiMap<BR>
	 */
	public LayuiMap success() {
		this.put("code", 0);
		this.put("src", "");
		return this;
	}

	/**
	 * Method name: fail <BR>
	 * Description: 返回失败 <BR>
	 * 
	 * @return LayuiMap<BR>
	 */
	public LayuiMap fail() {
		this.put("code", -1);
		return this;
	}

	/**
	 * Method name: message <BR>
	 * Description: 返回信息 <BR>
	 * 
	 * @param message
	 * @return LayuiMap<BR>
	 */
	public LayuiMap message(Object message) {
		this.put("message", message);
		return this;
	}

	public LayuiMap data(Object message) {
		this.put("data", message);
		return this;
	}

}
