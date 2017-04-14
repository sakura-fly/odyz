package com.odyz.dao;

import com.odyz.model.AdminModel;

/**
 * 管理员DAO接口
 * @author Administrator
 *
 */
public interface AdminDao {
	/**
	 * 管理员登录
	 * @param admin 管理员模型对象
	 * @return
	 */
	public AdminModel login(AdminModel admin);
	/**
	 * 封号
	 * @param uid 被封号的会员id
	 * @return
	 */
	public int closeUser(long uid);
	
	/**
	 * 禁止发布信息
	 * @param uid 被禁止的用户的id
	 * @return
	 */
	public int closeSay(long uid);
}
