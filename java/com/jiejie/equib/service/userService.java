package com.jiejie.equib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiejie.equib.bean.RegUser;
import com.jiejie.equib.dao.UserDao;

@Service
public class userService {
	
	@Autowired
	private UserDao dao;

	public boolean regist(RegUser user){
		Boolean ok = true;
		int count = dao.insert(user);
		if(1!=count){
			ok=false;
		}
		return ok;
	}
	public RegUser login(String name, String password){
		return dao.select(name, password);
	}
}
