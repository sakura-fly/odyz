package com.odyz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.internal.NotNull;
/**
 * 管理员
 * @author Administrator
 *
 */
@Entity
@Table(name="admin")
public class AdminModel {
	@Id
	@GeneratedValue
	private long id;
	
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
