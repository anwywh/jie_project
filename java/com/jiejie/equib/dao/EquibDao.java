package com.jiejie.equib.dao;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.eclipse.jdt.internal.compiler.batch.Main;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.jiejie.equib.bean.Equib;


@Repository
public class EquibDao {
	@Autowired
	private SqlSessionTemplate template;

	public int updateEquib(Equib equib){
		updateTime(equib.getEquibNO());
		return template.update(Equib.class.getName()+"Mapper.updateEquib",equib);
	}
	public int updateTime(Integer id){
		Map map= new HashMap();
		Date data=new Date(System.currentTimeMillis());
		map.put("id", id);
		map.put("time", data);
		return template.update(Equib.class.getName()+"Mapper.updateTime",map);
	}
	public Equib selectById(int id){
		Equib equib=null;
		equib=template.selectOne(Equib.class.getName()+"Mapper.selectById",id);
		return equib;
	}
	public Equib selectIdByNum(int Num){
		Equib equib=null;
	  equib=template.selectOne(Equib.class.getName()+"Mapper.select", Num);
		return equib;
	}
	public int updateCheck(int key) {
		updateTime(key);
		return this.template.update(Equib.class.getName()+"Mapper.applyCheck", key);
	}
	public int updateWork(int key) {
		return this.template.update(Equib.class.getName()+"Mapper.applyWork", key);
	}
	public int updateState(int key, int paste) {
		updateTime(key);
		Map map= new HashMap();
		map.put("id", key);
		map.put("paste", paste);
		return this.template.update(Equib.class.getName()+"Mapper.applyState", map);
	}
	public int updateState(int key) {
		updateTime(key);
		return this.template.update(Equib.class.getName()+"Mapper.applyWorked", key);
	}
	public int updateDelete(int key) {
		updateTime(key);
		return this.template.update(Equib.class.getName()+"Mapper.applyDelete", key);
	}
	
	public List<Equib> workList(){
		List<Equib> list=null;
		list=template.selectList(Equib.class.getName()+"Mapper.work");
		return list;
	}
	public List<Equib> statelist(){
		List<Equib> list=null;
		list=template.selectList(Equib.class.getName()+"Mapper.state");
		return list;
	}
	public List<Equib> deleteList(){
		List<Equib> list=null;
		list=template.selectList(Equib.class.getName()+"Mapper.delete");
		return list;
	}
	public List<Equib> countList(){
		List<Equib> list=null;
		list=template.selectList(Equib.class.getName()+"Mapper.count");
		return list;
	}
	
	
	public List<Equib> listDynamicsql( String name, int from, int size){
		Map map= new HashMap();
		map.put("equibName", name);
		map.put("from", from);
		map.put("size", size);
		return template.selectList(Equib.class.getName()+"Mapper.listDynamicSql",map);
	}
	
	
	
	public List<Equib> check(int page, int size){
		List<Equib> list=null;
		Map map= new HashMap<>();
		map.put("from", (page-1)*size);
		map.put("size", size);
		list=template.selectList(Equib.class.getName()+"Mapper.check",map);
		return list;
	}
	
	public List<Equib> SelectIndex(int page, int size){
		List<Equib> list=null;
		Map map= new HashMap<>();
		map.put("from", (page-1)*size);
		map.put("size", size);
		list=template.selectList(Equib.class.getName()+"Mapper.index",map);
		return list;
	}
	
	
	public Equib select(int equibNum){
		Equib equib=null;
		equib=template.selectOne(Equib.class.getName()+"Mapper.select",equibNum);
		return equib;
	}
	public int insert(Equib equib){
		int ok= this.template.insert(Equib.class.getName()+"Mapper.addcheck",equib);	
		int key=selectIdByNum(equib.getEquibNum()).getEquibNO();
		updateTime(key);
		return ok;	
	}
	
	public int totalcheckcount() {
		return this.template.selectOne(Equib.class.getName()+"Mapper.totalCount");
		
	}
	public int totalDynammiccount(String name){
		Map map= new HashMap();
		map.put("equibName", name);
		return this.template.selectOne(Equib.class.getName()+"Mapper.totaldyanmicCount",map);
		
	}
	public int totalIndexCount() {
		return this.template.selectOne(Equib.class.getName()+"Mapper.totalIndexCount");
	}
	
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
	    EquibDao  dao = app.getBean(EquibDao.class);
	    
	    int key=dao.selectIdByNum(1226).getEquibNO();
		dao.updateTime(key);
	    
	 //   dao.updateTime(9);
	    
	    
	/*   System.out.println(dao.select(1102).getEquibNO());*/
	    
	  
		 //equib.setEquibTime(data);
		// System.out.println(equib.getEquibTime());
	  //System.out.println(equib.getEquibTime());
	  //  dao.addcheck(equib); */
	    
	    List<Equib> list=dao.countList();
	    for(Equib a:list){
    	System.out.println(a.getEquibName());
	    }
	    
	  //  System.out.println(dao.totalIndexCount());
	  
	  
	  //System.out.println(dao.totalDynammiccount("%tes%"));
	 /*  System.out.println(dao.updateCheck(14));
	    System.out.println(dao.updateDelete(1));
	    System.out.println(dao.updateWork(15));
	    System.out.println(dao.updateState(4));*/
	 //   System.out.println(dao.updateState(2, 100));
	  //  System.out.println(dao.selectById(2));

		/*  System.out.println("------------");
	    
		  list=dao.statelist();
		  for(Equib a:list){
		    	System.out.println(a.getEquibName());
		    }

		  System.out.println("------------");
		  list=dao.deleteList();
		  for(Equib a:list){
		    	System.out.println(a.getEquibName());
		    }
		  System.out.println("------------");
		  list=dao.countList();
		  for(Equib a:list){
		    	System.out.println(a.getEquibName());
		    }*/
	   /* List<Equib> list=dao.workList();
		  for(Equib a:list){
		    	System.out.println(a.getEquibName());
		    }*/
	    
	   // Equib equib= new Equib(15, 12345, "test12", "特殊设备", null, null, null, null, 0, null);
		//dao.updateEquib(equib);
	    
	    
	    
	    
/*	  Map map= new HashMap<>();
	  map.put("equibName", "%设备%");
	  map.put("from", 0);
	  map.put("size", 10);*/
/*	  List<Equib> list=dao.listDynamicsql(map);
	  for(Equib a:list){
	    	System.out.println(a.getEquibName());
	    }*/
	  
	}
}
