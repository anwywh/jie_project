package com.jiejie.equib.ctrls;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jiejie.equib.bean.Equib;
import com.jiejie.equib.service.equibService;
import com.sun.org.apache.xpath.internal.operations.And;

@Controller
public class indexContoler {
	
	@Autowired
	private equibService eService;
	
	@RequestMapping("/")
	public String index(){
		System.out.println("indexControler");
		return "index";
	}
	
	@RequestMapping("/indexlist.do")
	private String indexlist (Model model,@RequestParam(value="page",defaultValue="1")int page,
			@RequestParam(value="size",defaultValue="5")int size, @RequestParam(value="key",required=false)String key,HttpSession session){
		List<Equib> list=null;int totalcount=-1;
		if(key!=null){
			try {
				key=new String(key.getBytes("ISO-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			 list = eService.indexDynamiclist(page, size, '%'+key+'%');
			 totalcount=eService.totalDynamicIndexCount('%'+key+'%');
		}else {
			 list = eService.indexList(page, size);
			 totalcount=eService.totalIndexCount();
		}
		
		model.addAttribute("indexlist",list);
		
		totalcount=eService.totalIndexCount();
		int totalPage= eService.totalpage(totalcount, size);
		model.addAttribute("currentPage", page);
		model.addAttribute("size", size);
		model.addAttribute("totalcount", totalcount);
		model.addAttribute("totalPage", totalPage);
		
		return "indexList";
		
	}
}
