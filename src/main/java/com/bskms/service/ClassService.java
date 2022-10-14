/**
 * 
 */
package com.bskms.service;

import java.util.List;

import com.bskms.bean.Classes;
import com.bskms.bean.User;

/**
 * @author samsung
 *
 */
public interface ClassService {

	Object getAllClassByLimit(Classes classParameter);

	Classes selectByPrimaryKey(Integer id);

	void addClasses(Classes classes);

	String updateClasses(Classes classes);

	void delClassesById(Integer i);

	List<Classes> selectAllClasses();

}
