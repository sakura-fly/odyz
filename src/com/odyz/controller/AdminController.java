package com.odyz.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.odyz.dao.AdminDao;
import com.odyz.model.AdminModel;
import com.odyz.model.Pub;
import com.resfmt.DefRes;
import com.util.Sql;

import net.sf.json.JSONObject;

/**
 * 
 * 管理员控制器类
 * 
 * @author Administrator
 *
 */

// @ContextConfiguration(classes = DbConfig.class)
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	AdminDao ad;

	/**
	 * 登录
	 * 
	 * @param u
	 *            spring格式化后的管理员admin对象
	 * @param e
	 *            自动检错
	 * @param out
	 */
	@RequestMapping(value = "/login", method = POST)
	public void lgoin(@Validated AdminModel u, Errors e, PrintWriter out) {
		AdminModel admin = ad.login(u);
		if (admin == null) {
			out.print("用户名或密码错误");
		} else {
			out.print("ok");
		}
	}

	/**
	 * 封号
	 * 
	 * @param uid
	 *            被封号的用户的ID
	 * @param aid
	 *            封号的管理员的ID
	 * @param lv
	 *            封号时间1：一年、0：永久
	 * @param out
	 */
	@RequestMapping(value = "/closeuser", method = POST)
	public void closeuser(long uid, long aid, int lv, PrintWriter out) {
		int res = ad.closeUser(uid);
		if (res > 0) {
			out.print(DefRes.dr(res, "succeed"));
		} else {
			out.print(DefRes.dr(res, "defeated"));
		}
	}

	/**
	 * 禁止发言
	 * 
	 * @param uid
	 *            被禁止的会员id
	 * @param aid
	 *            管理员ID
	 * @param out
	 */
	@RequestMapping(value = "/closesay", method = POST)
	public void closesay(long uid, long aid, PrintWriter out) {
		int res = ad.closeSay(uid);
		if (res > 0) {
			out.print(DefRes.dr(res, "succeed"));
		} else {
			out.print(DefRes.dr(res, "defeated"));
		}
	}

	/**
	 * 获取举报列表
	 * 
	 * @param pagenum
	 *            要查询的页码 默认1
	 * @param pagesize
	 *            每一页显示数量 默认5
	 * @param out
	 */
	@RequestMapping(value = "/reportlist", method = POST)
	public void reportlist(@RequestParam(defaultValue = "1") int pagenum,
			@RequestParam(defaultValue = "5") int pagesize, PrintWriter out) {
		out.print(ad.reportList((pagenum - 1) * pagesize, pagesize));
	}

	/**
	 * 处理举报结果
	 * 
	 * @param id
	 *            举报信息的id
	 * @param uid
	 *            管理员id
	 */
	@RequestMapping(value = "/reportres", method = POST)
	public void doReport(int id, int uid, PrintWriter out) {
		int res = ad.reportRes(id);
		if (res < 0) {
			out.print(DefRes.dr(res, "defeated"));
		} else {
			out.print(DefRes.dr(res, "succeed"));
		}
	}

	/**
	 * 获取学生认证信息列表
	 * 
	 * @param pagenum
	 *            要查询的页码 默认1
	 * @param pagesize
	 *            每一页显示数量 默认5
	 * @param out
	 */
	@RequestMapping(value = "/stulist", method = POST)
	public void studentsList(@RequestParam(defaultValue = "1") int pagenum,
			@RequestParam(defaultValue = "5") int pagesize, PrintWriter out) {
		out.print(ad.studentList((pagenum - 1) * pagesize, pagesize));
	}

	/**
	 * 处理学生认证
	 * 
	 * @param snum
	 *            认证编号
	 * @param res
	 *            结果
	 * @param out
	 */
	@RequestMapping(value = "/studo", method = POST)
	public void doStu(int snum, int res, PrintWriter out) {
		int r = ad.stuDo(snum, res);
		if (r < 0) {
			out.print(DefRes.dr(r, "defeated"));
		} else {
			out.print(DefRes.dr(r, "succeed"));
		}
	}

	/**
	 * 获取学生认证信息列表
	 * 
	 * @param pagenum
	 *            要查询的页码 默认1
	 * @param pagesize
	 *            每一页显示数量 默认5
	 * @param out
	 */
	@RequestMapping(value = "/userlist", method = POST)
	public void userList(@RequestParam(defaultValue = "1") int pagenum, @RequestParam(defaultValue = "5") int pagesize,
			PrintWriter out) {
		out.print(ad.userList((pagenum - 1) * pagesize, pagesize));
	}
	
	@RequestMapping(value = "/publist", method = POST)
	public void pubList(@RequestParam(defaultValue = "1") int pagenum, @RequestParam(defaultValue = "5") int pagesize,
			PrintWriter out) {
		int count = ad.count(Sql.PUB);
		List<Pub> pubList = ad.pubList((pagenum - 1) * pagesize, pagesize);
		JSONObject res = new JSONObject();
		res.put("recordCount", count);
		res.put("pageSize", pagesize);
		res.put("pageCount", Math.ceil(count/pagesize));
		res.put("pageNum", pagenum);
		res.put("data", pubList.toString());
		System.out.println(res);
		out.print(res);
	}

}
