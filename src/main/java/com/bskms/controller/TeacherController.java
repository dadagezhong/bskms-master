/**
 * 
 */
package com.bskms.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bskms.bean.Children;
import com.bskms.bean.ClaTea;
import com.bskms.bean.Classes;
import com.bskms.bean.Course;
import com.bskms.bean.Notice;
import com.bskms.bean.Sign;
import com.bskms.bean.User;
import com.bskms.bean.UserChildren;
import com.bskms.model.TongJi;
import com.bskms.service.ClassService;
import com.bskms.service.CourseService;
import com.bskms.service.NoticeService;
import com.bskms.service.SignService;
import com.bskms.service.StudentService;
import com.bskms.service.UserChildrenService;
import com.bskms.service.UserService;
import com.bskms.utils.PropertyUtil;

/**
 * @author samsung
 *
 */
@Controller
@RequestMapping(value = "/ls")
public class TeacherController {

	@Autowired
	private StudentService studentService;
	@Autowired
	private ClassService classService;
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private SignService signService;
	@Autowired
	private UserService userService;
	@Autowired
	private UserChildrenService userChildrenService;
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/stu")
	public String stu(Model model) {
		List<Classes> classes=classService.selectAllClasses();
		model.addAttribute("cla", classes);
		return "ls/stuPage";
	}
	//学生管理
	
		/**
		 * Method name: teacherPage <BR>
		 * Description: 教师管理页面 <BR>
		 * 
		 * @return String<BR>
		 */
		@RequestMapping(value = "/stuMG")
		public String teaMG(Model model) {
			List<Classes> classes=classService.selectAllClasses();
			model.addAttribute("cla", classes);
			return "ls/student";
		}
		
		/**
		 * Method name: getAllStudentByLimit <BR>
		 * Description: 根据条件获取所有教师 <BR>
		 * 
		 * @param userParameter
		 * @return Object<BR>
		 */
		@RequestMapping("/getAllStudentByLimit")
		@ResponseBody
		public Object getAllStudentByLimit(Children stuParameter) {
			return studentService.getAllStudentByLimit(stuParameter);
		}
		
		/**
		 * Method name: addStuPage <BR>
		 * Description: 增加教师界面 <BR>
		 * 
		 * @return String<BR>
		 */
		@RequestMapping(value = "/addStuPage")
		public String addStuPage(Integer id, Model model) {
			model.addAttribute("manageStu", id);
			if (null != id) {
				Children student = studentService.selectByPrimaryKey(id);
				//UserChildren userChild = userChildrenService.selectById(id);
				model.addAttribute("manageStu", student);
				//model.addAttribute("manageChild", userChild);
				UserChildren uc = userChildrenService.selectByUCId(student.getId());
				model.addAttribute("uc", uc);
			}
			List<Classes> classes=classService.selectAllClasses();
			model.addAttribute("cla", classes);
			
			List<User> user=userService.selectAllJiazhang();
			model.addAttribute("user", user);
			return "ls/stuPageAdd";
		}
		
		/**
		 * Method name: addStu <BR>
		 * Description: 教师添加 <BR>
		 * 
		 * @param user
		 * @return String<BR>
		 */
		@ResponseBody
		@RequestMapping("/addStu")
		public String addStu(Children student) {
			try {
				
				studentService.addStudent(student);
				addUserChildren(student);
				return "SUCCESS";
			} catch (Exception e) {
				return "ERR";
			}
		}
        public void addUserChildren(Children student) {
        	UserChildren userChildern = new UserChildren();
        	userChildern.setChildrenId(student.getId());
        	userChildern.setUserId(student.getUserId());
        	userChildern.setIsFaMa(student.getIsFaMa());
        	userChildern.setIsJinji(student.getIsJinji());
        	userChildrenService.addUserChildren(userChildern);
        	
        }
		/**
		 * Method name: updateStudent <BR>
		 * Description: 更新教师 <BR>
		 * 
		 * @param user
		 * @return String<BR>
		 */
		@ResponseBody
		@RequestMapping("/updateStudent")
		public String updateStudent(Children studnet) {
			UserChildren uc = new UserChildren();
			uc.setId(studnet.getUcId());
			uc.setChildrenId(studnet.getId());
			uc.setIsFaMa(studnet.getIsFaMa());
			uc.setIsJinji(studnet.getIsJinji());
			uc.setUserId(studnet.getUserId());
			userChildrenService.updateUC(uc);
			return studentService.updateStu(studnet);
		}
		
