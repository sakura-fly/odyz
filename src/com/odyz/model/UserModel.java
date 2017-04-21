package com.odyz.model;

import javax.validation.constraints.NotNull;

import net.sf.json.JSONObject;

public class UserModel {
	
	
	public UserModel() {
		// TODO Auto-generated constructor stub
	}
	
	
	public UserModel(int uid, String uname, String uwd, String corfirmupwd, String qQ, String safe, String answer,
			int integral, int memberLevel, String headImg) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.uwd = uwd;
		this.corfirmupwd = corfirmupwd;
		QQ = qQ;
		this.safe = safe;
		this.answer = answer;
		this.integral = integral;
		this.memberLevel = memberLevel;
		this.headImg = headImg;
	}


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

	
	
	@Override
	public String toString() {
		JSONObject r = new JSONObject();
		r.put("uid", uid);
		r.put("uname", uname);
		r.put("upwd", uwd);
		r.put("corfirmupwd", corfirmupwd);
		r.put("QQ", QQ);
		r.put("safe", safe);
		r.put("answer", answer);
		r.put("integral", integral);
		r.put("memberLevel", memberLevel);
		r.put("memberLevel", headImg);
		return r.toString();
	}

//	@Override
//	public String toString() {
//		return "UserModel [uid=" + uid + ", uname=" + uname + ", uwd=" + uwd + ", corfirmupwd=" + corfirmupwd + ", QQ="
//				+ QQ + ", safe=" + safe + ", answer=" + answer + ", integral=" + integral + ", memberLevel="
//				+ memberLevel + ", headImg=" + headImg + "]";
//	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((QQ == null) ? 0 : QQ.hashCode());
		result = prime * result + ((answer == null) ? 0 : answer.hashCode());
		result = prime * result + ((corfirmupwd == null) ? 0 : corfirmupwd.hashCode());
		result = prime * result + ((headImg == null) ? 0 : headImg.hashCode());
		result = prime * result + integral;
		result = prime * result + memberLevel;
		result = prime * result + ((safe == null) ? 0 : safe.hashCode());
		result = prime * result + uid;
		result = prime * result + ((uname == null) ? 0 : uname.hashCode());
		result = prime * result + ((uwd == null) ? 0 : uwd.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserModel other = (UserModel) obj;
		if (QQ == null) {
			if (other.QQ != null)
				return false;
		} else if (!QQ.equals(other.QQ))
			return false;
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.equals(other.answer))
			return false;
		if (corfirmupwd == null) {
			if (other.corfirmupwd != null)
				return false;
		} else if (!corfirmupwd.equals(other.corfirmupwd))
			return false;
		if (headImg == null) {
			if (other.headImg != null)
				return false;
		} else if (!headImg.equals(other.headImg))
			return false;
		if (integral != other.integral)
			return false;
		if (memberLevel != other.memberLevel)
			return false;
		if (safe == null) {
			if (other.safe != null)
				return false;
		} else if (!safe.equals(other.safe))
			return false;
		if (uid != other.uid)
			return false;
		if (uname == null) {
			if (other.uname != null)
				return false;
		} else if (!uname.equals(other.uname))
			return false;
		if (uwd == null) {
			if (other.uwd != null)
				return false;
		} else if (!uwd.equals(other.uwd))
			return false;
		return true;
	}
	
	
}
