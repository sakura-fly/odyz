package com.util;

public class Sql {
	public static final String ADMIN_LOGIN = "select * from admin where username=? and  pwd=?";
	public static final String ADMIN_CLOSEUSER = "update OldDeal_user set memberLevel = 0 where uid = ?";
	public static final String ADMIN_CLOSESAY = "update OldDeal_user set memberLevel = 1 where uid = ?";
	public static final String ADMIN_REPORT_LIST = "select * from report   limit ?,?";
	public static final String ADMIN_REPORT_DO = "update report set tipstatus = 1 where id = ?";
	public static final String ADMIN_STU_LIST = "select * from stuValidate limit ?,?";
	public static final String ADMIN_STU_DO = "update stuValidate set stuStat = ? where stuNumber = ?";
	public static final String ADMIN_USER_LIST = "select * from OldDeal_user limit ?,?";
	public static final String ADMIN_COUNT = "select count(*) from ?";
	public static final String USER_LV = "where memberLevel = ?";
}