		/**
		 * Method name: delClaTea <BR>
		 * Description: 批量删除教师<BR>
		 * 
		 * @param ids
		 * @return String<BR>
		 */
		@RequestMapping(value = "delStudent")
		@ResponseBody
		@Transactional
		public String delStudent(String[] ids) {
			try {
				for (String id : ids) {
					studentService.delStudentById(Integer.parseInt(id));
				}
				return "SUCCESS";
			} catch (Exception e) {
				
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return "ERROR";
			}
		}
		
		//公告管理
		
			/**
			 * Method name: gg <BR>
			 * Description: 教师管理页面 <BR>
			 * 
			 * @return String<BR>
			 */
			@RequestMapping(value = "/gg")
			public String gg() {
				return "ls/notice";
			}
			
			/**
			 * Method name: getAllNoticeByLimit <BR>
			 * Description: 根据条件获取所有教师 <BR>
			 * 
			 * @param userParameter
			 * @return Object<BR>
			 */
			@RequestMapping("/getAllNoticeByLimit")
			@ResponseBody
			public Object getAllNoticeByLimit(Notice noticeParameter) {
				return noticeService.getAllNoticeByLimit(noticeParameter);
			}
			
			/**
			 * Method name: addStuPage <BR>
			 * Description: 增加教师界面 <BR>
			 * 
			 * @return String<BR>
			 */
			@RequestMapping(value = "/addNoticePage")
			public String addNoticePage(Integer id, Model model) {
				model.addAttribute("manageNotice", id);
				if (null != id) {
					Notice notice = noticeService.selectByPrimaryKey(id);
					model.addAttribute("manageNotice", notice);
				}
				
				return "ls/noticeAdd";
			}
			
			/**
			 * Method name: addStu <BR>
			 * Description: 教师添加 <BR>
			 * 
			 * @param user
			 * @return String<BR>
			 */
			@ResponseBody
			@RequestMapping("/addNotice")
			public String addNotice(Notice notice) {
				try {
					notice.setCreatTime(new Date());
					noticeService.addNotice(notice);
					return "SUCCESS";
				} catch (Exception e) {
					return "ERR";
				}
			}

			/**
			 * Method name: updateStudent <BR>
			 * Description: 更新教师 <BR>
			 * 
			 * @param user
			 * @return String<BR>
			 */
			@ResponseBody
			@RequestMapping("/updateNotice")
			public String updateNotice(Notice notice) {
				return noticeService.updateStu(notice);
			}
			
			/**
			 * Method name: delClaTea <BR>
			 * Description: 批量删除教师<BR>
			 * 
			 * @param ids
			 * @return String<BR>
			 */
			@RequestMapping(value = "delNotice")
			@ResponseBody
			@Transactional
			public String delNotice(String[] ids) {
				try {
					for (String id : ids) {
						noticeService.delNoticeById(Integer.parseInt(id));
					}
					return "SUCCESS";
				} catch (Exception e) {
					
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					return "ERROR";
				}
			}
			
			//考勤管理
			
			/**
			 * Method name: lskq <BR>
			 * Description: 教师管理页面 <BR>
			 * 
			 * @return String<BR>
			 */
			@RequestMapping(value = "/lskq")
			public String lskq() {
				return "ls/sign";
			}
			
			/**
			 * Method name: getAllSignByLimit <BR>
			 * Description: 根据条件获取所有教师 <BR>
			 * 
			 * @param userParameter
			 * @return Object<BR>
			 */
			@RequestMapping("/getAllSignByLimit")
			@ResponseBody
			public Object getAllSignByLimit(Sign signParameter) {
				return signService.getAllSignByLimit(signParameter);
			}
			
		
			//打卡
			@RequestMapping(value = "/qianDaoTui")
			public String qianDaoTui() {
				return "ls/daKa";
			}
			/**
			 * Method name: addStu <BR>
			 * Description: 教师添加 <BR>
			 * 
			 * @param user
			 * @return String<BR>
			 */
			@ResponseBody
			@RequestMapping("/addSign")
			public String addSign(Sign sign) {
			    Subject subject = SecurityUtils.getSubject();
				User user = (User) subject.getPrincipal();
				try {
					Date date=new Date();
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
					
					String time = formatter.format(date).split(" ")[2];
					String time1 = formatter.format(date).split(" ")[1];
					String s=PropertyUtil.getConfigureProperties("startTime");
					
					if(time.equals("上午") && time1.compareTo(s)>0) {
						sign.setState(1);
					}else {
						sign.setState(3);
					}
					sign.setType(1);
					sign.setSignIn(date);
					sign.setKqrId(user.getUserId());
					sign.setKqrType(user.getUserState());
					signService.addSign(sign);
					return "SUCCESS";
				} catch (Exception e) {
					return "ERR";
				}
			}

