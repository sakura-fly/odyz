package com.util;

public class Sql {
	public static final String ADMIN_LOGIN = "select * from admin where username=? and  pwd=?";
	public static final String ADMIN_CLOSEUSER = "update OldDeal_user set memberLevel = 0 where uid = ?";
	public static final String ADMIN_CLOSESAY = "update OldDeal_user set memberLevel = 1 where uid = ?";
	public static final String ADMIN_REPORT_LIST = "select r.*,u.uname as username,utip.uname as tipname from report r,OldDeal_user u, OldDeal_user utip where u.uid = r.userid and utip.uid = r.tipid  limit ?,?";
	public static final String ADMIN_REPORT_DO = "update report set tipstatus = 1 where id = ?";
	public static final String ADMIN_STU_LIST = "select * from stuValidate limit ?,?";
}
