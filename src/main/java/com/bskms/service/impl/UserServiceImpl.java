package com.bskms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.bskms.bean.User;
import com.bskms.bean.UserChildren;
import com.bskms.bean.UserExample;
import com.bskms.bean.UserRole;
import com.bskms.bean.UserRoleExample;
import com.bskms.common.GlobalState;
import com.bskms.mapper.UserMapper;
import com.bskms.mapper.UserRoleMapper;
import com.bskms.model.MMGridPageVoBean;
import com.bskms.model.ResultMap;
import com.bskms.model.UserParameter;
import com.bskms.service.UserService;
import com.bskms.utils.MD5;

/**
 * @author zwg
 * @version 创建时间：2019年1月25日 上午10:47:54
 * @ClassName UserServiceImpl
 * @Description 类描述
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private ResultMap resultMap;
	@Autowired
	private UserRoleMapper userRoleMapper;
	private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	/**
	 * @Override
	 * @see com.aisino.arrms.service.Login#login(java.lang.String, java.lang.String)
	 *      <BR>
	 *      Method name: login <BR>
	 *      Description: 登录server <BR>
	 *      Remark: <BR>
	 * @param username 用户名
	 * @param password 密码
	 * @return <BR>
	 */
	@Override
	public ResultMap login(String username, String password) {
		// 从SecurityUtils里边创建一个 subject
		Subject subject = SecurityUtils.getSubject();
		// 在认证提交前准备 token（令牌）
		UsernamePasswordToken token = new UsernamePasswordToken(username, MD5.md5(password));
		// 执行认证登陆
		try {			
			subject.login(token);
		}catch (Exception e) {
			return resultMap.fail().message(e.getMessage());
		}
		// 根据权限，指定返回数据
		List<String> role = userRoleMapper.getRoles(username);
		if (!role.isEmpty()) {
			logger.info("欢迎登录------您的权限是{}", role);
			return resultMap.success().message("欢迎登陆");
		}
		return resultMap.fail().message("权限错误！");
	}

	/**
	 * @Override
	 * @see com.aisino.arrms.service.Login#checkUserPassword(java.lang.String) <BR>
	 *      Method name: checkUserPassword <BR>
	 *      Description: 检测用户旧密码是否正确 <BR>
	 *      Remark: <BR>
	 * @param password
	 * @return <BR>
	 */
	@Override
	public boolean checkUserPassword(String password) {
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		// 防止session失效报错
		if (null != user) {
			String pass = user.getUserPassword();
			if (pass != null && pass.equals(MD5.md5(password))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @Override
	 * @see com.aisino.arrms.service.Login#updatePassword(java.lang.String) <BR>
	 *      Method name: updatePassword <BR>
	 *      Description: 修改密码 <BR>
	 *      Remark: <BR>
	 * @param password
	 * @return <BR>
	 */
	@Override
	@Transactional // 事物注解
	public String updatePassword(String password) {
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		int n = 0;
		// 防止session失效报错
		if (null != user) {
			User upUser = new User();
			upUser.setUserPassword(MD5.md5(password));
			UserExample userExample = new UserExample();
			try {
				userExample.createCriteria().andUserIdEqualTo(user.getUserId());
				n = userMapper.updateByExampleSelective(upUser, userExample);
			} catch (Exception e) {
				logger.error("修改密码异常", e);
				// 事物回滚
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return "ERROR";
			}
		}
		if (n != 0) {
			return "SUCCESS";
		}
		return "ERROR";
	}

	/**
	 * @Override
	 * @see com.aisino.arrms.service.UserService#selectUserByUserId(java.lang.String)
	 *      <BR>
	 *      Method name: selectUserByUserId <BR>
	 *      Description: 根据用户id查询用户信息 <BR>
	 *      Remark: <BR>
	 * @param userId
	 * @return <BR>
	 */
	@Override
	public User selectUserByUserId(String userId) {
		try {
			return userMapper.selectByPrimaryKey(userId);
		} catch (Exception e) {
			logger.error("根据用户id查询用户信息异常", e);
			return null;
		}
	}

	/**
	 * @Override
	 * @see com.aisino.arrms.service.UserService#getAllUserByRoleId(java.lang.String)
	 *      <BR>
	 *      Method name: getAllUserByRoleId <BR>
	 *      Description: 根据权限id获取权限下所有用户 <BR>
	 *      Remark: <BR>
	 * @param roleId
	 * @return <BR>
	 */
	@Override
	public Object getAllUserByRoleId(Integer roleId, Integer page, Integer limit) {
		int size = userMapper.countAllUserByRoleId(roleId);

		Integer begin = (page - 1) * limit;
		Integer count = limit;

		List<User> rows = new ArrayList<>();
		try {
			rows = userMapper.getAllUserByRoleId(roleId, begin, count);
		} catch (Exception e) {
			logger.error("根据权限id获取权限下所有用户异常", e);
		}

		MMGridPageVoBean<User> vo = new MMGridPageVoBean<>();
		vo.setTotal(size);
		vo.setRows(rows);

		return vo;
	}

	/**
	 * @Override
	 * @see com.aisino.arrms.service.UserService#getAllUserByNotRoleId(java.lang.Integer)
	 *      <BR>
	 *      Method name: getAllUserByNotRoleId <BR>
	 *      Description: 根据权限id获取不是这个权限所有用户 <BR>
	 *      Remark: <BR>
	 * @param roleId
	 * @return <BR>
	 */
	@Override
	public Object getAllUserByNotRoleId(Integer roleId, Integer page, Integer limit) {
		int size = userMapper.countAllUserByNotRoleId(roleId);

		Integer begin = (page - 1) * limit;
		Integer count = limit;

		List<User> rows = new ArrayList<>();
		try {
			rows = userMapper.getAllUserByNotRoleId(roleId, begin, count);
		} catch (Exception e) {
			logger.error("根据权限id获取不是这个权限所有用户异常", e);
		}

		MMGridPageVoBean<User> vo = new MMGridPageVoBean<>();
		vo.setTotal(size);
		vo.setRows(rows);

		return vo;
	}

	/**
	 * @Override
	 * @see com.aisino.arrms.service.UserService#selectByPrimaryKey(java.lang.String)
	 *      <BR>
	 *      Method name: selectByPrimaryKey <BR>
	 *      Description: 根据用户id查看用户是否存在 <BR>
	 *      Remark: <BR>
	 * @param userId
	 * @return <BR>
	 */
	@Override
	public User selectByPrimaryKey(String userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	@Override
	public List<User> getAdmins() {
		List<User> list = new ArrayList<User>();
		UserRoleExample example = new UserRoleExample();
		example.createCriteria().andRoleIdEqualTo(1);
		List<UserRole> userRoles = userRoleMapper.selectByExample(example);
		for (UserRole userRole : userRoles) {
			User user = userMapper.selectByPrimaryKey(userRole.getUserId());
			if (user.getUserState() != GlobalState.USER_DELETE) {
				list.add(user);
			}
		}
		return list;
	}

	/**
	 * @Override
	 * @see com.aisino.arrms.service.UserService#getAllUserByLimit(com.aisino.arrms.model.UserParameter)
	 *      <BR>
	 *      Method name: getAllUserByLimit <BR>
	 *      Description: 根据条件查询用户 <BR>
	 *      Remark: <BR>
	 * @param userParameter
	 * @return <BR>
	 */
	@Override
	public Object getAllUserByLimit(UserParameter userParameter) {
		int size = 0;

		Integer begin = (userParameter.getPage() - 1) * userParameter.getLimit();
		userParameter.setPage(begin);

		List<User> rows = new ArrayList<>();
		try {
			rows = userMapper.getAllUserByLimit(userParameter);
			size = userMapper.countAllUserByLimit(userParameter);
		} catch (Exception e) {
			logger.error("根据条件查询用户 异常", e);
		}
		MMGridPageVoBean<User> vo = new MMGridPageVoBean<>();
		vo.setTotal(size);
		vo.setRows(rows);

		return vo;
	}

	/**
	 * @Override
	 * @see com.aisino.arrms.service.UserService#delUserById(java.lang.String) <BR>
	 *      Method name: delUserById <BR>
	 *      Description: 删除用户,并删除用户权限表 <BR>
	 *      Remark: <BR>
	 * @param id <BR>
	 */
	@Override
	@Transactional
	public void delUserById(String id) {
		try {
			// 改变用户状态位为删除
			User user = new User();
			user.setUserState(GlobalState.USER_DELETE);// 删除用户标志位
			UserExample userExample = new UserExample();
			userExample.createCriteria().andUserIdEqualTo(id);

			// 删除用户角色表
			UserRoleExample userRoleExample = new UserRoleExample();
			userRoleExample.createCriteria().andUserIdEqualTo(id);
			userMapper.updateByExampleSelective(user, userExample);// 更改用户状态
			userRoleMapper.deleteByExample(userRoleExample);// 删除用户权限表
		} catch (Exception e) {
			logger.error("删除用户出现异常", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
	}

	/**
	 * @Override
	 * @see com.aisino.arrms.service.UserService#addUser(com.aisino.arrms.bean.User)
	 *      <BR>
	 *      Method name: addUser <BR>
	 *      Description: 增加单个用户,抛出异常 <BR>
	 *      Remark: <BR>
	 * @param user
	 * @throws Exception <BR>
	 */
	@Override
	public void addUser(User user) throws Exception {
		userMapper.insert(user);
	}

	/**
	 * @Override
	 * @see com.aisino.arrms.service.UserService#updateUser(com.aisino.arrms.bean.User)
	 *      <BR>
	 *      Method name: updateUser <BR>
	 *      Description: 根据用户id更新用户 <BR>
	 *      Remark: <BR>
	 * @param user
	 * @return <BR>
	 */
	@Override
	@Transactional
	public String updateUser(User user) {
		try {
			String pass = user.getUserPassword();
			if (pass != null && !pass.equals("")) {
				user.setUserPassword(MD5.md5(pass));
			}
			userMapper.updateByPrimaryKeySelective(user);
			return "SUCCESS";
		} catch (Exception e) {
			logger.error("根据用户id更新用户异常", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return "ERR";
		}
	}

	@Override
	public List<User> getAllUser() {
		List<User> list = new ArrayList<User>();
		UserRoleExample example = new UserRoleExample();
		example.createCriteria().andRoleIdNotEqualTo(4);
		List<UserRole> userRoles = userRoleMapper.selectByExample(example);
		for (UserRole userRole : userRoles) {
			User user = userMapper.selectByPrimaryKey(userRole.getUserId());
			if (user.getUserState() != GlobalState.USER_DELETE) {
				list.add(user);
			}
		}
		return list;
	}

	/**
	 * Description: 根据id获取管理员 <BR>
	 * 
	 * @param userId
	 * @return
	 */
	@Override
	public User getAdminById(String userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	@Override
	public Object getAllDelUserByLimit(UserParameter userParameter) {
		int size = 0;

		Integer begin = (userParameter.getPage() - 1) * userParameter.getLimit();
		userParameter.setPage(begin);

		List<User> rows = new ArrayList<>();
		try {
			rows = userMapper.getAllDelUserByLimit(userParameter);
			size = userMapper.countAllDelUserByLimit(userParameter);
		} catch (Exception e) {
			logger.error("根据条件查询用户 异常", e);
		}
		MMGridPageVoBean<User> vo = new MMGridPageVoBean<>();
		vo.setTotal(size);
		vo.setRows(rows);

		return vo;
	}

	@Override
	public void recoverUser(String id) {
		UserExample example = new UserExample();
		example.createCriteria().andUserIdEqualTo(id);

		User user = new User();
		user.setUserState(GlobalState.USER_ZAIZHI);
		try {
			userMapper.updateByExampleSelective(user, example);
		} catch (Exception e) {
			logger.error("恢复用户状态 异常", e);
		}
	}

	/**
	 * @Override
	 * @see com.aisino.arrms.service.UserService#updateUser(java.lang.String,
	 *      com.aisino.arrms.bean.User) <BR>
	 *      Method name: updateUser <BR>
	 *      Description: 根据旧用户id更改用户信息 <BR>
	 *      Remark: <BR>
	 * @param oldId
	 * @param user
	 * @return <BR>
	 */
	@Override
	public String updateUser(String oldId, User user) {
		UserExample example = new UserExample();
		example.createCriteria().andUserIdEqualTo(oldId);
		try {
			String pass = user.getUserPassword();
			boolean xgpass = false;
			User oldUser = userMapper.selectByPrimaryKey(oldId);
			if (pass != null && !pass.equals("")) {
				user.setUserPassword(MD5.md5(pass));
				xgpass = true;
			} else {
				user.setUserPassword(oldUser.getUserPassword());
			}
			user.setAccountCreateTime(oldUser.getAccountCreateTime());

			// 更新用户权限表
			UserRoleExample userRoleExample = new UserRoleExample();
			userRoleExample.createCriteria().andUserIdEqualTo(oldId);
			List<UserRole> olds = userRoleMapper.selectByExample(userRoleExample);
			for (UserRole userRole : olds) {
				userRole.setUserId(user.getUserId());
				userRoleMapper.updateByExampleSelective(userRole, userRoleExample);
			}
			userMapper.updateByExample(user, example);

			// 系统管理员自己修改自己
			Subject subject = SecurityUtils.getSubject();
			User ad = (User) subject.getPrincipal();
			// 修改自己账号要重新登录
			// 修改自己密码要重新登录
			//
			if (!oldId.equals(user.getUserId()) && oldId.equals(ad.getUserId())) {
				return "LGINOUT";
			} else if (oldId.equals(ad.getUserId()) && xgpass) {
				return "LGINOUT";
			}
			return "SUCCESS";
		} catch (Exception e) {
			logger.error("根据用户id更新用户异常", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return "ERR";
		}
	}

	@Override
	public String getName(String userId) {
		return userMapper.getName(userId);
	}

	@Override
	public List<User> selectAllTea() {
		
		return userMapper.selectAllTea();
	}

	@Override
	public List<User> selectAllUser() {
		
		return userMapper.selectAllUser();
	}

	@Override
	public List<User> selectAllJiazhang() {
		
		return userMapper.selectAllJiazhang();
	}


}
