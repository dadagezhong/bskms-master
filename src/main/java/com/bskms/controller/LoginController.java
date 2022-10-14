package com.bskms.controller;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bskms.bean.Page;
import com.bskms.bean.User;
import com.bskms.model.ResultMap;
import com.bskms.service.PageService;
import com.bskms.service.UserService;

/**
 * class name:LoginController <BR>
 * class description: 登录操作 <BR>
 * Remark: <BR>
 */
@Controller
public class LoginController {
	@Autowired
	private ResultMap resultMap;
	@Autowired
	private UserService userService;// 用户登录service
	@Autowired
	private PageService pageService;

	private final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value = "/notLogin", method = RequestMethod.GET)
	@ResponseBody
	public ResultMap notLogin() {
		logger.warn("尚未登陆！");
		return resultMap.success().message("您尚未登陆！");
	}

	@RequestMapping(value = "/notRole", method = RequestMethod.GET)
	@ResponseBody
	public ResultMap notRole() {
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		if (user != null) {
			logger.info("{}---没有权限！", user.getUserName());
		}
		return resultMap.success().message("您没有权限！");
	}

	/**
	 * Method name: logout <BR>
	 * Description: 退出登录 <BR>
	 * @return String<BR>
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		if (null != user) {
			logger.info("{}---退出登录！", user.getUserName());
		}
		subject.logout();
		return "login";
	}

	/**
	 * Method name: login <BR>
	 * Description: 登录验证 <BR>
	 * Remark: <BR>
	 * 
	 * @param username 用户名
	 * @param password 密码
	 * @return ResultMap<BR>
	 */
	@RequestMapping(value = "/login")
	@ResponseBody
	public ResultMap login(String username, String password) {
		return userService.login(username, password);
	}

	/**
	 * Method name: login <BR>
	 * Description: 登录页面 <BR>
	 * 
	 * @return String login.html<BR>
	 */
	@RequestMapping(value = "/index")
	public String login() {
		return "login";
	}

	/**
	 * Method name: index <BR>
	 * Description: 登录页面 <BR>
	 * 
	 * @return String login.html<BR>
	 */
	@RequestMapping(value = "/")
	public String index(Model model) {
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();

		if (null != user) {
			model.addAttribute("user", user);

			List<Page> pageList = pageService.getAllRolePageByUserId(user.getUserId());

			model.addAttribute("pageList", pageList);
			return "index";
		} else {
			return "login";
		}
	}

	/**
	 * Method name: main <BR>
	 * Description: 进入主页面 <BR>
	 * 
	 * @param model
	 * @return String<BR>
	 */
	@RequestMapping(value = "/main")
	public String main(Model model) {
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		if (null != user) {
			model.addAttribute("user", user);
		} else {
			return "login";
		}

		List<Page> pageList = pageService.getAllRolePageByUserId(user.getUserId());

		model.addAttribute("pageList", pageList);
		return "index";
	}

	/**
	 * Method name: checkUserPassword <BR>
	 * Description: 检测旧密码是否正确 <BR>
	 * 
	 * @param password 旧密码
	 * @return boolean 是否正确<BR>
	 */
	@RequestMapping(value = "/user/checkUserPassword")
	@ResponseBody
	public boolean checkUserPassword(String password) {
		return userService.checkUserPassword(password);
	}

	/**
	 * Method name: updatePassword <BR>
	 * Description: 更新密码 <BR>
	 * 
	 * @param password 旧密码
	 * @return String 是否成功<BR>
	 */
	@RequestMapping(value = "/user/updatePassword")
	@ResponseBody
	public String updatePassword(String password) {
		return userService.updatePassword(password);
	}
}
