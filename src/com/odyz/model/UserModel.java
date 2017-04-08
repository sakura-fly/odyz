package com.odyz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "olddeal_user")
public class UserModel {
	@Id
	@GeneratedValue
	/**
	 * 用户编号
	 */
	@NotNull
	private int uid;
	/**
	 * 用户昵称
	 */
	@NotNull
	private String uname;
	/**
	 * 密码
	 */
	// @NotNull
	private String uwd;
	/**
	 * 确认密码
	 */
	private String corfirmupwd;
	private String QQ;
	/**
	 * 密保问题
	 */
	private String safe;
	/**
	 * 答案
	 */
	private String answer;
	/**
	 * 信用积分
	 */
	private int integral;
	/**
	 * 权限等级
	 */
	private int memberLevel;
	/**
	 * 头像图片
	 */
	private String headImg;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUwd() {
		return uwd;
	}

	public void setUwd(String uwd) {
		this.uwd = uwd;
	}

	public String getCorfirmupwd() {
		return corfirmupwd;
	}

	public void setCorfirmupwd(String corfirmupwd) {
		this.corfirmupwd = corfirmupwd;
	}

	public String getQQ() {
		return QQ;
	}

	public void setQQ(String qQ) {
		QQ = qQ;
	}

	public String getSafe() {
		return safe;
	}

	public void setSafe(String safe) {
		this.safe = safe;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getIntegral() {
		return integral;
	}

	public void setIntegral(int integral) {
		this.integral = integral;
	}

	public int getMemberLevel() {
		return memberLevel;
	}

	public void setMemberLevel(int memberLevel) {
		this.memberLevel = memberLevel;
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
}
