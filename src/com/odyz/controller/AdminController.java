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
import com.odyz.model.ReportModel;
import com.odyz.model.StuValidate;
import com.odyz.model.UserModel;
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
	public void closeuser(String uname, PrintWriter out) {
		int res = ad.closeUser(uname);
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
	public void closesay(String uname, PrintWriter out) {
		int res = ad.closeSay(uname);
		if (res > 0) {
			out.print(DefRes.dr(res, "succeed"));
		} else {
			out.print(DefRes.dr(res, "defeated"));
		}
	}
	
	/**
	 * 恢复正常
	 * 
	 * @param uid
	 *            被禁止的会员id
	 * @param aid
	 *            管理员ID
	 * @param out
	 */
	@RequestMapping(value = "/usernm", method = POST)
	public void usernm(String uname, PrintWriter out) {
		int res = ad.userNm(uname);
		if (res > 0) {
			out.print(DefRes.dr(res, "succeed"));
		} else {
			out.print(DefRes.dr(res, "defeated"));
		}
	}

	/**
	 * 获取举报列表
	 * 
	 * @param pageNum
	 *            要查询的页码 默认1
	 * @param pagesize
	 *            每一页显示数量 默认5
	 * @param out
	 */
	@RequestMapping(value = "/reportlist", method = POST)
	public void reportlist(@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "5") int pagesize, PrintWriter out) {
		int count = ad.count(Sql.REPORT);
		List<ReportModel> reportl = ad.reportList((pageNum - 1) * pagesize, pagesize);
		JSONObject res = new JSONObject();
		res.put("recordCount", count);
		res.put("pageSize", pagesize);
		res.put("pageCount", Math.ceil((double) count / (double) pagesize));
		res.put("pageNum", pageNum);
		res.put("data", reportl.toString());
		System.out.println(res);
		out.print(res);
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
	public void doReport(int rid, String cancel, PrintWriter out) {
		int res = ad.reportRes(rid,cancel);
		if (res < 0) {
			out.print(DefRes.dr(res, "defeated"));
		} else {
			out.print(DefRes.dr(res, "succeed"));
		}
	}

	/**
	 * 获取学生认证信息列表
	 * 
	 * @param pageNum
	 *            要查询的页码 默认1
	 * @param pagesize
	 *            每一页显示数量 默认5
	 * @param out
	 */
	@RequestMapping(value = "/stulist", method = POST)
	public void studentsList(@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "5") int pagesize, PrintWriter out) {
		int count = ad.count(Sql.STU);
		List<StuValidate> stul = ad.studentList((pageNum - 1) * pagesize, pagesize);
		JSONObject res = new JSONObject();
		res.put("recordCount", count);
		res.put("pageSize", pagesize);
		res.put("pageCount", Math.ceil((double) count / (double) pagesize));
		res.put("pageNum", pageNum);
		res.put("data", stul.toString());
		System.out.println(res);
		out.print(res);
	}

	/**
	 * 获取学生认证信息列表查询
	 * 
	 * @param pageNum
	 *            要查询的页码 默认1
	 * @param pagesize
	 *            每一页显示数量 默认5
	 * @param out
	 */
	@RequestMapping(value = "/stusearch", method = POST)
	public void studentsSearch(@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "5") int pagesize, PrintWriter out, String kw) {
		int count = ad.count(Sql.STU, Sql.STU_SEARCH_QUERY, "%" + kw + "%", "%" + kw + "%", "%" + kw + "%",
				"%" + kw + "%");
		System.out.println(kw);
		List<StuValidate> stul = ad.stuSearch((pageNum - 1) * pagesize, pagesize, kw);
		JSONObject res = new JSONObject();
		res.put("recordCount", count);
		res.put("pageSize", pagesize);
		res.put("pageCount", Math.ceil((double) count / (double) pagesize));
		res.put("pageNum", pageNum);
		res.put("data", stul.toString());
		System.out.println(res);
		out.print(res);
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
	 * @param pageNum
	 *            要查询的页码 默认1
	 * @param pagesize
	 *            每一页显示数量 默认5
	 * @param out
	 */
	@RequestMapping(value = "/userlist", method = POST)
	public void userList(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pagesize,
			PrintWriter out) {
		int count = ad.count(Sql.USER);

		List<UserModel> ul = ad.userList((pageNum - 1) * pagesize, pagesize);

		JSONObject res = new JSONObject();
		res.put("recordCount", count);
		res.put("pageSize", pagesize);
		res.put("pageCount", Math.ceil((double) count / (double) pagesize));
		res.put("pageNum", pageNum);
		res.put("data", ul.toString());
		System.out.println(res);
		out.print(res);

	}

	@RequestMapping(value = "/publist", method = POST)
	public void pubList(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pagesize,
			PrintWriter out) {
		int count = ad.count(Sql.PUB);
		List<Pub> pubList = ad.pubList((pageNum - 1) * pagesize, pagesize);
		JSONObject res = new JSONObject();
		res.put("recordCount", count);
		res.put("pageSize", pagesize);
		res.put("pageCount", Math.ceil((double) count / (double) pagesize));
		res.put("pageNum", pageNum);
		res.put("data", pubList.toString());
		System.out.println(res);
		out.print(res);
	}

	@RequestMapping(value = "/pubsearch", method = POST)
	public void pubSearch(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pagesize,
			String kw, PrintWriter out) {
		int count = ad.count(Sql.PUB, Sql.PUB_SEARCH_QUERY, "%" + kw + "%", "%" + kw + "%");
		List<Pub> pubList = ad.pubSearch((pageNum - 1) * pagesize, pagesize, kw);
		JSONObject res = new JSONObject();
		res.put("recordCount", count);
		res.put("pageSize", pagesize);
		res.put("pageCount", Math.ceil((double) count / (double) pagesize));
		res.put("pageNum", pageNum);
		res.put("data", pubList.toString());
		System.out.println(res);
		out.print(res);
	}

	@RequestMapping(value = "/usersearch", method = POST)
	public void userSearch(@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "5") int pagesize, String kw, PrintWriter out) {
		System.out.println(kw);
		int count = ad.count(Sql.USER, Sql.USER_SEARCH_QUERY, "%" + kw + "%");
		List<UserModel> pubList = ad.userSearch((pageNum - 1) * pagesize, pagesize, kw);
		JSONObject res = new JSONObject();
		res.put("recordCount", count);
		res.put("pageSize", pagesize);
		res.put("pageCount", Math.ceil((double) count / (double) pagesize));
		res.put("pageNum", pageNum);
		res.put("data", pubList.toString());
		System.out.println(res);
		out.print(res);
	}

	@RequestMapping(value = "/usersearchnm", method = POST)
	public void userSearchNm(@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "5") int pagesize, String kw, PrintWriter out) {
		System.out.println(kw);
		int count = ad.count(Sql.USER, Sql.USER_SEARCH_QUERY_NM, "%" + kw + "%");
		List<UserModel> pubList = ad.userSearchNm((pageNum - 1) * pagesize, pagesize, kw);
		JSONObject res = new JSONObject();
		res.put("recordCount", count);
		res.put("pageSize", pagesize);
		res.put("pageCount", Math.ceil((double) count / (double) pagesize));
		res.put("pageNum", pageNum);
		res.put("data", pubList.toString());
		System.out.println(res);
		out.print(res);
	}

	@RequestMapping(value = "/usersearchns", method = POST)
	public void userSearchNs(@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "5") int pagesize, String kw, PrintWriter out) {
		System.out.println(kw);
		int count = ad.count(Sql.USER, Sql.USER_SEARCH_QUERY_NS, "%" + kw + "%");
		List<UserModel> pubList = ad.userSearchNs((pageNum - 1) * pagesize, pagesize, kw);
		JSONObject res = new JSONObject();
		res.put("recordCount", count);
		res.put("pageSize", pagesize);
		res.put("pageCount", Math.ceil((double) count / (double) pagesize));
		res.put("pageNum", pageNum);
		res.put("data", pubList.toString());
		System.out.println(res);
		out.print(res);
	}

	@RequestMapping(value = "/usersearchno", method = POST)
	public void userSearchNo(@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "5") int pagesize, String kw, PrintWriter out) {
		System.out.println(kw);
		int count = ad.count(Sql.USER, Sql.USER_SEARCH_QUERY_NO, "%" + kw + "%");
		List<UserModel> pubList = ad.userSearchNo((pageNum - 1) * pagesize, pagesize, kw);
		JSONObject res = new JSONObject();
		res.put("recordCount", count);
		res.put("pageSize", pagesize);
		res.put("pageCount", Math.ceil((double) count / (double) pagesize));
		res.put("pageNum", pageNum);
		res.put("data", pubList.toString());
		System.out.println(res);
		out.print(res);
	}

	/**
	 * 获取学生认证信息列表
	 * 
	 * @param pageNum
	 *            要查询的页码 默认1
	 * @param pagesize
	 *            每一页显示数量 默认5
	 * @param out
	 */
	@RequestMapping(value = "/userlistnm", method = POST)
	public void userListNm(@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "5") int pagesize, PrintWriter out) {
		int count = ad.count(Sql.USER, Sql.USER_NM);

		List<UserModel> ul = ad.userListNm((pageNum - 1) * pagesize, pagesize);

		JSONObject res = new JSONObject();
		res.put("recordCount", count);
		res.put("pageSize", pagesize);
		res.put("pageCount", Math.ceil((double) count / (double) pagesize));
		res.put("pageNum", pageNum);
		res.put("data", ul.toString());
		System.out.println(res);
		out.print(res);

	}

	/**
	 * 获取学生认证信息列表
	 * 
	 * @param pageNum
	 *            要查询的页码 默认1
	 * @param pagesize
	 *            每一页显示数量 默认5
	 * @param out
	 */
	@RequestMapping(value = "/userlistns", method = POST)
	public void userListNs(@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "5") int pagesize, PrintWriter out) {
		int count = ad.count(Sql.USER, Sql.USER_NO_PUB);

		List<UserModel> ul = ad.userListNs((pageNum - 1) * pagesize, pagesize);

		JSONObject res = new JSONObject();
		res.put("recordCount", count);
		res.put("pageSize", pagesize);
		res.put("pageCount", Math.ceil((double) count / (double) pagesize));
		res.put("pageNum", pageNum);
		res.put("data", ul.toString());
		System.out.println(res);
		out.print(res);

	}

	/**
	 * 获取学生认证信息列表
	 * 
	 * @param pageNum
	 *            要查询的页码 默认1
	 * @param pagesize
	 *            每一页显示数量 默认5
	 * @param out
	 */
	@RequestMapping(value = "/userlistno", method = POST)
	public void userListNo(@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "5") int pagesize, PrintWriter out) {
		int count = ad.count(Sql.USER, Sql.USER_NO_SAY);
		List<UserModel> ul = ad.userListNo((pageNum - 1) * pagesize, pagesize);
		JSONObject res = new JSONObject();
		res.put("recordCount", count);
		res.put("pageSize", pagesize);
		res.put("pageCount", Math.ceil((double) count / (double) pagesize));
		res.put("pageNum", pageNum);
		res.put("data", ul.toString());
		System.out.println(res);
		out.print(res);

	}

	/**
	 * 获取学生认证信息列表
	 * 
	 * @param pageNum
	 *            要查询的页码 默认1
	 * @param pagesize
	 *            每一页显示数量 默认5
	 * @param out
	 */
	@RequestMapping(value = "/adminlist", method = POST)
	public void adminList(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pagesize,
			PrintWriter out) {
		int count = ad.count(Sql.ADMIN);
		List<AdminModel> ul = ad.adminList((pageNum - 1) * pagesize, pagesize);
		JSONObject res = new JSONObject();
		res.put("recordCount", count);
		res.put("pageSize", pagesize);
		res.put("pageCount", Math.ceil((double) count / (double) pagesize));
		res.put("pageNum", pageNum);
		res.put("data", ul.toString());
		System.out.println(res);
		out.print(res);

	}

	@RequestMapping(value = "/adminsearch", method = POST)
	public void adminSearch(@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "5") int pagesize, String kw, PrintWriter out) {
		System.out.println(kw);
		int count = ad.count(Sql.ADMIN, Sql.ADMIN_LIST_SEATCH_QUERY, "%" + kw + "%");
		List<AdminModel> pubList = ad.adminSearch((pageNum - 1) * pagesize, pagesize, kw);
		JSONObject res = new JSONObject();
		res.put("recordCount", count);
		res.put("pageSize", pagesize);
		res.put("pageCount", Math.ceil((double) count / (double) pagesize));
		res.put("pageNum", pageNum);
		res.put("data", pubList.toString());
		System.out.println(res);
		out.print(res);
	}

	@RequestMapping(value = "/pubdel", method = POST)
	public void pubDel(int pid, PrintWriter out) {
		int r = ad.pubDel(pid);
		if (r > 0) {
			out.print("succ");
		} else {
			out.print("err");
		}
	}

	@RequestMapping(value = "/admindel", method = POST)
	public void adminDel(int mid, PrintWriter out) {
		int r = ad.adminDel(mid);
		if (r > 0) {
			out.print("succ");
		} else {
			out.print("err");
		}
	}
	
	@RequestMapping(value = "/stupass", method = POST)
	public void stuPass(int userId, PrintWriter out) {
		int r = ad.stuPass(userId);
		if (r > 0) {
			out.print("succ");
		} else {
			out.print("err");
		}
	}
	
	@RequestMapping(value = "/stufail", method = POST)
	public void stuFail(int userId, PrintWriter out) {
		int r = ad.stuFail(userId);
		if (r > 0) {
			out.print("succ");
		} else {
			out.print("err");
		}
	}
	
	@RequestMapping(value = "/reportsearch", method = POST)
	public void reportSearch(@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "5") int pagesize, String kw, PrintWriter out) {
		System.out.println(kw);
		int count = ad.count(Sql.REPORT, Sql.ADMIN_REPORT_LIST_SEARCH_QUERY, "%" + kw + "%");
		List<ReportModel> pubList = ad.reportSearch((pageNum - 1) * pagesize, pagesize, kw);
		JSONObject res = new JSONObject();
		res.put("recordCount", count);
		res.put("pageSize", pagesize);
		res.put("pageCount", Math.ceil((double) count / (double) pagesize));
		res.put("pageNum", pageNum);
		res.put("data", pubList.toString());
		System.out.println(res);
		out.print(res);
	}

}
