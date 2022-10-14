/*
 * All rights Reserved, Copyright (C) Aisino LIMITED 2018
 * FileName: ImportExcel.java
 * Version:  $Revision$
 * Modify record:
 * NO. |     Date       |    Name         |      Content
 * 1   | 2018年12月21日        | Aisino)Jack    | original version
 */
package com.bskms.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * class name:ImportExcel <BR>
 * class 从Excel导入到数据库<BR>
 * Remark: <BR>
 * 
 * @version 1.00 2018年12月21日
 * @author Aisino)weihaohao
 */
public interface IExcel2DB {
	public String importUserExcel2DB(MultipartFile file);
	
}
