package com.odyz.model;

import java.sql.Date;

import net.sf.json.JSONObject;


/**
 * 举报信息
 * 
 * @author Administrator
 *
 */
public class ReportModel {
	
	public ReportModel(int id, int userid, int tipid, String tipMessage, int tipStatus, Date date,String userName,String tipName) {
		this.id = id;
		this.userId = userid;
		this.tipId = tipid;
		this.tipMessage = tipMessage;
		this.tipStatus = tipStatus;
		this.tipName= tipName;
		this.userName = userName;
		this.tipTime = date;
	}

	
	/**
	 * ID
	 */
	private int id;
	/**
	 * 举报用户ID
	 */
	private int userId;
	/**
	 * 被举报用户ID
	 */
	private int tipId;
	/**
	 * 举报信息
	 */
	private String tipMessage;
	/**
	 * 举报状态
	 * 0：未读、1：已处理
	 */
	private int tipStatus;
	/**
	 * 举报时间
	 */
	private Date tipTime;
	
	private String userName;
	
	private String tipName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTipId() {
		return tipId;
	}

	public void setTipId(int tipId) {
		this.tipId = tipId;
	}

	public String getTipMessage() {
		return tipMessage;
	}

	public void setTipMessage(String tipMessage) {
		this.tipMessage = tipMessage;
	}

	public int getTipStatus() {
		return tipStatus;
	}

	public void setTipStatus(int tipStatus) {
		this.tipStatus = tipStatus;
	}

	public Date getTipTime() {
		return tipTime;
	}

	public void setTipTime(Date tipTime) {
		this.tipTime = tipTime;
	}

	
	@Override
	public String toString() {
		JSONObject r = new JSONObject();
		r.put("id", this.id);
		r.put("tipmessage", this.tipMessage);
		r.put("tiptime", this.tipTime.toString());
		r.put("tipstatus", this.tipStatus);
		r.put("tipid", this.tipId);
		r.put("tipname", this.tipName);
		r.put("userid", this.userId);
		r.put("username", this.userName);
		return r.toString();
	}
	
}
