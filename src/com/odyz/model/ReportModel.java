package com.odyz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.crypto.Data;

/**
 * 举报信息
 * 
 * @author Administrator
 *
 */
@Entity
public class ReportModel {

	
	/**
	 * ID
	 */
	@Id
	@GeneratedValue
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
	@Temporal(TemporalType.TIMESTAMP)
	private Data tipTime;

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

	public Data getTipTime() {
		return tipTime;
	}

	public void setTipTime(Data tipTime) {
		this.tipTime = tipTime;
	}

}
