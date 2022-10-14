/**
 * 
 */
package com.bskms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.bskms.bean.Classes;
import com.bskms.bean.User;
import com.bskms.bean.UserExample;
import com.bskms.bean.UserRoleExample;
import com.bskms.common.GlobalState;
import com.bskms.mapper.ClassesMapper;
import com.bskms.mapper.UserMapper;
import com.bskms.mapper.UserRoleMapper;
import com.bskms.model.MMGridPageVoBean;
import com.bskms.model.ResultMap;
import com.bskms.service.ClassService;
import com.bskms.utils.MD5;

/**
 * @author zjl
 *
 */
@Service
public class ClassServiceImpl implements ClassService{
	
	@Autowired
	private ClassesMapper classesMapper;
	
	private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	/**
	 * @Override
	 * @see com.aisino.arrms.service.UserService#getAllUserByLimit(com.aisino.arrms.model.UserParameter)
	 *      <BR>
	 *      Method name: getAllClassByLimit <BR>
	 *      Description: 根据条件查询班级 <BR>
	 *      Remark: <BR>
	 * @param userParameter
	 * @return <BR>
	 */
	@Override
	public Object getAllClassByLimit(Classes classParameter) {
		int size = 0;

		Integer begin = (classParameter.getPage() - 1) * classParameter.getLimit();
		classParameter.setPage(begin);

		List<Classes> rows = new ArrayList<>();
		try {
			rows = classesMapper.getAllClassByLimit(classParameter);
			size = classesMapper.countAllClassByLimit(classParameter);
		} catch (Exception e) {
			logger.error("根据查询班级 异常", e);
		}
		MMGridPageVoBean<Classes> vo = new MMGridPageVoBean<>();
		vo.setTotal(size);
		vo.setRows(rows);

		return vo;
	}

	@Override
	public Classes selectByPrimaryKey(Integer id) {
		
		return classesMapper.selectByPrimaryKey(id);
	}

	@Override
	public void addClasses(Classes classes) {
		try {
		classesMapper.insert(classes);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String updateClasses(Classes classes) {
		try {
			classesMapper.updateByPrimaryKeySelective(classes);
			return "SUCCESS";
		} catch (Exception e) {
			logger.error("根据用户id更新用户异常", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return "ERR";
		}
	}

	@Override
	@Transactional
	public void delClassesById(Integer id) {
		try {
			classesMapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("删除用户出现异常", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		
	}

	@Override
	public List<Classes> selectAllClasses() {
		
		return classesMapper.selectAllClasses();
	}


}
