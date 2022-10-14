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

import com.bskms.bean.Material;
import com.bskms.bean.Pay;
import com.bskms.mapper.MaterialMapper;
import com.bskms.mapper.PayMapper;
import com.bskms.model.MMGridPageVoBean;
import com.bskms.service.MaterialService;

/**
 * @author samsung
 *
 */
@Service
public class MaterialServiceImpl implements MaterialService{

	@Autowired
	private MaterialMapper materialMapper;
	
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
	public Object getAllMaterialByLimit(Material materialParameter) {
		int size = 0;

		Integer begin = (materialParameter.getPage() - 1) * materialParameter.getLimit();
		materialParameter.setPage(begin);

		List<Material> rows = new ArrayList<>();
		try {
			rows = materialMapper.getAllMaterialByLimit(materialParameter);
			size = materialMapper.countAllMaterialByLimit(materialParameter);
		} catch (Exception e) {
			logger.error("根据查询班级 异常", e);
		}
		MMGridPageVoBean<Material> vo = new MMGridPageVoBean<>();
		vo.setTotal(size);
		vo.setRows(rows);

		return vo;
	}

	@Override
	public Material selectByPrimaryKey(Integer id) {
		return materialMapper.selectByPrimaryKey(id);
	}

	@Override
	public void addMaterial(Material material) {
		try {
			materialMapper.insert(material);
			}catch (Exception e) {
				e.printStackTrace();
		}
	}

	@Override
	public String updateMaterial(Material material) {
		try {
			materialMapper.updateByPrimaryKeySelective(material);
			return "SUCCESS";
		} catch (Exception e) {
			logger.error("根据用户id更新用户异常", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return "ERR";
		}
	}

	@Override
	public void delMaterialById(Integer id) {
		try {
			materialMapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("删除用户出现异常", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
	}

}
