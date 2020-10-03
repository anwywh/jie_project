package com.jiejie.equib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiejie.equib.bean.Equib;
import com.jiejie.equib.dao.EquibDao;

@Service
public class equibService {
		@Autowired
		private EquibDao dao;
		
		public  Equib SelectById(int key){
			return dao.selectById(key);	
		}	
		public  boolean updateDelete(int key){
			Boolean ok = true;
			int count =dao.updateDelete(key);
			if(1!=count){
				ok=false;
				}	
				return ok;
		}	
		public  boolean updateEquib(Equib equib){
			Boolean ok = true;
			int count =dao.updateEquib(equib);
			if(1!=count){
				ok=false;
				}	
				return ok;
		}
		public  boolean updateCheck(int key){
			Boolean ok = true;
			int count =dao.updateCheck(key);
			if(1!=count){
				ok=false;
				}	
				return ok;
		}
		public  boolean updateWork(int key){
			Boolean ok = true;
			int count =dao.updateWork(key);
			if(1!=count){
				ok=false;
				}	
				return ok;
		}
		public  boolean updateState(int key){
			Boolean ok = true;
			int count =dao.updateState(key);
			if(1!=count){
				ok=false;
				}	
				return ok;
		}
		public  boolean updateState(int key, int paste){
			Boolean ok = true;
			int count =dao.updateState(key, paste);
			if(1!=count){
				ok=false;
				}	
				return ok;
		}
		public  boolean addCheck( Equib equib){
			Boolean ok = true;
			int count = dao.insert(equib);
			if(1!=count){
			ok=false;
			}	
			return ok;
		}
		public  List<Equib> workList(){
			return this.dao.workList();
		}
		public  List<Equib> stateList(){
			return this.dao.statelist();
		}
		public  List<Equib> deleteList(){
			return this.dao.deleteList();
		}
		public  List<Equib> countList(){
			return this.dao.countList();
		}
		public  List<Equib> checklist( int page,int size){
			return this.dao.check(page, size);
		}
		public  List<Equib> indexDynamiclist( int page,int size,String key){
			return this.dao.listDynamicsql(key, (page-1)*size, size);
		}
		public  List<Equib> checklist(){
			return this.dao.check(1, 6);
		}
		public int totalCheckCount() {
			return this.dao.totalcheckcount();
		}
		
		public  List<Equib> indexList( int page,int size){
			return this.dao.SelectIndex(page, size);
		}
		public  List<Equib> indexlist(){
			return this.dao.check(1, 5);
		}
		public int totalIndexCount() {
			return this.dao.totalIndexCount();
		}
		public int totalDynamicIndexCount(String name) {
			return this.dao.totalDynammiccount(name);
		}
		
		public int totalpage(int totalcount, double size){
			return (int)(Math.ceil(totalcount/size));
		}
}
