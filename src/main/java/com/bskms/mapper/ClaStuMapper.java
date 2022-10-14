package com.bskms.mapper;

import com.bskms.bean.ClaStu;
import com.bskms.bean.ClaStuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClaStuMapper {
    long countByExample(ClaStuExample example);

    int deleteByExample(ClaStuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClaStu record);

    int insertSelective(ClaStu record);

    List<ClaStu> selectByExample(ClaStuExample example);

    ClaStu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ClaStu record, @Param("example") ClaStuExample example);

    int updateByExample(@Param("record") ClaStu record, @Param("example") ClaStuExample example);

    int updateByPrimaryKeySelective(ClaStu record);

    int updateByPrimaryKey(ClaStu record);
}