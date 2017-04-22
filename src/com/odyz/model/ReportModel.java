package com.odyz.model;

import java.sql.Time;
import java.sql.Timestamp;


/**
 * 举报信息
 * 
 * @author Administrator
 *
 */
public class ReportModel {

	private int rid;
	private String tipName;
	private String uname;
	private String pname;
	private String reason;
	private Timestamp tipTime;
	private int tipStatus;
	
	public ReportModel() {
		// TODO Auto-generated constructor stub
	}
	
	

	public ReportModel(String tipName, String uname, String pname, String reason, Timestamp tipTime, int tipStatus) {
		super();
		this.tipName = tipName;
		this.uname = uname;
		this.pname = pname;
		this.reason = reason;
		this.tipTime = tipTime;
		this.tipStatus = tipStatus;
	}



	public ReportModel(int rid, String tipName, String uname, String pname, String reason, Timestamp tipTime,
			int tipStatus) {
		super();
		this.rid = rid;
		this.tipName = tipName;
		this.uname = uname;
		this.pname = pname;
		this.reason = reason;
		this.tipTime = tipTime;
		this.tipStatus = tipStatus;
	}



	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getTipName() {
		return tipName;
	}

	public void setTipName(String tipName) {
		this.tipName = tipName;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Timestamp getTipTime() {
		return tipTime;
	}

	public void setTipTime(Timestamp tipTime) {
		this.tipTime = tipTime;
	}

	public int getTipStatus() {
		return tipStatus;
	}
	
	

	public void setTipStatus(int tipStatus) {
		this.tipStatus = tipStatus;
		
		
		
		
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"rid\":");
		builder.append(rid);
		builder.append(",\"tipName\":\"");
		builder.append(tipName);
		builder.append("\",\"uname\":\"");
		builder.append(uname);
		builder.append("\",\"pname\":\"");
		builder.append(pname);
		builder.append("\",\"reason\":\"");
		builder.append(reason);
		builder.append("\",\"tipTime\":\"");
		builder.append(tipTime.toString());
		builder.append("\",\"tipStatus\":");
		builder.append(tipStatus);
		builder.append("}  ");
		return builder.toString();
	}



	
	
	

}
