package com.odyz.model;

import net.sf.json.JSONObject;

public class StuValidate {
	
	public StuValidate(int stuNumber,String stuSchool,String stuName,int stuCollege,int stuId,String stuPic,int stat) {
		this.stat = stat;
		this.stuCollege = stuCollege;
		this.stuId = stuId;
		this.stuNumber = stuNumber;
		this.stuPic = stuPic;
		this.stuSchool = stuSchool;
		this.stuName = stuName;
	}

	/**
	 * 认证编号
	 */
	private int stuNumber;
	/**
	 * 学校
	 */
	private String stuSchool;
	/**
	 * 姓名
	 */
	private String stuName;
	/**
	 * 学院
	 */
	private int stuCollege;
	/**
	 * 用户编号
	 */
	private int stuId;
	/**
	 * 认证图片
	 */
	private String stuPic;
	/**
	 * 认证状态
	 * 0：待认证、1：认证成功、-1：认证失败
	 */
	private int stat;

	public int getStuNumber() {
		return stuNumber;
	}

	public void setStuNumber(int stuNumber) {
		this.stuNumber = stuNumber;
	}

	public String getStuSchool() {
		return stuSchool;
	}

	public void setStuSchool(String stuSchool) {
		this.stuSchool = stuSchool;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getStuCollege() {
		return stuCollege;
	}

	public void setStuCollege(int stuCollege) {
		this.stuCollege = stuCollege;
	}

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getStuPic() {
		return stuPic;
	}

	public void setStuPic(String stuPic) {
		this.stuPic = stuPic;
	}

	public int getStat() {
		return stat;
	}

	public void setStat(int stat) {
		this.stat = stat;
	}
	
	
	@Override
	public String toString() {
		JSONObject res = new JSONObject();
		res.put("stat", stat);
		res.put("stuNumber", stuNumber);
		res.put("stuSchool", stuSchool);
		res.put("stuName", stuName);
		res.put("stuId", stuId);
		res.put("stuPic", stuPic);
		return res.toString();
	}
	
	
}
