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

import com.bskms.bean.Foot;
import com.bskms.bean.Material;
import com.bskms.mapper.FootMapper;
import com.bskms.mapper.MaterialMapper;
import com.bskms.model.MMGridPageVoBean;
import com.bskms.service.FootService;

/**
 * @author samsung
 *
 */
@Service
public class FootServiceImpl implements FootService{
	@Autowired
	private FootMapper footMapper;
	
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
	public Object getAllFootByLimit(Foot foot) {
		int size = 0;

		Integer begin = (foot.getPage() - 1) * foot.getLimit();
		foot.setPage(begin);

		List<Foot> rows = new ArrayList<>();
		try {
			rows = footMapper.getAllFootByLimit(foot);
			size = footMapper.countAllFootByLimit(foot);
		} catch (Exception e) {
			logger.error("根据查询班级 异常", e);
		}
		MMGridPageVoBean<Foot> vo = new MMGridPageVoBean<>();
		vo.setTotal(size);
		vo.setRows(rows);

		return vo;
	}

	@Override
	public Foot selectByPrimaryKey(Integer id) {
		return footMapper.selectByPrimaryKey(id);
	}

	@Override
	public void addFoot(Foot foot) {
		try {
			footMapper.insert(foot);
			}catch (Exception e) {
				e.printStackTrace();
		}
	}

	@Override
	public String updateFoot(Foot foot) {
		try {
			footMapper.updateByPrimaryKeySelective(foot);
			return "SUCCESS";
		} catch (Exception e) {
			logger.error("根据用户id更新用户异常", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return "ERR";
		}
	}

	@Override
	public void delFootById(Integer id) {
		try {
			footMapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("删除用户出现异常", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
	}

}
