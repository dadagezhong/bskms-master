package com.bskms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bskms.bean.ClaTea;
import com.bskms.bean.Course;
import com.bskms.mapper.CourseMapper;
import com.bskms.model.MMGridPageVoBean;
import com.bskms.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	CourseMapper courseMapper;

	@Override
	public List<Course> getAllCourse() {
		return courseMapper.getAllCourse();
	}

	@Override
	public Object getAllCourseByLimit(Course course) {
		int size = 0;

		Integer begin = (course.getPage() - 1) * course.getLimit();
		course.setPage(begin);

		List<ClaTea> rows = new ArrayList<>();
		try {
			rows = courseMapper.getAllCourseByLimit(course);
			size = courseMapper.getAllCourseByLimitCout(course);
		} catch (Exception e) {
			e.printStackTrace();
		}
		MMGridPageVoBean<ClaTea> vo = new MMGridPageVoBean<>();
		vo.setTotal(size);
		vo.setRows(rows);

		return vo;
	}

	@Override
	public void addCourse(Course course) {
		courseMapper.insert(course);
	}

	@Override
	public void delCourse(Integer id) {
		courseMapper.deleteByPrimaryKey(id);
	}
	
}
