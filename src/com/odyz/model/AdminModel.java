package com.odyz.model;

import javax.validation.constraints.Size;

import com.sun.istack.internal.NotNull;

import net.sf.json.JSONObject;
/**
 * 管理员
 * @author Administrator
 *
 */
//@Entity
//@Table(name="admin")
public class AdminModel {
	
	public AdminModel() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public AdminModel(int id, String userName,String pwd){
		this.id = id;
		this.userName = userName;
		this.pwd = pwd;
	}
	
	private int id;
	
	/**
	 * 用户名
	 */
	@NotNull
	@Size(min=2,max=12)
	private String userName;
	
	
	/**
	 * 密码
	 */
	@NotNull
	@Size(min=6,max=12)
	private String pwd;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	
	@Override
	public String toString() {
		JSONObject adminj = new JSONObject();
		adminj.put("mid", this.id);
		adminj.put("mname", this.userName);
//		adminj.put("pwd", this.pwd);
		return adminj.toString();
	}
	
	
}
