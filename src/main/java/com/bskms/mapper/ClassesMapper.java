package com.bskms.mapper;

import com.bskms.bean.Classes;
import com.bskms.bean.ClassesExample;
import com.bskms.bean.User;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassesMapper {
    long countByExample(ClassesExample example);

    int deleteByExample(ClassesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Classes record);

    int insertSelective(Classes record);

    List<Classes> selectByExample(ClassesExample example);

    Classes selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Classes record, @Param("example") ClassesExample example);

    int updateByExample(@Param("record") Classes record, @Param("example") ClassesExample example);

    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKey(Classes record);

	List<Classes> getAllClassByLimit(Classes classParameter);

	int countAllClassByLimit(Classes classParameter);

	List<Classes> selectAllClasses();

}