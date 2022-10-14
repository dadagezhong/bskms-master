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
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.bskms.bean.Children;
import com.bskms.bean.Classes;
import com.bskms.mapper.ChildrenMapper;
import com.bskms.mapper.ClassesMapper;
import com.bskms.model.MMGridPageVoBean;
import com.bskms.service.StudentService;

/**
 * @author samsung
 *
 */
@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private ChildrenMapper childrenMapper;

	private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Override
	public Object getAllStudentByLimit(Children stuParameter) {
		int size = 0;

		Integer begin = (stuParameter.getPage() - 1) * stuParameter.getLimit();
		stuParameter.setPage(begin);

		List<Children> rows = new ArrayList<>();
		try {
			rows = childrenMapper.getAllStudentByLimit(stuParameter);
			size = childrenMapper.countAllStudentByLimit(stuParameter);
		} catch (Exception e) {
			logger.error("根据查询班级 异常", e);
		}
		MMGridPageVoBean<Children> vo = new MMGridPageVoBean<>();
		vo.setTotal(size);
		vo.setRows(rows);

		return vo;
	}

	@Override
	public Children selectByPrimaryKey(Integer id) {

		return childrenMapper.selectByPrimaryKey(id);
	}

	@Override
	public void addStudent(Children student) {
		try {
			childrenMapper.insert(student);
			}catch (Exception e) {
				e.printStackTrace();
		}
	}

	@Override
	public String updateStu(Children studnet) {
		try {
			childrenMapper.updateByPrimaryKeySelective(studnet);
			return "SUCCESS";
		} catch (Exception e) {
			logger.error("根据用户id更新用户异常", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return "ERR";
		}
	}

	@Override
	public void delStudentById(Integer id) {
		try {
			childrenMapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("删除用户出现异常", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		
	}

}
