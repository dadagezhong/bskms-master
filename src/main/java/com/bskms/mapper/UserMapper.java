package com.bskms.mapper;

import com.bskms.model.UserParameter;
import com.bskms.bean.User;
import com.bskms.bean.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    int countAllUserByRoleId(Integer roleId);
    
    List<User> getAllUserByRoleId(Integer roleId, Integer begin, Integer count);

	int countAllUserByNotRoleId(Integer roleId);

	List<User> getAllUserByNotRoleId(Integer roleId, Integer begin, Integer count);

	List<User> getAllUserByLimit(UserParameter userParameter);

	int countAllUserByLimit(UserParameter userParameter);

	List<User> getAllDelUserByLimit(UserParameter userParameter);

	int countAllDelUserByLimit(UserParameter userParameter);

	String getName(@Param("userId") String userId);

	List<User> selectAllTea();

	List<User> selectAllUser();

	User getBZR(@Param("classId") Integer classId);

	List<User> selectAllJiazhang();
}