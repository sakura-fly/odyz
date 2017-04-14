package com.odyz.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.PrintWriter;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.odyz.model.AdminModel;


/**
 * 
 * 管理员控制器类
 * @author Administrator
 *
 */


@Controller
@RequestMapping(value = "/admin")
public class AdminController {

//	@Autowired
//	@PersistenceContext
//	AdminRepository ar;
	
	/**
	 * 登录
	 * 
	 * @param u spring格式化后的管理员admin对象
	 * @param e 自动检错
	 * @param out 
	 */
	@RequestMapping(value = "/login", method = POST)
	public void lgoin(@Validated AdminModel u, Errors e, PrintWriter out) {
//		System.out.println(ar.exists(Example.of(u)));
	}

	/**
	 * 封号
	 * @param uid	被封号的用户的ID
	 * @param aid	封号的管理员的ID
	 * @param lv	封号时间1：一年、0：永久
	 * @param out
	 */
	@RequestMapping(value = "/closeuser", method = POST)
	public void closeuser(long uid, long aid, int lv, PrintWriter out) {
//		ar.sa
	}
	
	/**
	 * 禁止发言
	 * @param uid	被禁止的会员id
	 * @param aid	管理员ID
	 * @param out
	 */
	@RequestMapping(value = "/closesay", method = POST)
	public void closesay(long uid, long aid,  PrintWriter out) {

	}
	
	/**
	 * 获取举报列表
	 * @param pagenum	要查询的页码
	 * @param pagesize	每一页显示数量
	 * @param out
	 */
	@RequestMapping(value = "/reportlist", method = POST)
	public void reportlist(long pagenum, long pagesize,  PrintWriter out) {

	}
}
