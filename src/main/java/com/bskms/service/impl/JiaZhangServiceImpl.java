
package com.bskms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bskms.bean.Children;
import com.bskms.bean.ChildrenExample;
import com.bskms.bean.Classes;
import com.bskms.bean.Course;
import com.bskms.bean.Foot;
import com.bskms.bean.Sign;
import com.bskms.bean.User;
import com.bskms.bean.UserExample;
import com.bskms.mapper.ChildrenMapper;
import com.bskms.mapper.ClassesMapper;
import com.bskms.mapper.CourseMapper;
import com.bskms.mapper.FootMapper;
import com.bskms.mapper.SignMapper;
import com.bskms.mapper.UserMapper;
import com.bskms.service.JiaZhangService;
import com.bskms.utils.MyUtils;

@Service
public class JiaZhangServiceImpl implements JiaZhangService {
	@Autowired
	UserMapper userMapper;
	@Autowired
	ChildrenMapper childrenMapper;
	@Autowired
	FootMapper footMapper;
	@Autowired
	CourseMapper courseMapper;
	@Autowired
	SignMapper signMapper;
	@Autowired
	ClassesMapper classMapper;
	
	@Override
	public User getGR(String userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	@Override
	public Foot getFoot() {
		String d = MyUtils.getNowDateYMD();
		List<Foot> foots = footMapper.getNowFoot(d+" 00:00:00", d+" 23:59:59");
		if(foots.size()==0) {
			return null;
		}
		return foots.get(0);
	}

	@Override
	public List<Children> getChildren(String userId) {
		List<Children> cs = childrenMapper.getChildrens(userId);
		
		return cs;
	}

	@Override
	public Course getCourse(Integer classId) {
		String d = MyUtils.getNowDateTime();
		Course c = courseMapper.getNowCourse(classId, d, d);
		return c;
	}

	@Override
	public Sign getSign(int type, String cid) {
		List<Sign> signs = signMapper.getSign(type, cid);
		if(signs.size()>0) {
			return signs.get(signs.size()-1);
		}
		return null;
	}

	@Override
	public User getJiaZhang(String userId) {
		User u = userMapper.selectByPrimaryKey(userId);
		return u;
	}

	@Override
	public User getBZR(Integer classId) {
		User u = userMapper.getBZR(classId);
		return u;
	}

	@Override
	public Classes getClasses(Integer classId) {
		return classMapper.selectByPrimaryKey(classId);
	}

	@Override
	public String upWd(User user) {
		UserExample example = new UserExample();
		example.createCriteria().andUserIdEqualTo(user.getUserId());
		
		return userMapper.updateByExampleSelective(user, example)+"";
	}

	@Override
	public String upChild(Children child) {
		ChildrenExample example = new ChildrenExample();
		example.createCriteria().andIdEqualTo(child.getId());
		return childrenMapper.updateByExampleSelective(child, example)+"";
	}
	
}
