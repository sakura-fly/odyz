package com.odyz.dao;

import java.util.List;

import com.odyz.model.AdminModel;
import com.odyz.model.Pub;
import com.odyz.model.ReportModel;
import com.odyz.model.StuValidate;
import com.odyz.model.UserModel;

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
	
	/**
	 * 查询举报信息列表 
	 * @param skip	跳过条数
	 * @param limit	查询条数
	 * @return
	 */
	public List<ReportModel> reportList(int skip, int limit);
	
	/**
	 * 处理举报信息
	 * @param id	举报信息ID
	 * @return
	 */
	public int reportRes(int id);
	
	/**
	 * 获取学生认证信息列表
	 * @param skip	跳过条数
	 * @param limit	查询条数
	 * @return
	 */
	public List<StuValidate> studentList(int skip,int limit);
	
	/**
	 * 处理认证
	 * @param snum	编号
	 * @param res	结果
	 * @return
	 */
	public int stuDo(int snum,int res);
	
	/**
	 * 获取用户列表
	 * @param skip	跳过条数
	 * @param limit	查询条数
	 * @return
	 */
	public List<UserModel> userList(int skip,int limit);
	
	public List<Pub> pubList(int skip,int limit);
	
	
	public int count(String table);
	
}
