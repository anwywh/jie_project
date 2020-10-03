package com.jiejie.equib.mapper;

import java.sql.Date;

public class RegUser {
	private Integer u_no;
	private String u_name;
	private String u_pwd;
	private Date u_time;
	
	public RegUser() {
		super();
	}
	public RegUser(Integer u_no, String u_name, String u_pwd, Date u_time) {
		super();
		this.u_no = u_no;
		this.u_name = u_name;
		this.u_pwd = u_pwd;
		this.u_time = u_time;
	}
	public Integer getU_no() {
		return u_no;
	}
	public void setU_no(Integer u_no) {
		this.u_no = u_no;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_pwd() {
		return u_pwd;
	}
	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}
	public Date getU_time() {
		return u_time;
	}
	public void setU_time(Date u_time) {
		this.u_time = u_time;
	}

}
