package com.jiejie.equib.ctrls;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jiejie.equib.bean.Equib;
import com.jiejie.equib.dao.EquibDao;
import com.jiejie.equib.service.equibService;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.Alert;

@Controller
public class equibController {
	@Autowired
	private equibService ses;
	
	@RequestMapping(value="addcheck.do")
	public String addCheck(HttpSession session,Equib equib,String equibType,String equibName ){
		boolean ok=true;
			try {
				equib.setEquibType(new String(equib.getEquibType().getBytes("ISO-8859-1"),"utf-8"));
				equib.setEquibName(new String(equib.getEquibName().getBytes("ISO-8859-1"),"utf-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}		
		
		
		Object object=session.getAttribute("userInfo");
		if(null!=object){
			ses.addCheck(equib);
			session.setAttribute("msg", "申请成功");
			return "cEquib";
		}else{
			session.setAttribute("msg", "请先登录");
			return "login";
		}
	}
	
	@RequestMapping(value="check.do")
	public String checklist(HttpSession session,Map map, int page, int size){
		String result="check";
		Object object=session.getAttribute("userInfo");
		if(object!=null){
			List<Equib> list = ses.checklist(page, size);
			map.put("checklist",list);
			int totalcount=ses.totalCheckCount();
			int totalPage= ses.totalpage(totalcount, size);
			map.put("currentPage", page);
			map.put("size", size);
			map.put("totalcount", totalcount);
			map.put("totalPage", totalPage);
		}else {
			result= "redirect:/.do";
		}
		return result;
	}
	
	@RequestMapping(value="editEquib.do")
    public String Editequib( @RequestParam(value="paste", required=false,defaultValue="0" )int paste
    		,@RequestParam(value="equibName")String name
    		,@RequestParam(value="equibType")String type
    		,@RequestParam(value="equibBack", required=false)String back
    		,@RequestParam(value="equibNum")int num
    		,@RequestParam(value="equibNo")int key,HttpSession session) {
		String result = "redirect:/.do";
		Object object=session.getAttribute("userInfo");
		boolean ok = true;
		int p=(int) paste;
		if(object!=null){
			if(p!=0){			
				ok=ses.updateState(key, paste);
			}
			if(back!=null){				
				try {
					back=new String(back.getBytes("ISO-8859-1"),"utf-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			try {
				name=new String(name.getBytes("ISO-8859-1"),"utf-8");
				type=new String(type.getBytes("ISO-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			Equib equib= new Equib(key, num, name, type, null, null, null, null, 0, back);
			ses.updateEquib(equib);
		}
		return result;
	}	
	@RequestMapping(value="selectEquib.do")
    public String SelectEquib( @RequestParam(value="id")int id,Model mv,HttpSession session) {
		String result = ".do";
		Equib  equib = ses.SelectById(id);
		mv.addAttribute("equib", equib);
		int key=equib.getEquibNO();
		mv.addAttribute("id", key);
		return "editEquib";
	}
	

	@RequestMapping(value="success.do")
	public String success(HttpSession session,@RequestParam(value="type")String type, 
			@RequestParam(value="id")Integer key){
		String reString=".do";
		Boolean ok;
		switch (type) {
		case "check":
			ok=ses.updateCheck(key);
			if(ok){
				session.setAttribute("msg", "success");
			}else{
				session.setAttribute("msg", "falure");
			}
			reString="check";
			break;
		case "work":
			ok=ses.updateWork(key);
			if(ok){
				session.setAttribute("msg", "success");
				reString="redirect:/workList.do";
			}else{
				session.setAttribute("msg", "falure");
			}
			break;
		case "state":
			ok=ses.updateState(key);
			if(ok){
				session.setAttribute("msg", "success");
			}else{
				session.setAttribute("msg", "falure");
			}
			reString="redirect:/.do";
			break;
		case "delete":
			ok=ses.updateDelete(key);
			if(ok){
				session.setAttribute("msg", "success");
			}else{
				session.setAttribute("msg", "falure");
			}
			reString="redirect:/.do";
			break;
		default:
			break;
		}
		
		return reString;
	}

}
