/*
 * All rights Reserved, Copyright (C) Aisino LIMITED 2019
 * FileName: UserState.java
 * Version:  1.0
 * Modify record:
 * NO. |     Date       |    Name        |      Content
 * 1   | 2019年2月12日        | Aisino)Jack    | original version
 */
package com.bskms.common;

/**
 * class name: UserState <BR>
 * class description: please write your description <BR>
 * 
 * @version 1.0 2019年2月12日 下午2:47:54
 * @author Aisino)weihaohao
 */
public class GlobalState {
	/** 用户删除标志位=9 */
	public static final Integer USER_DELETE = 9;
	/** 用户在职标志位=9 */
	public static final Integer USER_ZAIZHI = 1;
	/** 用户离职标志位=9 */
	public static final Integer USER_LIZHI = 2;

	/** 项目删除标志位=9 */
	public static final Integer PROJECT_DELETE = 9;
	/** 项目完成标志位=1 */
	public static final Integer PROJECT_FINISH = 1;
	/** 项目未完成标志位=0 */
	public static final Integer PROJECT_NOT_FINISH = 0;
	/** 项目已发布标志位=2 */
	public static final Integer PROJECT_FABU = 2;
	/** 项目超时标志位=3 */
	public static final Integer PROJECT_CHAOSHI = 3;

	/** 需求删除标志位=9 */
	public static final Integer DEMAND_DELETE = 9;
	/** 需求发布标志位=0 */
	public static final Integer DEMAND_FABU = 0;
	/** 需求开发标志位=1 */
	public static final Integer DEMAND_KAIFA = 1;
	/** 需求完成标志位=2 */
	public static final Integer DEMAND_WANCHENG = 2;
	/** 需求超时标志位=3 */
	public static final Integer DEMAND_CHAOSHI = 3;

	/** 任务未领取标志位=0 */
	public static final Integer TASK_WEILINGQU = 0;
	/** 任务开发中标志位=1 */
	public static final Integer TASK_KAIFA = 1;
	/** 任务已完成标志位=2 */
	public static final Integer TASK_WANCHENG = 2;
	/** 任务超时标志位=3 */
	public static final Integer TASK_CHAOSHI = 3;
	/** 任务删除标志位=9 */
	public static final Integer TASK_DELETE = 9;

	/** 测试记录打开标志位=0 */
	public static final Integer ISSUE_OPEN = 0;
	/** 测试记录处理中标志位=1 */
	public static final Integer ISSUE_CHULI = 1;
	/** 测试记录待确认标志位=2 */
	public static final Integer ISSUE_JIEJUE = 2;
	/** 测试记录重新打开标志位=3 */
	public static final Integer ISSUE_REOPEN = 3;
	/** 测试记录已解决标志位=9 */
	public static final Integer ISSUE_CLOSE = 9;

	/** 测试记录漏洞标志位=1 */
	public static final Integer ISSUE_TYPE_BUG = 1;
	/** 测试记录新功能标志位=2 */
	public static final Integer ISSUE_TYPE_NEW = 2;
	/** 测试记录任务标志位=3 */
	public static final Integer ISSUE_TYPE_TASK = 3;
	/** 测试记录升级标志位=4 */
	public static final Integer ISSUE_TYPE_UP = 4;

	/** 测试记录未解决标志位=0 */
	public static final Integer ISSUE_HANDLER_TYPE_WJJ = 0;
	/** 测试记录已解决标志位=1 */
	public static final Integer ISSUE_HANDLER_TYPE_YJJ = 1;
	/** 测试记录无需解决标志位=2 */
	public static final Integer ISSUE_HANDLER_TYPE_WXJJ = 2;
	/** 测试记录重复标志位=3 */
	public static final Integer ISSUE_HANDLER_TYPE_CF = 3;
	/** 测试记录不清楚标志位=4 */
	public static final Integer ISSUE_HANDLER_TYPE_BQC = 4;
	/** 测试记录重现失败标志位=5 */
	public static final Integer ISSUE_HANDLER_TYPE_CXSB = 5;

	/** 管理员人员标志位=1 */
	public static final Integer ADMIN = 1;
	/** 开发人员标志位=2 */
	public static final Integer USER = 2;
	/** 需求管理员员标志位=3 */
	public static final Integer DM = 3;
	/** 系统管理员标志位=4 */
	public static final Integer SYSADMIN = 4;
	/** 测试人员标志位=5 */
	public static final Integer TEST = 5;
	/** 运维人员标志位=6 */
	public static final Integer OPS = 6;
}
