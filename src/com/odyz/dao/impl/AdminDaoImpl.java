package com.odyz.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import com.odyz.dao.AdminDao;
import com.odyz.model.AdminModel;
import com.odyz.model.ReportModel;
import com.odyz.rowmapp.AdminRowMapper;
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
	public List<ReportModel> reportList(int pageNum, int pageSize) {
		List<ReportModel> res = new ArrayList<>();
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

}