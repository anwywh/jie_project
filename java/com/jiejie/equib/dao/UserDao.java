package com.jiejie.equib.dao;


import java.util.HashMap;
import java.util.Map;
import javax.print.attribute.HashAttributeSet;

import org.eclipse.jdt.internal.compiler.batch.Main;
import org.mybatis.spring.SqlSessionTemplate;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.jiejie.equib.bean.RegUser;

@Repository
public class UserDao {
	
	@Autowired
	SqlSessionTemplate temp;
	
	public int insert(RegUser user) {
		 return temp.insert("com.jiejie.equib.bean.RegUserMapper.add", user);	
	}
	
	public RegUser  select( String name, String password){
		RegUser user=null;
		Map map=  new HashMap();
		 map.put("u_name",name);
		 map.put("u_pwd",password);
		 user= temp.selectOne(RegUser.class.getName()+"Mapper.login", map);
		return user;
	}
	
	
	
	public static void main(String[] args) {
	
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
	    UserDao  dao = app.getBean(UserDao.class);
	/*   RegUser user  = new RegUser(null, "test", "124578",null);
	   dao.insert(user);
	   System.out.println("aaa");*/
	    RegUser user = dao.select("jiejie", "123456");
	    System.out.println(user.getU_no());
	    
	}
}
