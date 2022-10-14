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

import com.bskms.bean.Notice;
import com.bskms.bean.Sign;
import com.bskms.mapper.SignMapper;
import com.bskms.model.MMGridPageVoBean;
import com.bskms.model.TongJi;
import com.bskms.service.SignService;

/**
 * @author samsung
 *
 */
@Service
public class SignServiceImpl implements SignService{
	@Autowired
	private SignMapper signMapper;
	
	private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public Object getAllSignByLimit(Sign signParameter) {
		int size = 0;

		Integer begin = (signParameter.getPage() - 1) * signParameter.getLimit();
		signParameter.setPage(begin);

		List<Sign> rows = new ArrayList<>();
		try {
			rows = signMapper.getAllSignByLimit(signParameter);
			size = signMapper.countAllSignByLimit(signParameter);
		} catch (Exception e) {
			logger.error("根据查询班级 异常", e);
		}
		MMGridPageVoBean<Sign> vo = new MMGridPageVoBean<>();
		vo.setTotal(size);
		vo.setRows(rows);

		return vo;
	}

	@Override
	public Sign selectByPrimaryKey(Integer id) {
		return signMapper.selectByPrimaryKey(id);
	}

	@Override
	public void addSign(Sign sign) {
		try {
			signMapper.insert(sign);
			}catch (Exception e) {
				e.printStackTrace();
		}
	}

	@Override
	public String updateSign(Sign sign) {
		try {
			signMapper.updateByPrimaryKeySelective(sign);
			return "SUCCESS";
		} catch (Exception e) {
			logger.error("根据用户id更新用户异常", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return "ERR";
		}
	}

	@Override
	public void delSignById(Integer parseInt) {
		try {
			signMapper.deleteByPrimaryKey(parseInt);
		} catch (Exception e) {
			logger.error("删除用户出现异常", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
	}

	@Override
	public Object getAllChildSignByLimit(Sign signParameter) {
		int size = 0;

		Integer begin = (signParameter.getPage() - 1) * signParameter.getLimit();
		signParameter.setPage(begin);

		List<Sign> rows = new ArrayList<>();
		try {
			rows = signMapper.getAllChildSignByLimit(signParameter);
			size = signMapper.countAllChildSignByLimit(signParameter);
		} catch (Exception e) {
			logger.error("根据查询班级 异常", e);
		}
		MMGridPageVoBean<Sign> vo = new MMGridPageVoBean<>();
		vo.setTotal(size);
		vo.setRows(rows);

		return vo;
	}

	@Override
	public List<TongJi> getAllTeacherCount() {
		return signMapper.getAllTeacherCount();
	}

	@Override
	public List<TongJi> getAllChildCount() {
		return signMapper.getAllChildCount();
	}
}
