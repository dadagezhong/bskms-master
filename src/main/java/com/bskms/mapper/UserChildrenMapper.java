package com.bskms.mapper;

import com.bskms.bean.UserChildren;
import com.bskms.bean.UserChildrenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserChildrenMapper {
    long countByExample(UserChildrenExample example);

    int deleteByExample(UserChildrenExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserChildren record);

    int insertSelective(UserChildren record);

    List<UserChildren> selectByExample(UserChildrenExample example);

    UserChildren selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserChildren record, @Param("example") UserChildrenExample example);

    int updateByExample(@Param("record") UserChildren record, @Param("example") UserChildrenExample example);

    int updateByPrimaryKeySelective(UserChildren record);

    int updateByPrimaryKey(UserChildren record);

	List<UserChildren> selectAllJiazhang();

	UserChildren selectById(Integer id);
	
	UserChildren selectByUCId(Integer id);
}