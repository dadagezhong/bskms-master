package com.bskms.service;

import java.util.List;

import com.bskms.bean.Course;

public interface CourseService {
	public List<Course> getAllCourse();
	public Object getAllCourseByLimit(Course course);
	public void addCourse(Course course);
	public void delCourse(Integer id);
}
