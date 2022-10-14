/**
 * 
 */
package com.bskms.service;

import org.springframework.stereotype.Service;

import com.bskms.bean.ClaTea;

/**
 * @author samsung
 *
 */

public interface TeaService {

	Object getAllTeaByLimit(ClaTea teaParameter);

	ClaTea selectByPrimaryKey(Integer id);

	void addClaTea(ClaTea clatea);

	String updateTea(ClaTea clatea);

	void delClaTeaById(int parseInt);

}
