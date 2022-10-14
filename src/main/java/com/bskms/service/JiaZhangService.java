/**
 * 
 */
package com.bskms.service;

import java.util.List;

import com.bskms.bean.Children;
import com.bskms.bean.Classes;
import com.bskms.bean.Course;
import com.bskms.bean.Foot;
import com.bskms.bean.Sign;
import com.bskms.bean.User;

/**
 * @author 19604
 *
 */
public interface JiaZhangService {
	public User getGR(String userId);

	public Foot getFoot();

	public List<Children> getChildren(String userId);

	public Course getCourse(Integer classId);

	public Sign getSign(int type, String id);

	public User getJiaZhang(String userId);

	public User getBZR(Integer classId);

	public Classes getClasses(Integer classId);

	public String upWd(User user);

	public String upChild(Children child);
}
