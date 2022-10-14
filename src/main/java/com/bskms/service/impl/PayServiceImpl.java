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

import com.bskms.bean.Pay;

import com.bskms.mapper.PayMapper;
import com.bskms.model.MMGridPageVoBean;
import com.bskms.service.PayService;

/**
 * @author samsung
 *
 */
@Service
public class PayServiceImpl implements PayService{

	@Autowired
	private PayMapper payMapper;
	
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
	public Object getAllPayByLimit(Pay payParameter) {
		int size = 0;

		Integer begin = (payParameter.getPage() - 1) * payParameter.getLimit();
		payParameter.setPage(begin);
		
		if(payParameter.getMinDate()!=null && !payParameter.getMinDate().equals("")) {			
			payParameter.setMaxDate(payParameter.getMinDate()+"-31");
		}
		

		List<Pay> rows = new ArrayList<>();
		try {
			rows = payMapper.getAllPayByLimit(payParameter);
			size = payMapper.countAllPayByLimit(payParameter);
		} catch (Exception e) {
			logger.error("根据查询班级 异常", e);
		}
		MMGridPageVoBean<Pay> vo = new MMGridPageVoBean<>();
		vo.setTotal(size);
		vo.setRows(rows);

		return vo;
	}

	@Override
	public Pay selectByPrimaryKey(Integer id) {
		
		return payMapper.selectByPrimaryKey(id);
	}

	@Override
	public void addPayTea(Pay pay) {
		try {
			payMapper.insert(pay);
			}catch (Exception e) {
				e.printStackTrace();
		}
	}

	@Override
	public String updateTea(Pay pay) {
		try {
			payMapper.updateByPrimaryKeySelective(pay);
			return "SUCCESS";
		} catch (Exception e) {
			logger.error("根据用户id更新用户异常", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return "ERR";
		}
	}

	@Override
	public void delClaTeaById(Integer id) {
		try {
			payMapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("删除用户出现异常", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
	}

}
