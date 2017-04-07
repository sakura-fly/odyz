package com.odyz.model;

import javax.validation.constraints.Size;

import com.sun.istack.internal.NotNull;

public class AdminModel {
	private long id;
	
	@NotNull
	@Size(min=2,max=12)
	private String userName;
	
	@NotNull
	@Size(min=6,max=12)
	private String pwd;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
