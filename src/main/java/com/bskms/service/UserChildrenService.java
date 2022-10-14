/**
 * 
 */
package com.bskms.service;

import java.util.List;

import com.bskms.bean.UserChildren;

/**
 * @author samsung
 *
 */
public interface UserChildrenService {

	void addUserChildren(UserChildren userChildern);

	UserChildren selectByPrimaryKey(Integer id);

	List<UserChildren> selectAllJiazhang();

	UserChildren selectById(Integer id);

	UserChildren selectByUCId(Integer childrenId);

	void updateUC(UserChildren uc);

}
