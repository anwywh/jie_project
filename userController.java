package com.jiejie.equib.ctrls;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jiejie.equib.bean.RegUser;
import com.jiejie.equib.service.userService;

import sun.rmi.log.LogOutputStream;

@Controller
public class userController {
	
	@Autowired
	private userService us;
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session){
		session.setAttribute("userInfo", null);
		return "redirect:/.do";
	}
	
	@RequestMapping("/regist.do")
	public String register( RegUser user, String code,HttpSession session,Model model) {
		boolean ok=true;
		Object obj=session.getAttribute("code");
		if(null!=obj){
			String cString=(String) obj;
			if(cString.equals(code)){
				try{
					ok=us.regist(user);
				}catch (Exception e) {
				ok=false;
				}
			}else{
				ok=false;
				model.addAttribute("msg","验证码不正确");
			}
		}
		if(ok){			
			return "success";
		}else {
			return "regist";
		}
	}
	
	@RequestMapping("/regists.do")
	public String registers(String u_email, String u_name,String u_pwd, String code,HttpSession session,Model model) {
		boolean ok=true;
		RegUser user=new RegUser(null, u_name, u_pwd, null);
		Object obj=session.getAttribute("code");
		if(null!=obj){
			String cString=(String) obj;
			if(cString.equals(code)){
				try{
					ok=us.regist(user);
				}catch (Exception e) {
				ok=false;
				}
			}else{
				ok=false;
				model.addAttribute("msg","验证码不正确");
			}
		}
		if(ok){			
			return "success";
		}else {
			return "regist";
		}
	}
	
	@RequestMapping("/login.do")
	public ModelAndView login(ModelAndView mv,HttpSession session, 
			String code, String u_name, String u_pwd){
	   Object object= session.getAttribute("code");
		if(null!=object){
			String cString = (String) object;
			if(cString.equals(code)){
				RegUser user=this.us.login(u_name, u_pwd);	
				if(user ==null){
					mv.addObject("msg", "用户名密码不正确"+u_name+u_name);
					mv.setViewName("login");
				}else{
					mv.setViewName("redirect:/.do");
				   session.setAttribute("userInfo", user);
				}
			}else{
				mv.setViewName("regist");
				mv.addObject("msg", "验证码不正确");
			}
		}
		return mv;
	}
}
