/**
 * 
 */
package com.bskms.service;

import com.bskms.bean.Children;

/**
 * @author samsung
 *
 */
public interface StudentService {

	Object getAllStudentByLimit(Children stuParameter);

	Children selectByPrimaryKey(Integer id);

	void addStudent(Children student);

	String updateStu(Children studnet);

	void delStudentById(Integer parseInt);

}
