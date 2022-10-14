package com.bskms.mapper;

import com.bskms.bean.ClaTea;
import com.bskms.bean.Course;
import com.bskms.bean.CourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseMapper {
    long countByExample(CourseExample example);

    int deleteByExample(CourseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Course record);

    int insertSelective(Course record);

    List<Course> selectByExample(CourseExample example);

    Course selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByExample(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

	Course getNowCourse(@Param("classId")Integer classId, @Param("s")String s, @Param("d")String d);

	List<Course> getAllCourse();

	List<ClaTea> getAllCourseByLimit(Course course);

	int getAllCourseByLimitCout(Course course);
}