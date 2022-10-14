package com.bskms.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.bskms.bean.Children;
import com.bskms.bean.Classes;
import com.bskms.bean.Course;
import com.bskms.bean.Foot;
import com.bskms.bean.Notice;
import com.bskms.bean.Sign;
import com.bskms.bean.User;
import com.bskms.model.XiaoYuan;
import com.bskms.service.JiaZhangService;
import com.bskms.service.NoticeService;
import com.bskms.service.SignService;
import com.bskms.utils.MyUtils;
import com.bskms.utils.PropertyUtil;

@Controller
@RequestMapping(value = "/jz")
@ResponseBody
public class JiaZhangController {
	@Autowired
	NoticeService noticeService;
	@Autowired
	JiaZhangService jiaZhangService;
	@Autowired
	SignService signService;
	
	@RequestMapping(value = "/notices")
	public Object notices() {
		List<Notice> notices = new ArrayList<>();
		notices = noticeService.getAllNotice();
		return JSON.toJSONString(notices);
	}
	
	@RequestMapping(value = "/xy")
	public Object xy(String userId) {
		XiaoYuan xy = new XiaoYuan();
		
		if(userId==null || userId.equals("null")) {
			return JSON.toJSONString(xy);
		}
		
		//获取当天食物
		Foot foot = jiaZhangService.getFoot();
		
		//获取孩子信息
		List<Children> childres = jiaZhangService.getChildren(userId);
		
		//获取课程
		Course course = null;
		Sign qd = null; 
		Sign qt =  null;
		User bzr = null;
		Classes cl = null;
		if(childres.size()!=0) {			
			course = jiaZhangService.getCourse(childres.get(0).getClassId());
			//签到记录
			qd =  jiaZhangService.getSign(1, childres.get(0).getId()+"");
			qt =  jiaZhangService.getSign(2, childres.get(0).getId()+"");
			
			//获取班主任信息
			bzr = jiaZhangService.getBZR(childres.get(0).getClassId());
			
			//获取班级
			cl = jiaZhangService.getClasses(childres.get(0).getClassId());
		}
		
		
		//获取家长信息
		User jiazhang = jiaZhangService.getJiaZhang(userId);
		
		
		if(bzr!=null) {
			xy.setBanZhuRen(bzr.getUserName());
			xy.setBanZhuRenHao(bzr.getUserTel());
		}
		if(cl!=null) {			
			xy.setClassName(cl.getName());
		}
		if(childres.size()!=0) {			
			xy.setcName(childres.get(0).getName());
		}
		if(qd!=null) {			
			xy.setQiandao(MyUtils.getDate2String(qd.getSignIn()));
		}
		if(qt!=null) {			
			xy.setQiantui(MyUtils.getDate2String(qt.getSignIn()));
		}
		if(course!=null) {			
			xy.setShangke(course.getName());
			xy.setShangkeLaoShi(course.getTeaName());
		}
		if(foot!=null) {			
			xy.setWan(foot.getDinner());
			xy.setWu(foot.getLunch());
			xy.setZao(foot.getBreakfast());
		}
		
		
		return JSON.toJSONString(xy);
	}
	
	@RequestMapping(value = "/wd")
	public Object wd(String userId) {
		User u = null;
		
		if(userId==null || userId.equals("null")) {
			return JSON.toJSONString(u);
		}
		u =  jiaZhangService.getJiaZhang(userId);
		return JSON.toJSONString(u);
	}
	
	@RequestMapping(value = "/upwd")
	public Object upwd(User user) {
		user.setUserBirthday(MyUtils.getStringDate(user.getCsrq()));
		String result =  jiaZhangService.upWd(user);
		if(result.equals("1")) {
			return "SUCC";
		}else {
			return "ERR";
		}
	}
	
	@RequestMapping(value = "/sub")
	public Object sub(String userId) {
		//获取孩子信息
		List<Children> childres = jiaZhangService.getChildren(userId);
		
		if(userId==null || userId.equals("null")) {
			return JSON.toJSONString(new Children());
		}
		
		if(childres.size()>0) {
			return JSON.toJSONString(childres.get(0));
		}
		return new Children();
	}
	
	@RequestMapping(value = "/upsub")
	public Object upsub(Children child) {
		child.setBirthday(MyUtils.getStringDate(child.getCsrq()));
		String result =  jiaZhangService.upChild(child);
		if(result.equals("1")) {
			return "SUCC";
		}else {
			return "ERR";
		}
	}
	
	@RequestMapping(value = "/sigin")
	public Object sigin(String uid, String type) {
		if(uid==null && type==null) {
			return "ERR";
		}
		if(type.equals("1")) {
			//签到
			Sign sign = new Sign();
			sign.setKqrId(uid);
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
			sign.setType(Integer.parseInt(type));
			sign.setKqrType(2);
			sign.setSignIn(new Date());
			signService.addSign(sign);
		}else {
			//签退
			Sign sign = new Sign();
			sign.setKqrId(uid);
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
			sign.setType(Integer.parseInt(type));
			sign.setKqrType(2);
			sign.setSignIn(new Date());
			signService.addSign(sign);
		}
		return "OK";
	}
}
