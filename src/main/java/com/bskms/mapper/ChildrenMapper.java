package com.bskms.mapper;

import com.bskms.bean.Children;
import com.bskms.bean.ChildrenExample;
import com.bskms.bean.Classes;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChildrenMapper {
    long countByExample(ChildrenExample example);

    int deleteByExample(ChildrenExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Children record);

    int insertSelective(Children record);

    List<Children> selectByExample(ChildrenExample example);

    Children selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Children record, @Param("example") ChildrenExample example);

    int updateByExample(@Param("record") Children record, @Param("example") ChildrenExample example);

    int updateByPrimaryKeySelective(Children record);

    int updateByPrimaryKey(Children record);

	List<Children> getAllStudentByLimit(Children stuParameter);

	int countAllStudentByLimit(Children stuParameter);

	List<Children> getChildrens(@Param("uId") String userId);
}