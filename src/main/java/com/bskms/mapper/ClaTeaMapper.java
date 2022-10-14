
package com.bskms.mapper;

import com.bskms.bean.ClaTea;
import com.bskms.bean.ClaTeaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClaTeaMapper {
    long countByExample(ClaTeaExample example);

    int deleteByExample(ClaTeaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClaTea record);

    int insertSelective(ClaTea record);

    List<ClaTea> selectByExample(ClaTeaExample example);

    ClaTea selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ClaTea record, @Param("example") ClaTeaExample example);

    int updateByExample(@Param("record") ClaTea record, @Param("example") ClaTeaExample example);

    int updateByPrimaryKeySelective(ClaTea record);

    int updateByPrimaryKey(ClaTea record);

	List<ClaTea> getAllTeaByLimit(ClaTea teaParameter);

	int countAllTeaByLimit(ClaTea teaParameter);

}