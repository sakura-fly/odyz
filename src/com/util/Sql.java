package com.util;

public class Sql {
	public static final String ADMIN_LOGIN = "select * from admin where username=? and  pwd=?";
	public static final String ADMIN_CLOSEUSER = "update OldDeal_user set memberLevel = 0 where uid = ?";
	public static final String ADMIN_CLOSESAY = "update OldDeal_user set memberLevel = 1 where uid = ?";
}
