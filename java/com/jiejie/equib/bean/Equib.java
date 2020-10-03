package com.jiejie.equib.bean;

import java.sql.Date;

public class Equib {
	private Integer equibNO;
	private Integer equibNum;
	private String equibName;
	private String equibType;
	private String equibState;
	private String equibWork;
	private String equibCheck;
	private Date equibTime;
	private int equibCount;
	private String equibBack;
	
	public Integer getEquibNO() {
		return equibNO;
	}

	public void setEquibNO(Integer equibNO) {
		this.equibNO = equibNO;
	}

	public Integer getEquibNum() {
		return equibNum;
	}

	public void setEquibNum(Integer equibNum) {
		this.equibNum = equibNum;
	}

	public String getEquibName() {
		return equibName;
	}

	public void setEquibName(String equibName) {
		this.equibName = equibName;
	}

	public String getEquibType() {
		return equibType;
	}

	public void setEquibType(String equibType) {
		this.equibType = equibType;
	}

	public String getEquibState() {
		return equibState;
	}

	public void setEquibState(String equibState) {
		this.equibState = equibState;
	}

	public String getEquibWork() {
		return equibWork;
	}

	public void setEquibWork(String equibWork) {
		this.equibWork = equibWork;
	}

	public String getEquibCheck() {
		return equibCheck;
	}

	public void setEquibCheck(String equibCheck) {
		this.equibCheck = equibCheck;
	}

	public Date getEquibTime() {
		return equibTime;
	}

	public void setEquibTime(Date equibTime) {
		this.equibTime = equibTime;
	}

	public int getEquibCount() {
		return equibCount;
	}

	public void setEquibCount(int equibCount) {
		this.equibCount = equibCount;
	}

	public String getEquibBack() {
		return equibBack;
	}

	public void setEquibBack(String equibBack) {
		this.equibBack = equibBack;
	}

	public Equib() {
		super();
	}

	public Equib(Integer equibNO, Integer equibNum, String equibName, String equibType, String equibState,
			String equibWork, String equibCheck, Date equibTime, int equibCount, String equibBack) {
		super();
		this.equibNO = equibNO;
		this.equibNum = equibNum;
		this.equibName = equibName;
		this.equibType = equibType;
		this.equibState = equibState;
		this.equibWork = equibWork;
		this.equibCheck = equibCheck;
		this.equibTime = equibTime;
		this.equibCount = equibCount;
		this.equibBack = equibBack;
	}
}
