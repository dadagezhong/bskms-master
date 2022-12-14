
package com.bskms.controller;

import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bskms.bean.ClaTea;
import com.bskms.bean.Classes;
import com.bskms.bean.Foot;
import com.bskms.bean.Material;
import com.bskms.bean.Page;
import com.bskms.bean.Pay;
import com.bskms.bean.Role;
import com.bskms.bean.User;
import com.bskms.model.LayuiMap;
import com.bskms.model.ResultMap;
import com.bskms.model.UserParameter;
import com.bskms.service.ClassService;
import com.bskms.service.FootService;
import com.bskms.service.IExcel2DB;
import com.bskms.service.MaterialService;
import com.bskms.service.PageRoleService;
import com.bskms.service.PageService;
import com.bskms.service.PayService;
import com.bskms.service.RoleService;
import com.bskms.service.TeaService;
import com.bskms.service.UserRoleService;
import com.bskms.service.UserService;
import com.bskms.utils.MD5;

@Controller
@RequestMapping(value = "/sa")
public class SaController {

	@Autowired
	private PageService pageService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private PageRoleService pageRoleService;
	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private UserService userService;
	@Autowired
	private IExcel2DB excel2db;
	@Autowired
	private ClassService classService;
	@Autowired
	private TeaService teaService;
	@Autowired
	private PayService payService;
	@Autowired
	private MaterialService materialService;
	@Autowired
	private FootService footService;

	private final Logger logger = LoggerFactory.getLogger(SaController.class);

	/**
	 * Method name: page <BR>
	 * Description: ??????????????????????????? <BR>
	 * 
	 * @param model
	 * @return String<BR>
	 */
	@RequestMapping("/page")
	public String page(Model model) {
		List<Page> pageList = pageService.getAllPage();
		model.addAttribute("pageList", pageList);
		return "sa/page";
	}

	/**
	 * Method name: role <BR>
	 * Description: ??????????????????????????? <BR>
	 * 
	 * @param model
	 * @return String<BR>
	 */
	@RequestMapping("/role")
	public String role(Model model) {
		return "sa/role";
	}

	/**
	 * Method name: getAllRole <BR>
	 * Description: ?????????????????? <BR>
	 * 
	 * @return List<Role><BR>
	 */
	@RequestMapping("/getAllRole")
	@ResponseBody
	public List<Role> getAllRole() {
		return roleService.getAllRole();
	}

	/**
	 * Method name: getAllPage <BR>
	 * Description: ?????????????????? <BR>
	 * 
	 * @return List<Page><BR>
	 */
	@RequestMapping("/getAllPage")
	@ResponseBody
	public List<Page> getAllPage() {
		return pageService.getAllPage();
	}

	/**
	 * Method name: getPageByRole <BR>
	 * Description: ????????????????????????????????? <BR>
	 * 
	 * @param userId
	 * @return Object<BR>
	 */
	@RequestMapping("/getPageByRole")
	@ResponseBody
	public Object getPageByRole(Integer roleId) {
		return pageService.getAllPageByRoleId(roleId);
	}

	/**
	 * Method name: updatePageById <BR>
	 * Description: ????????????id???????????? <BR>
	 * 
	 * @param page
	 * @return ResultMap<BR>
	 */
	@RequestMapping("/updatePageById")
	@ResponseBody
	public ResultMap updatePageById(Page page) {
		return pageService.updatePageById(page);
	}

	/**
	 * Method name: addPage <BR>
	 * Description: ???????????? <BR>
	 * 
	 * @param page
	 * @return Page<BR>
	 */
	@RequestMapping("/addPage")
	@ResponseBody
	public Page addPage(Page page) {
		return pageService.addPage(page);
	}

	/**
	 * Method name: delPageById <BR>
	 * Description: ????????????id???????????? <BR>
	 * 
	 * @param id
	 * @return ResultMap<BR>
	 */
	@RequestMapping("/delPageById")
	@ResponseBody
	public ResultMap delPageById(Integer id) {
		if (null == id) {
			return new ResultMap().fail().message("????????????");
		}
		return pageService.delPageById(id);
	}

	/**
	 * Method name: addRole <BR>
	 * Description: ???????????? <BR>
	 * 
	 * @param name
	 * @return String<BR>
	 */
	@RequestMapping("/addRole")
	@ResponseBody
	public String addRole(String name) {
		return roleService.addRole(name);
	}

