package com.odyz.model;

import java.sql.Date;


/**
 * 举报信息
 * 
 * @author Administrator
 *
 */
public class ReportModel {
	
	public ReportModel(int id, int userid, int tipid, String tipMessage, int tipStatus, Date date) {
		this.id = id;
		this.userId = userid;
		this.tipId = tipid;
		this.tipMessage = tipMessage;
		this.tipStatus = tipStatus;
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

}
