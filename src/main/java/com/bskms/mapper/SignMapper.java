package com.bskms.mapper;

import com.bskms.bean.Sign;
import com.bskms.bean.SignExample;
import com.bskms.model.TongJi;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SignMapper {
    long countByExample(SignExample example);

    int deleteByExample(SignExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Sign record);

    int insertSelective(Sign record);

    List<Sign> selectByExample(SignExample example);

    Sign selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Sign record, @Param("example") SignExample example);

    int updateByExample(@Param("record") Sign record, @Param("example") SignExample example);

    int updateByPrimaryKeySelective(Sign record);

    int updateByPrimaryKey(Sign record);

	List<Sign> getAllSignByLimit(Sign signParameter);

	int countAllSignByLimit(Sign signParameter);

	List<Sign> getSign(@Param("type") int type, @Param("cid") String cid);


	List<Sign> getAllChildSignByLimit(Sign signParameter);

	int countAllChildSignByLimit(Sign signParameter);

	List<TongJi> getAllTeacherCount();

	List<TongJi> getAllChildCount();
}