package com.odyz.model;

import net.sf.json.JSONObject;

public class StuValidate {

	private int stuId;
	private int userId;
	private String stuSchool;
	private String stuCollege;
	private String stuNumber;
	private String stuName;
	private String stuImg;
	private int verifyStatus;

	public StuValidate(int stuId, int userId, String stuSchool, String stuCollege, String stuNumber, String stuName,
			String stuImg, int verifyStatus) {
		super();
		this.stuId = stuId;
		this.userId = userId;
		this.stuSchool = stuSchool;
		this.stuCollege = stuCollege;
		this.stuNumber = stuNumber;
		this.stuName = stuName;
		this.stuImg = stuImg;
		this.verifyStatus = verifyStatus;
	}

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getStuSchool() {
		return stuSchool;
	}

	public void setStuSchool(String stuSchool) {
		this.stuSchool = stuSchool;
	}

	public String getStuCollege() {
		return stuCollege;
	}

	public void setStuCollege(String stuCollege) {
		this.stuCollege = stuCollege;
	}

	public String getStuNumber() {
		return stuNumber;
	}

	public void setStuNumber(String stuNumber) {
		this.stuNumber = stuNumber;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuImg() {
		return stuImg;
	}

	public void setStuImg(String stuImg) {
		this.stuImg = stuImg;
	}

	public int getVerifyStatus() {
		return verifyStatus;
	}

	public void setVerifyStatus(int verifyStatus) {
		this.verifyStatus = verifyStatus;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"stuId\":\"");
		builder.append(stuId);
		builder.append("\",\"userId\":\"");
		builder.append(userId);
		builder.append("\",\"stuSchool\":\"");
		builder.append(stuSchool);
		builder.append("\",\"stuCollege\":\"");
		builder.append(stuCollege);
		builder.append("\",\"stuNumber\":\"");
		builder.append(stuNumber);
		builder.append("\",\"stuName\":\"");
		builder.append(stuName);
		builder.append("\",\"stuImg\":\"");
		builder.append(stuImg);
		builder.append("\",\"verifyStatus\":\"");
		builder.append(verifyStatus);
		builder.append("\"} ");
		return builder.toString();
	}



}
