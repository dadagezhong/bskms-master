package com.bskms.mapper;

import com.bskms.bean.Foot;
import com.bskms.bean.FootExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FootMapper {
    long countByExample(FootExample example);

    int deleteByExample(FootExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Foot record);

    int insertSelective(Foot record);

    List<Foot> selectByExample(FootExample example);

    Foot selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Foot record, @Param("example") FootExample example);

    int updateByExample(@Param("record") Foot record, @Param("example") FootExample example);

    int updateByPrimaryKeySelective(Foot record);

    int updateByPrimaryKey(Foot record);

	List<Foot> getAllFootByLimit(Foot foot);

	int countAllFootByLimit(Foot foot);
	
	List<Foot> getNowFoot(@Param("s") String s, @Param("e") String e);
}