package com.odyz.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import com.odyz.dao.AdminDao;
import com.odyz.model.AdminModel;
import com.odyz.model.Pub;
import com.odyz.model.ReportModel;
import com.odyz.model.StuValidate;
import com.odyz.model.UserModel;
import com.odyz.rowmapp.AdminRowMapper;
import com.odyz.rowmapp.PubRowMapper;
import com.odyz.rowmapp.ReportRowMapper;
import com.odyz.rowmapp.StudentRowMapper;
import com.odyz.rowmapp.UserRowMapp;
import com.util.Sql;

@Repository
public class AdminDaoImpl implements AdminDao {

	private JdbcOperations jdbcOp;

	@Inject
	public AdminDaoImpl(JdbcOperations jdbcOp) {
		this.jdbcOp = jdbcOp;
	}

	@Override
	public AdminModel login(AdminModel admin) {
		AdminModel adminx = null;
		try {

			adminx = jdbcOp.queryForObject(Sql.ADMIN_LOGIN, new AdminRowMapper(), admin.getUserName(), admin.getPwd());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return adminx;
	}

	@Override
	public int closeUser(long uid) {
		int res = -1;
		try {
			res = jdbcOp.update(Sql.ADMIN_CLOSEUSER, uid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int closeSay(long uid) {
		int res = -1;
		try {
			res = jdbcOp.update(Sql.ADMIN_CLOSESAY, uid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<ReportModel> reportList(int skip, int limit) {
		List<ReportModel> res = new ArrayList<>();
		try {
			res = jdbcOp.query(Sql.ADMIN_REPORT_LIST, new Object[] { skip, limit }, new ReportRowMapper());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int reportRes(int id) {
		int res = -1;
		try {
			res = jdbcOp.update(Sql.ADMIN_REPORT_DO, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<StuValidate> studentList(int skip, int limit) {
		List<StuValidate> res = new ArrayList<>();
		try {
			res = jdbcOp.query(Sql.ADMIN_STU_LIST, new Object[] { skip, limit }, new StudentRowMapper());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int stuDo(int snum, int dores) {
		int res = -1;
		try {
			res = jdbcOp.update(Sql.ADMIN_STU_DO, dores, snum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<UserModel> userList(int skip, int limit) {
		List<UserModel> res = new ArrayList<>();
		try {
			res = jdbcOp.query(Sql.ADMIN_USER_LIST, new Object[] { skip, limit }, new UserRowMapp());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<Pub> pubList(int skip, int limit) {
		List<Pub> res = new ArrayList<>();
		try {
			String sql  =  Sql.LIST + Sql.PUB + Sql.LIMIT;
			System.out.println("sql=" + sql);
			res = jdbcOp.query(sql, new Object[] { skip, limit }, new PubRowMapper());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int count(String table) {
		Map<String, Object> r = jdbcOp.queryForMap(Sql.COUNT + table);
		System.out.println(r);
		return Integer.valueOf(r.get("count(*)").toString());
	}

}
