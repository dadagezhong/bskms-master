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

import com.bskms.bean.ClaTea;
import com.bskms.bean.Classes;
import com.bskms.mapper.ClaTeaMapper;
import com.bskms.mapper.ClassesMapper;
import com.bskms.model.MMGridPageVoBean;
import com.bskms.service.TeaService;

/**
 * @author samsung
 *
 */
@Service
public class TeaServiceImpl implements TeaService{

	@Autowired
	private ClaTeaMapper teaMapper;
	
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
	public Object getAllTeaByLimit(ClaTea teaParameter) {
		int size = 0;

		Integer begin = (teaParameter.getPage() - 1) * teaParameter.getLimit();
		teaParameter.setPage(begin);

		List<ClaTea> rows = new ArrayList<>();
		try {
			rows = teaMapper.getAllTeaByLimit(teaParameter);
			size = teaMapper.countAllTeaByLimit(teaParameter);
		} catch (Exception e) {
			logger.error("根据查询班级 异常", e);
		}
		MMGridPageVoBean<ClaTea> vo = new MMGridPageVoBean<>();
		vo.setTotal(size);
		vo.setRows(rows);

		return vo;
	}

	@Override
	public ClaTea selectByPrimaryKey(Integer id) {
		return teaMapper.selectByPrimaryKey(id);
	}

	@Override
	public void addClaTea(ClaTea clatea) {
		try {
			teaMapper.insert(clatea);
			}catch (Exception e) {
				e.printStackTrace();
		}
	}

	@Override
	public String updateTea(ClaTea clatea) {
		try {
			teaMapper.updateByPrimaryKeySelective(clatea);
			return "SUCCESS";
		} catch (Exception e) {
			logger.error("根据教师id更新用户异常", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return "ERR";
		}
	}

	@Override
	public void delClaTeaById(int id) {
		try {
			teaMapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("删除用户出现异常", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		
	}


}