			/**
			 * Method name: addStu <BR>
			 * Description: 教师添加 <BR>
			 * 
			 * @param user
			 * @return String<BR>
			 */
			@ResponseBody
			@RequestMapping("/addQianTui")
			public String addQianTui(Sign sign) {
			    Subject subject = SecurityUtils.getSubject();
				User user = (User) subject.getPrincipal();
				try {
					Date date=new Date();
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
					String time = formatter.format(date).split(" ")[2];
					String time1 = formatter.format(date).split(" ")[1];
					
					String s=PropertyUtil.getConfigureProperties("endTime");
					
					if(time.equals("下午") && time1.compareTo(s)<0) {
						sign.setState(1);
					}else{
						sign.setState(2);
					}
					sign.setType(2);
					sign.setSignIn(date);
					sign.setKqrId(user.getUserId());
					sign.setKqrType(user.getUserState());
					signService.addSign(sign);
					return "SUCCESS";
				} catch (Exception e) {
					return "ERR";
				}
			}
           //学生考勤
			@RequestMapping(value = "/xskq")
			public String xskq() {
				return "ls/childSign";
			}
			
			/**
			 * Method name: getAllSignByLimit <BR>
			 * Description: 根据条件获取所有教师 <BR>
			 * @param userParameter
			 * @return Object<BR>
			 */
			@RequestMapping("/getAllChildSignByLimit")
			@ResponseBody
			public Object getAllChildSignByLimit(Sign signParameter) {
				return signService.getAllChildSignByLimit(signParameter);
			}
			
			//所有老师签到的总次数统计
			@RequestMapping(value = "/kqtj")
			public String kqtj(Model model) {
				List<TongJi> ts = signService.getAllTeacherCount();
				List<String> names = new ArrayList<>();
				List<Integer> zc =  new ArrayList<>();
				List<Integer> tq =  new ArrayList<>();
				List<Integer> cd =  new ArrayList<>();
				
				for (TongJi tongJi : ts) {
					names.add(tongJi.getUserName());
					zc.add(tongJi.getZhengChang());
					tq.add(tongJi.getTiQian());
					cd.add(tongJi.getChiDao());
				}
				
				model.addAttribute("names", names);
				model.addAttribute("zc", zc);
				model.addAttribute("tq", tq);
				model.addAttribute("cd", cd);
				
				return "ls/tongJi";
			}
			
			//所有学生签到的总次数统计
			@RequestMapping(value = "/tongJiXueSheng")
			public String tongJiXueSheng(Model model) {
				List<TongJi> ts = signService.getAllChildCount();
				List<String> names = new ArrayList<>();
				List<Integer> zc =  new ArrayList<>();
				List<Integer> tq =  new ArrayList<>();
				List<Integer> cd =  new ArrayList<>();
				
				for (TongJi tongJi : ts) {
					names.add(tongJi.getUserName());
					zc.add(tongJi.getZhengChang());
					tq.add(tongJi.getTiQian());
					cd.add(tongJi.getChiDao());
				}
				
				model.addAttribute("names", names);
				model.addAttribute("zc", zc);
				model.addAttribute("tq", tq);
				model.addAttribute("cd", cd);
				
				return "ls/tongJiXueSheng";
			}
			
			@RequestMapping(value = "/course")
			public String course(Model model) {
				return "ls/course";
			}
			
			//课程
			@RequestMapping(value = "/courseAdd")
			public String courseAdd(Model model) {
				List<User> users = userService.selectAllTea();
				model.addAttribute("users", users);
				
				List<Classes> clas = classService.selectAllClasses();
				model.addAttribute("cla", clas);
				return "ls/courseAdd";
			}
			
			@RequestMapping("/getAllCourseByLimit")
			@ResponseBody
			public Object getAllCourseByLimit(Course course) {
				return courseService.getAllCourseByLimit(course);
			}
			@ResponseBody
			@RequestMapping("/addCourse")
			public String addCourse(Course course) {
				course.setCreateTime(new Date());
			    try {					
			    	courseService.addCourse(course);
			    	return "SUCCESS";
				} catch (Exception e) {
					return "ERR";
				}
			}
			
			@ResponseBody
			@RequestMapping("/delCourse")
			public String delCourse(Integer id) {
			    try {					
			    	courseService.delCourse(id);
			    	return "SUCCESS";
				} catch (Exception e) {
					return "ERR";
				}
			}
}
