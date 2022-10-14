package com.bskms.service;
import java.util.List;
import com.bskms.bean.User;
import com.bskms.bean.UserChildren;
import com.bskms.model.ResultMap;
import com.bskms.model.UserParameter;

public interface UserService {
	User selectUserByUserId(String userId);

	public ResultMap login(String username, String password);

	public boolean checkUserPassword(String password);

	public String updatePassword(String password);

	Object getAllUserByRoleId(Integer roleId, Integer page, Integer limit);

	Object getAllUserByNotRoleId(Integer roleId, Integer page, Integer limit);

	User selectByPrimaryKey(String userId);

	List<User> getAdmins();

	Object getAllUserByLimit(UserParameter userParameter);

	void delUserById(String id);

	void addUser(User user) throws Exception;

	String updateUser(String oldId, User user);

	String updateUser(User user);

	List<User> getAllUser();

	User getAdminById(String userId);

	Object getAllDelUserByLimit(UserParameter userParameter);

	void recoverUser(String id);

	String getName(String issueReporter);

	List<User> selectAllTea();

	List<User> selectAllUser();

	List<User> selectAllJiazhang();
}
