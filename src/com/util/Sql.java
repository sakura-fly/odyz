package com.util;

public class Sql {
	public static final String ADMIN_LOGIN = "select * from manager where mname=? and  mpwd=?";
	public static final String ADMIN_CLOSEUSER = "update OldDeal_user set memberLevel = 0 where uname = ?";
	public static final String ADMIN_CLOSESAY = "update OldDeal_user set memberLevel = 1 where uname = ?";
	public static final String ADMIN_USER_NM = "update OldDeal_user set memberLevel = 2 where uname = ?";
	public static final String ADMIN_REPORT_LIST = "select * from report   limit ?,?";
	public static final String ADMIN_REPORT_LIST_SEARCH = "select * from report where tipName LIKE ?  limit ?,?";
	public static final String ADMIN_REPORT_DO = "update report set tipstatus = 0,cancel=? where rid = ?";
	public static final String ADMIN_STU_LIST = "select * from stuValidate limit ?,?";
	public static final String ADMIN_STU_DO = "update stuValidate set stuStat = ? where stuNumber = ?";
	public static final String ADMIN_USER_LIST = "select * from OldDeal_user limit ?,?";
	public static final String USER_SEARCH = "select * from OldDeal_user where uname like ?   limit ?,?";
	public static final String USER_SEARCH_NM = "select * from OldDeal_user where uname like ? and memberLevel = 2 limit ?,?";
	public static final String USER_SEARCH_NS = "select * from OldDeal_user where uname like ? and memberLevel = 1 limit ?,?";
	public static final String USER_SEARCH_NO = "select * from OldDeal_user where uname like ? and memberLevel = 0 limit ?,?";
	public static final String USER_LIST_NM = "select * from OldDeal_user where memberLevel = 2 limit ?,?";
	public static final String USER_LIST_NS = "select * from OldDeal_user where memberLevel = 1 limit ?,?";
	public static final String USER_LIST_NO = "select * from OldDeal_user where memberLevel = 0 limit ?,?";
	public static final String STU_FAIL = "update stuValidate set verifyStatus=2 where userId=?";
	public static final String STU_PASS = "update stuValidate set verifyStatus=0 where userId=?";
	// public static final String USER_LV = "where memberLevel = ?";

	public static final String PUB_LIIST = "select * from pub limit ?,?";
	public static final String PUB_SEARCH = "select * from pub where uname like ? or pname like ?  limit ?,?";

	public static final String COUNT = "select count(*) from ";

	public static final String PUB_SEARCH_QUERY = " where uname like ? or pname like ? ";
	public static final String USER_SEARCH_QUERY = " where uname like ? ";
	public static final String USER_SEARCH_QUERY_NM = " where uname like ? and memberLevel = 2";
	public static final String USER_SEARCH_QUERY_NS = " where uname like ? and memberLevel = 1";
	public static final String USER_SEARCH_QUERY_NO = " where uname like ? and memberLevel = 0";
	public static final String ADMIN_REPORT_LIST_SEARCH_QUERY = " where tipName LIKE ?  ";
	public static final String LIST = "select * from ";  

	public static final String LIMIT = " limit ?,?";

	public static final String STU_SEARCH = "select * from stuValidate where stuSchool LIKE ? OR stuCollege LIKE ? OR stuNumber LIKE ? OR stuName LIKE ? limit ?,?";
	public static final String STU_SEARCH_QUERY = " where stuSchool LIKE ? OR stuCollege LIKE ? OR stuNumber LIKE ? OR stuName LIKE ? ";
	
	public static final String ADMIN_LIST = "select * from manager limit ?,?";
	public static final String ADMIN_LIST_SEATCH = "select *from manager where mname LIKE ? limit ?,?";
	public static final String ADMIN_LIST_SEATCH_QUERY = " where mname LIKE ? ";
//
	
	public static final String PUB_DEL_BY_PID = "DELETE FROM pub where pid=?";
	public static final String ADMIN_DEL_BY_PID = "DELETE FROM manager where mid=?";
	
//	
//	//不同的等级
	public static final String USER_NM = " where memberLevel = 2";
	public static final String USER_NO_PUB = " where memberLevel = 1";
	public static final String USER_NO_SAY = " where memberLevel = 0";
	//
	// public static final String USER_AND_SEARCH = " and uname like ? or pname
	// like";
	//
	public static final String PUB = " pub";
	public static final String USER = "OldDeal_user";
	public static final String STU = "stuValidate";
	public static final String ADMIN = "manager";
	public static final String REPORT = "report";
}
