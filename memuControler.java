package com.jiejie.equib.ctrls;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jiejie.equib.bean.Equib;
import com.jiejie.equib.service.equibService;

@Controller
public class memuControler {

	@Autowired
	private equibService eService;
	
	@RequestMapping("/workList.do")
	public String workList(Model model,HttpSession session) {
		List<Equib> list=null;
		System.out.println("workListControler");
		list=eService.workList();
		model.addAttribute("worklist",list);
		return "workList";
	}
	@RequestMapping("/stateList.do")
	public String stateList(Model model,HttpSession session) {
		List<Equib> list=null;
		list=eService.stateList();
		model.addAttribute("statelist",list);
		return "stateList";
	}
	@RequestMapping("/deleteList.do")
	public String dList(Model model,HttpSession session) {
		List<Equib> list=null;
		list=eService.deleteList();
		model.addAttribute("deletelist",list);
		return "deleteList";
	}
	@RequestMapping("/countList.do")
	public String countList(Model model,HttpSession session) {
		List<Equib> list=null;
		list=eService.countList();
		model.addAttribute("countlist",list);
		return "countList";
	}
}
