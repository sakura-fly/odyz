package com.util;

public class Sql {
	public static final String ADMIN_LOGIN = "select * from manager where mname=? and  mpwd=?";
	public static final String ADMIN_CLOSEUSER = "update OldDeal_user set memberLevel = 0 where uid = ?";
	public static final String ADMIN_CLOSESAY = "update OldDeal_user set memberLevel = 1 where uid = ?";
	public static final String ADMIN_REPORT_LIST = "select * from report   limit ?,?";
	public static final String ADMIN_REPORT_DO = "update report set tipstatus = 1 where id = ?";
	public static final String ADMIN_STU_LIST = "select * from stuValidate limit ?,?";
	public static final String ADMIN_STU_DO = "update stuValidate set stuStat = ? where stuNumber = ?";
	public static final String ADMIN_USER_LIST = "select * from OldDeal_user limit ?,?";
//	public static final String USER_LV = "where memberLevel = ?";
	
	
	public static final String PUB_LIIST = "select * from pub limit ?,?";
	public static final String PUB_SEARCH = "select * from pub where uname like ? or pname like ?  limit ?,?";

	public static final String COUNT = "select count(*) from ";
	
	public static final String PUB_SEARCH_QUERY = " where uname like ? or pname like ? ";
	public static final String LIST = "select * from ";

	public static final String LIMIT = " limit ?,?";
//
//	
//	//不同的等级
	public static final String USER_NM = " where memberLevel = 2";
	public static final String USER_NO_PUB = " where memberLevel = 1";
	public static final String USER_NO_SAY = " where memberLevel = 0";
//	
//	public static final String USER_AND_SEARCH = " and uname like ? or pname like";
//
	public static final String PUB = " pub";
}
