/**
 * 
 */
package com.bskms.service;

import com.bskms.bean.Foot;

/**
 * @author samsung
 *
 */
public interface FootService {

	Object getAllFootByLimit(Foot foot);

	Foot selectByPrimaryKey(Integer id);

	void addFoot(Foot foot);

	String updateFoot(Foot foot);

	void delFootById(Integer parseInt);

}
