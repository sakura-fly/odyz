package com.odyz.model;

import java.sql.Date;

public class Pub {

	private int pid;
	private int userId;
	private String uname;
	private String pname;
	private String pone;
	private String prwo;
	private double price;
	private String newold;
	private Date pubTime;
	private String retaintime;
	private int status;
	private String pdesc;
	private String pres;
	private String pic1;
	private String pic2;
	private String pic3;
	private String pic4;
	private String pic5;
	private String pic6;


	public Pub(int pid, int userId, String uname, String pname, String pone, String prwo, double price, String newold,
			Date pubTime, String retaintime, int status, String pdesc, String pres, String pic1, String pic2,
			String pic3, String pic4, String pic5, String pic6) {
		super();
		this.pid = pid;
		this.userId = userId;
		this.uname = uname;
		this.pname = pname;
		this.pone = pone;
		this.prwo = prwo;
		this.price = price;
		this.newold = newold;
		this.pubTime = pubTime;
		this.retaintime = retaintime;
		this.status = status;
		this.pdesc = pdesc;
		this.pres = pres;
		this.pic1 = pic1;
		this.pic2 = pic2;
		this.pic3 = pic3;
		this.pic4 = pic4;
		this.pic5 = pic5;
		this.pic6 = pic6;
	}

	public String getPic6() {
		return pic6;
	}

	public void setPic6(String pic6) {
		this.pic6 = pic6;
	}

	public Pub() {
		// TODO Auto-generated constructor stub
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getPone() {
		return pone;
	}

	public void setPone(String pone) {
		this.pone = pone;
	}

	public String getPrwo() {
		return prwo;
	}

	public void setPrwo(String prwo) {
		this.prwo = prwo;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getNewold() {
		return newold;
	}

	public void setNewold(String newold) {
		this.newold = newold;
	}

	public Date getPubTime() {
		return pubTime;
	}

	public void setPubTime(Date pubTime) {
		this.pubTime = pubTime;
	}

	public String getRetaintime() {
		return retaintime;
	}

	public void setRetaintime(String retaintime) {
		this.retaintime = retaintime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public String getPres() {
		return pres;
	}

	public void setPres(String pres) {
		this.pres = pres;
	}

	public String getPic1() {
		return pic1;
	}

	public void setPic1(String pic1) {
		this.pic1 = pic1;
	}

	public String getPic2() {
		return pic2;
	}

	public void setPic2(String pic2) {
		this.pic2 = pic2;
	}

	public String getPic3() {
		return pic3;
	}

	public void setPic3(String pic3) {
		this.pic3 = pic3;
	}

	public String getPic4() {
		return pic4;
	}

	public void setPic4(String pic4) {
		this.pic4 = pic4;
	}

	public String getPic5() {
		return pic5;
	}

	public void setPic5(String pic5) {
		this.pic5 = pic5;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"pid\":\"");
		builder.append(pid);
		builder.append("\", \"userId\":\"");
		builder.append(userId);
		builder.append("\", \"uname\":\"");
		builder.append(uname);
		builder.append("\", \"pname\":\"");
		builder.append(pname);
		builder.append("\", \"pone\":\"");
		builder.append(pone);
		builder.append("\", \"prwo\":\"");
		builder.append(prwo);
		builder.append("\", \"price\":\"");
		builder.append(price);
		builder.append("\", \"newold\":\"");
		builder.append(newold);
		builder.append("\", \"pubTime\":\"");
		builder.append(pubTime);
		builder.append("\", \"retaintime\":\"");
		builder.append(retaintime);
		builder.append("\", \"status\":\"");
		builder.append(status);
		builder.append("\", \"pdesc\":\"");
		builder.append(pdesc);
		builder.append("\", \"pres\":\"");
		builder.append(pres);
		builder.append("\", \"pic1\":\"");
		builder.append(pic1);
		builder.append("\", \"pic2\":\"");
		builder.append(pic2);
		builder.append("\", \"pic3\":\"");
		builder.append(pic3);
		builder.append("\", \"pic4\":\"");
		builder.append(pic4);
		builder.append("\", \"pic5\":\"");
		builder.append(pic5);
		builder.append("\", \"pic6\":\"");
		builder.append(pic6);
		builder.append("\"}");
		return builder.toString();
	}

}