	/**
	 * Method name: delManageRole <BR>
	 * Description: ????????????id???????????? <BR>
	 * 
	 * @param id
	 * @return String<BR>
	 */
	@RequestMapping("/delRole")
	@ResponseBody
	public String delRole(int id) {
		// ????????????
		boolean flag1 = roleService.delRoleById(id);
		// ????????????_?????????
		boolean flag2 = pageRoleService.delPageRoleByRoleId(id);
		// ?????????????????????????????????
		boolean flag3 = userRoleService.delUserRoleByRoleId(id);

		if (flag1 && flag2 && flag3) {
			return "SUCCESS";
		}
		return "ERROR";
	}

	/**
	 * Method name: updateRole <BR>
	 * Description: ????????????id?????????????????? <BR>
	 * 
	 * @param id
	 * @param name
	 * @return String<BR>
	 */
	@RequestMapping("/updateRole")
	@ResponseBody
	public String updateRole(Integer id, String name) {
		int n = roleService.updateRoleById(id, name);
		if (n != 0) {
			return "SUCCESS";
		}
		return "ERROR";
	}

	/**
	 * Method name: addPageRoleByRoleId <BR>
	 * Description: ????????????????????????????????? <BR>
	 * 
	 * @param roleId
	 * @param pageIds
	 * @return String<BR>
	 */
	@RequestMapping("/addPageRoleByRoleId")
	@ResponseBody
	public String addPageRoleByRoleId(Integer roleId, Integer[] pageIds) {

		if (null == roleId) {
			return "ERROR";
		}

		// ?????????????????????
		boolean flag1 = pageRoleService.delPageRoleByRoleId(roleId);
		boolean flag2 = pageRoleService.addPageRoles(roleId, pageIds);

		if (flag1 && flag2) {
			return "SUCCESS";
		}
		return "ERROR";
	}

	/**
	 * Method name: getAllUserByMap <BR>
	 * Description: ???????????????????????????????????????/???????????????????????? <BR>
	 * 
	 * @param paramUser
	 * @return Object<BR>
	 */
	@RequestMapping("/getAllUserByRoleId")
	@ResponseBody
	public Object getAllUserByRoleId(Integer roleId, String roleNot, Integer page, Integer limit) {
		if (null == roleNot) {
			return userService.getAllUserByRoleId(roleId, page, limit);
		}
		return userService.getAllUserByNotRoleId(roleId, page, limit);
	}

	/**
	 * Method name: delUserRoleByUserIdAndRoleId <BR>
	 * Description: ????????????id??????id????????????????????? <BR>
	 * 
	 * @param userId
	 * @param roleId
	 * @return ResultMap<BR>
	 */
	@RequestMapping("/delUserRoleByUserIdAndRoleId")
	@ResponseBody
	public ResultMap delUserRoleByUserIdAndRoleId(String userId, Integer roleId) {
		return userRoleService.delUserRoleByUserIdAndRoleId(userId, roleId);
	}

	/**
	 * Method name: selectUserRole <BR>
	 * Description: ????????????????????????????????? <BR>
	 * 
	 * @return String<BR>
	 */
	@RequestMapping("/selectUserRole")
	public String selectUserRole() {
		return "sa/selectUserRole";
	}

	/**
	 * Method name: addUserRole <BR>
	 * Description: ????????????????????? <BR>
	 * 
	 * @param roleId
	 * @param userIds
	 * @return String<BR>
	 */
	@RequestMapping("/addUserRole")
	@ResponseBody
	public String addUserRole(Integer roleId, String[] userIds) {
		return userRoleService.addUserRole(roleId, userIds);
	}

	/**
	 * Method name: userAddPage <BR>
	 * Description: ?????????????????? <BR>
	 * 
	 * @return String<BR>
	 */
	@RequestMapping(value = "/userAddPage")
	public String userAddPage() {
		return "sa/userAdd";
	}

	/**
	 * Method name: userPage <BR>
	 * Description: ?????????????????? <BR>
	 * 
	 * @return String<BR>
	 */
	@RequestMapping(value = "/userPage")
	public String userPage() {
		return "sa/userList";
	}

