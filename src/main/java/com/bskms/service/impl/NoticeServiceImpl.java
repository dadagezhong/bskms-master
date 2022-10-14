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
import com.bskms.bean.Notice;
import com.bskms.bean.NoticeExample;
import com.bskms.mapper.NoticeMapper;
import com.bskms.model.MMGridPageVoBean;
import com.bskms.service.NoticeService;

/**
 * @author samsung
 *
 */
@Service
public class NoticeServiceImpl implements NoticeService{
	@Autowired
	private NoticeMapper noticeMapper;
	
	private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Override
	public Object getAllNoticeByLimit(Notice noticeParameter) {
		int size = 0;

		Integer begin = (noticeParameter.getPage() - 1) * noticeParameter.getLimit();
		noticeParameter.setPage(begin);

		List<Notice> rows = new ArrayList<>();
		try {
			rows = noticeMapper.getAllNoticeByLimit(noticeParameter);
			size = noticeMapper.countAllNoticeByLimit(noticeParameter);
		} catch (Exception e) {
			logger.error("根据查询班级 异常", e);
		}
		MMGridPageVoBean<Notice> vo = new MMGridPageVoBean<>();
		vo.setTotal(size);
		vo.setRows(rows);

		return vo;
	}

	@Override
	public Notice selectByPrimaryKey(Integer id) {
		return noticeMapper.selectByPrimaryKey(id);
	}

	@Override
	public void addNotice(Notice notice) {
		try {
			noticeMapper.insert(notice);
			}catch (Exception e) {
				e.printStackTrace();
		}
	}

	@Override
	public String updateStu(Notice notice) {
		try {
			noticeMapper.updateByPrimaryKeySelective(notice);
			return "SUCCESS";
		} catch (Exception e) {
			logger.error("根据用户id更新用户异常", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return "ERR";
		}
	}

	@Override
	public void delNoticeById(Integer parseInt) {
		try {
			noticeMapper.deleteByPrimaryKey(parseInt);
		} catch (Exception e) {
			logger.error("删除用户出现异常", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
	}

	@Override
	public List<Notice> getAllNotice() {
		NoticeExample example = new NoticeExample();
		example.createCriteria().andTitleIsNotNull();
		return noticeMapper.selectByExample(example);
	}

}