	/**
	 * Method name: getAllUserByLimit <BR>
	 * Description: ?????????????????????????????? <BR>
	 * 
	 * @param userParameter
	 * @return Object<BR>
	 */
	@RequestMapping("/getAllUserByLimit")
	@ResponseBody
	public Object getAllUserByLimit(UserParameter userParameter) {
		return userService.getAllUserByLimit(userParameter);
	}

	/**
	 * Method name: getAllDelUserByLimit <BR>
	 * Description: ???????????????????????? <BR>
	 * 
	 * @param userParameter
	 * @return Object<BR>
	 */
	@RequestMapping("/getAllDelUserByLimit")
	@ResponseBody
	public Object getAllDelUserByLimit(UserParameter userParameter) {
		return userService.getAllDelUserByLimit(userParameter);
	}

	/**
	 * Method name: delUser <BR>
	 * Description: ?????????????????? <BR>
	 * 
	 * @param ids
	 * @return String<BR>
	 */
	@RequestMapping(value = "delUser")
	@ResponseBody
	@Transactional
	public String delUser(String[] ids) {
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		try {
			for (String id : ids) {
				if (id.equals(user.getUserId())) {
					return "DontOP";
				}
				userService.delUserById(id);
			}
			return "SUCCESS";
		} catch (Exception e) {
			logger.error("????????????id??????????????????", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return "ERROR";
		}
	}

	/**
	 * Method name: addUserPage <BR>
	 * Description: ?????????????????? <BR>
	 * 
	 * @return String<BR>
	 */
	@RequestMapping(value = "/addUserPage")
	public String addUserPage(String userId, Model model) {
		model.addAttribute("manageUser", userId);
		if (null != userId) {
			User user = userService.selectByPrimaryKey(userId);
			model.addAttribute("manageUser", user);
		}
		return "sa/userAdd";
	}

	/**
	 * Method name: importUser <BR>
	 * Description: ?????????????????? <BR>
	 * 
	 * @return String<BR>
	 */
	@RequestMapping(value = "/importUser")
	public String importUser() {
		return "sa/importUser";
	}

	/**
	 * Method name: uploadAjax <BR>
	 * Description: ?????????????????? <BR>
	 * 
	 * @param file
	 * @return Object<BR>
	 */
	@ResponseBody
	@RequestMapping("/uploadAjaxByUser")
	public Object uploadAjaxByUser(@RequestParam("file") MultipartFile file) {
		String msg = excel2db.importUserExcel2DB(file);
		LayuiMap layui = new LayuiMap();
		if (msg.equals("Y")) {// ????????????
			return layui.success().message("success");
		}
		// ????????????
		return layui.fail().message(msg);
	}

	/**
	 * Method name: checkUserId <BR>
	 * Description: ?????????????????????????????? <BR>
	 * 
	 * @param userId
	 * @return User<BR>
	 */
	@ResponseBody
	@RequestMapping("/checkUserId")
	public User checkUserId(String userId) {
		return userService.selectByPrimaryKey(userId);
	}

	/**
	 * Method name: addUser <BR>
	 * Description: ???????????? <BR>
	 * 
	 * @param user
	 * @return String<BR>
	 */
	@ResponseBody
	@RequestMapping("/addUser")
	public String addUser(User user) {
		try {
			user.setUserPassword(MD5.md5(user.getUserPassword()));
			user.setAccountCreateTime(new Date());
			userService.addUser(user);
			return "SUCCESS";
		} catch (Exception e) {
			return "ERR";
		}
	}

	/**
	 * Method name: updateUser <BR>
	 * Description: ???????????? <BR>
	 * 
	 * @param user
	 * @return String<BR>
	 */
	@ResponseBody
	@RequestMapping("/updateUser")
	public String updateUser(User user, String oldId) {
		return userService.updateUser(oldId, user);
	}

	/**
	 * Method name: delUserPage <BR>
	 * Description: ????????????????????? <BR>
	 * 
	 * @return String<BR>
	 */
	@RequestMapping("/delUserPage")
	public String delUserPage() {
		return "sa/userDelPage";
	}

	/**
	 * Method name: recoverUser <BR>
	 * Description: ???????????? <BR>
	 * 
	 * @param ids
	 * @return String<BR>
	 */
	@RequestMapping("/recoverUser")
	@ResponseBody
	public String recoverUser(String[] ids) {
		try {
			for (String id : ids) {
				userService.recoverUser(id);
			}
			return "SUCCESS";
		} catch (Exception e) {
			return "ERROR";
		}
	}
	
	
	//????????????
	
	/**
	 * Method name: classesPage <BR>
	 * Description: ?????????????????? <BR>
	 * 
	 * @return String<BR>
	 */
	@RequestMapping(value = "/classesPage")
	public String classesPage() {
		return "sa/Classes";
	}
	
	/**
	 * Method name: getAllClassByLimit <BR>
	 * Description: ?????????????????????????????? <BR>
	 * 
	 * @param userParameter
	 * @return Object<BR>
	 */
	@RequestMapping("/getAllClassByLimit")
	@ResponseBody
	public Object getAllClassByLimit(Classes classParameter) {
		return classService.getAllClassByLimit(classParameter);
	}
	
	/**
	 * Method name: addClassesPage <BR>
	 * Description: ?????????????????? <BR>
	 * 
	 * @return String<BR>
	 */
	@RequestMapping(value = "/addClassesPage")
	public String addClassesPage(Integer id, Model model) {
		model.addAttribute("manageClasses", id);
		if (null != id) {
			Classes classes = classService.selectByPrimaryKey(id);
			model.addAttribute("manageClasses", classes);
		}
		List<User> user = userService.selectAllTea();
		model.addAttribute("user", user);
		return "sa/classesAdd";
	}
	
	/**
	 * Method name: addClasses <BR>
	 * Description: ???????????? <BR>
	 * 
	 * @param user
	 * @return String<BR>
	 */
	@ResponseBody
	@RequestMapping("/addClasses")
	public String addClasses(Classes classes) {
		try {
			classes.setCreateTime(new Date());
			classService.addClasses(classes);
			return "SUCCESS";
		} catch (Exception e) {
			return "ERR";
		}
	}

	/**
	 * Method name: updateClasses <BR>
	 * Description: ???????????? <BR>
	 * 
	 * @param user
	 * @return String<BR>
	 */
	@ResponseBody
	@RequestMapping("/updateClasses")
	public String updateClasses(Classes classes) {
		return classService.updateClasses(classes);
	}
	
	/**
	 * Method name: delUser <BR>
	 * Description: ?????????????????? <BR>
	 * 
	 * @param ids
	 * @return String<BR>
	 */
	@RequestMapping(value = "delClasses")
	@ResponseBody
	@Transactional
	public String delClasses(String[] ids) {
		try {
			for (String id : ids) {
				classService.delClassesById(Integer.parseInt(id));
			}
			return "SUCCESS";
		} catch (Exception e) {
			logger.error("????????????id????????????", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return "ERROR";
		}
	}
	
	

	//????????????
	
	/**
	 * Method name: teacherPage <BR>
	 * Description: ?????????????????? <BR>
	 * 
	 * @return String<BR>
	 */
	@RequestMapping(value = "/teaMG")
	public String teaMG() {
		return "sa/claTea";
	}
	
	/**
	 * Method name: getAllTeacherByLimit <BR>
	 * Description: ?????????????????????????????? <BR>
	 * 
	 * @param userParameter
	 * @return Object<BR>
	 */
	@RequestMapping("/getAllTeacherByLimit")
	@ResponseBody
	public Object getAllTeacherByLimit(ClaTea teaParameter) {
		return teaService.getAllTeaByLimit(teaParameter);
	}
	
	/**
	 * Method name: addTeaPage <BR>
	 * Description: ?????????????????? <BR>
	 * 
	 * @return String<BR>
	 */
	@RequestMapping(value = "/addTeaPage")
	public String addTeaPage(Integer id, Model model) {
		model.addAttribute("manageTea", id);
		if (null != id) {
			ClaTea clatea = teaService.selectByPrimaryKey(id);
			model.addAttribute("manageTea", clatea);
		}
		List<Classes> classes=classService.selectAllClasses();
		model.addAttribute("cla", classes);
		List<User> teacher=userService.selectAllTea();
		model.addAttribute("tea", teacher);
		return "sa/claTeaAdd";
	}
	
	/**
	 * Method name: addTea <BR>
	 * Description: ???????????? <BR>
	 * 
	 * @param user
	 * @return String<BR>
	 */
	@ResponseBody
	@RequestMapping("/addTea")
	public String addTea(ClaTea clatea) {
		try {
			
			teaService.addClaTea(clatea);
			return "SUCCESS";
		} catch (Exception e) {
			return "ERR";
		}
	}

	/**
	 * Method name: updateClaTea <BR>
	 * Description: ???????????? <BR>
	 * 
	 * @param user
	 * @return String<BR>
	 */
	@ResponseBody
	@RequestMapping("/updateClaTea")
	public String updateClaTea(ClaTea clatea) {
		return teaService.updateTea(clatea);
	}
	
	/**
	 * Method name: delClaTea <BR>
	 * Description: ??????????????????<BR>
	 * 
	 * @param ids
	 * @return String<BR>
	 */
	@RequestMapping(value = "delClaTea")
	@ResponseBody
	@Transactional
	public String delClaTea(String[] ids) {
		try {
			for (String id : ids) {
				teaService.delClaTeaById(Integer.parseInt(id));
			}
			return "SUCCESS";
		} catch (Exception e) {
			logger.error("????????????id????????????", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return "ERROR";
		}
	}

	//????????????
	
		/**
		 * Method name: payMG <BR>
		 * Description: ?????????????????? <BR>
		 * 
		 * @return String<BR>
		 */
		@RequestMapping(value = "/payMG")
		public String payMG() {
			return "sa/pay";
		}
		
		/**
		 * Method name: getAllPayByLimit <BR>
		 * Description: ?????????????????????????????? <BR>
		 * 
		 * @param userParameter
		 * @return Object<BR>
		 */
		@RequestMapping("/getAllPayByLimit")
		@ResponseBody
		public Object getAllPayByLimit(Pay payParameter) {
			return payService.getAllPayByLimit(payParameter);
		}
		
		/**
		 * Method name: addTeaPage <BR>
		 * Description: ?????????????????? <BR>
		 * 
		 * @return String<BR>
		 */
		@RequestMapping(value = "/addPayPage")
		public String addPayPage(Integer id, Model model) {
			model.addAttribute("managePay", id);
			if (null != id) {
				Pay pay = payService.selectByPrimaryKey(id);
				model.addAttribute("managePay", pay);
			}
			
			List<User> teacher=userService.selectAllTea();
			model.addAttribute("tea", teacher);
			return "sa/payAdd";
		}
		
		/**
		 * Method name: addPay <BR>
		 * Description: ???????????? <BR>
		 * 
		 * @param user
		 * @return String<BR>
		 */
		@ResponseBody
		@RequestMapping("/addPay")
		public String addPay(Pay pay) {
			try {
				pay.setPaymentTime(new Date());
				payService.addPayTea(pay);
				return "SUCCESS";
			} catch (Exception e) {
				return "ERR";
			}
		}

		/**
		 * Method name: updatePay <BR>
		 * Description: ???????????? <BR>
		 * 
		 * @param user
		 * @return String<BR>
		 */
		@ResponseBody
		@RequestMapping("/updatePay")
		public String updatePay(Pay pay) {
			return payService.updateTea(pay);
		}
		
		/**
		 * Method name: delClaTea <BR>
		 * Description: ??????????????????<BR>
		 * 
		 * @param ids
		 * @return String<BR>
		 */
		@RequestMapping(value = "delPay")
		@ResponseBody
		@Transactional
		public String delPay(String[] ids) {
			try {
				for (String id : ids) {
					payService.delClaTeaById(Integer.parseInt(id));
				}
				return "SUCCESS";
			} catch (Exception e) {
				logger.error("????????????id????????????", e);
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return "ERROR";
			}
		}
		
		//????????????
		
			/**
			 * Method name: materialMG <BR>
			 * Description: ?????????????????? <BR>
			 * 
			 * @return String<BR>
			 */
			@RequestMapping(value = "/materialMG")
			public String materialMG() {
				return "sa/material";
			}
			
			/**
			 * Method name: getAllMaterialByLimit <BR>
			 * Description: ?????????????????????????????? <BR>
			 * 
			 * @param userParameter
			 * @return Object<BR>
			 */
			@RequestMapping("/getAllMaterialByLimit")
			@ResponseBody
			public Object getAllMaterialByLimit(Material materialParameter) {
				return materialService.getAllMaterialByLimit(materialParameter);
			}
			
			/**
			 * Method name: addTeaPage <BR>
			 * Description: ?????????????????? <BR>
			 * 
			 * @return String<BR>
			 */
			@RequestMapping(value = "/addMaterialPage")
			public String addMaterialPage(Integer id, Model model) {
				model.addAttribute("manageMaterial", id);
				if (null != id) {
					Material material = materialService.selectByPrimaryKey(id);
					model.addAttribute("manageMaterial", material);
				}
				
				return "sa/materialAdd";
			}
			
			/**
			 * Method name: addMaterial <BR>
			 * Description: ???????????? <BR>
			 * 
			 * @param user
			 * @return String<BR>
			 */
			@ResponseBody
			@RequestMapping("/addMaterial")
			public String addMaterial(Material material) {
				try {
					material.setCreateTime(new Date());
					materialService.addMaterial(material);
					return "SUCCESS";
				} catch (Exception e) {
					return "ERR";
				}
			}

			/**
			 * Method name: updateMaterial <BR>
			 * Description: ???????????? <BR>
			 * 
			 * @param user
			 * @return String<BR>
			 */
			@ResponseBody
			@RequestMapping("/updateMaterial")
			public String updateMaterial(Material material) {
				return materialService.updateMaterial(material);
			}
			
			/**
			 * Method name: delClaTea <BR>
			 * Description: ??????????????????<BR>
			 * 
			 * @param ids
			 * @return String<BR>
			 */
			@RequestMapping(value = "delMaterial")
			@ResponseBody
			@Transactional
			public String delMaterial(String[] ids) {
				try {
					for (String id : ids) {
						materialService.delMaterialById(Integer.parseInt(id));
					}
					return "SUCCESS";
				} catch (Exception e) {
					logger.error("????????????id????????????", e);
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					return "ERROR";
				}
			}
			
			//????????????
			
			/**
			 * Method name: footMG <BR>
			 * Description: ?????????????????? <BR>
			 * 
			 * @return String<BR>
			 */
			@RequestMapping(value = "/footMG")
			public String footMG() {
				return "sa/foot";
			}
			
			/**
			 * Method name: getAllFootByLimit <BR>
			 * Description: ?????????????????????????????? <BR>
			 * 
			 * @param userParameter
			 * @return Object<BR>
			 */
			@RequestMapping("/getAllFootByLimit")
			@ResponseBody
			public Object getAllFootByLimit(Foot foot) {
				return footService.getAllFootByLimit(foot);
			}
			
			/**
			 * Method name: addFootPage <BR>
			 * Description: ?????????????????? <BR>
			 * 
			 * @return String<BR>
			 */
			@RequestMapping(value = "/addFootPage")
			public String addFootPage(Integer id, Model model) {
				model.addAttribute("manageFoot", id);
				if (null != id) {
					Foot foot = footService.selectByPrimaryKey(id);
					model.addAttribute("manageFoot", foot);
				}
				
				return "sa/footAdd";
			}
			
			/**
			 * Method name: addFoot <BR>
			 * Description: ???????????? <BR>
			 * 
			 * @param user
			 * @return String<BR>
			 */
			@ResponseBody
			@RequestMapping("/addFoot")
			public String addFoot(Foot foot) {
				try {
					foot.setCreateTime(new Date());
					footService.addFoot(foot);
					return "SUCCESS";
				} catch (Exception e) {
					return "ERR";
				}
			}

			/**
			 * Method name: updateFoot <BR>
			 * Description: ???????????? <BR>
			 * 
			 * @param user
			 * @return String<BR>
			 */
			@ResponseBody
			@RequestMapping("/updateFoot")
			public String updateFoot(Foot foot) {
				return footService.updateFoot(foot);
			}
			
			/**
			 * Method name: delFood <BR>
			 * Description: ??????????????????<BR>
			 * 
			 * @param ids
			 * @return String<BR>
			 */
			@RequestMapping(value = "delFood")
			@ResponseBody
			@Transactional
			public String delFood(String[] ids) {
				try {
					for (String id : ids) {
						footService.delFootById(Integer.parseInt(id));
					}
					return "SUCCESS";
				} catch (Exception e) {
					logger.error("????????????id????????????", e);
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					return "ERROR";
				}
			}
}
