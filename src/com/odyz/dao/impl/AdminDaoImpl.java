package com.odyz.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.dao.DataAccessException;
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
			res = jdbcOp.query(Sql.PUB_LIIST, new Object[] { skip, limit }, new PubRowMapper());
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

	@Override
	public List<Pub> pubSearch(int skip, int limit, String query) {
		List<Pub> res = new ArrayList<>();
		try {
			res = jdbcOp.query(Sql.PUB_SEARCH, new Object[] { "%" + query + "%", "%" + query + "%", skip, limit },
					new PubRowMapper());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int count(String table, String wh, Object... query) {
		System.out.println(Sql.COUNT + table + wh);
		Map<String, Object> r = jdbcOp.queryForMap(Sql.COUNT + table + wh, query);
		System.out.println(r);
		return Integer.valueOf(r.get("count(*)").toString());
	}

	@Override
	public List<UserModel> userSearch(int skip, int limit, String query) {
		List<UserModel> res = new ArrayList<>();
		try {
			res = jdbcOp.query(Sql.USER_SEARCH, new Object[] { "%" + query + "%", skip, limit }, new UserRowMapp());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<UserModel> userSearchNm(int skip, int limit, String query) {
		List<UserModel> res = new ArrayList<>();
		try {
			res = jdbcOp.query(Sql.USER_SEARCH_NM, new Object[] { "%" + query + "%", skip, limit }, new UserRowMapp());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<UserModel> userListNm(int skip, int limit) {
		List<UserModel> res = new ArrayList<>();
		try {
			res = jdbcOp.query(Sql.USER_LIST_NM, new Object[] { skip, limit }, new UserRowMapp());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<UserModel> userSearchNs(int skip, int limit, String query) {
		List<UserModel> res = new ArrayList<>();
		try {
			res = jdbcOp.query(Sql.USER_SEARCH_NS, new Object[] { "%" + query + "%", skip, limit }, new UserRowMapp());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<UserModel> userListNs(int skip, int limit) {
		List<UserModel> res = new ArrayList<>();
		try {
			res = jdbcOp.query(Sql.USER_LIST_NS, new Object[] { skip, limit }, new UserRowMapp());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<UserModel> userSearchNo(int skip, int limit, String query) {
		List<UserModel> res = new ArrayList<>();
		try {
			res = jdbcOp.query(Sql.USER_SEARCH_NO, new Object[] { "%" + query + "%", skip, limit }, new UserRowMapp());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<UserModel> userListNo(int skip, int limit) {
		List<UserModel> res = new ArrayList<>();
		try {
			res = jdbcOp.query(Sql.USER_LIST_NO, new Object[] { skip, limit }, new UserRowMapp());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<StuValidate> stuSearch(int skip, int limit, String kw) {
		List<StuValidate> res = new ArrayList<>();
		try {
			res = jdbcOp.query(Sql.STU_SEARCH,
					new Object[] { "%" + kw + "%", "%" + kw + "%", "%" + kw + "%", "%" + kw + "%", skip, limit },
					new StudentRowMapper());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<AdminModel> adminList(int skip, int limit) {
		List<AdminModel> res = new ArrayList<>();
		try {
			res = jdbcOp.query(Sql.ADMIN_LIST, new Object[] { skip, limit }, new AdminRowMapper());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<AdminModel> adminSearch(int skip, int limit, String kw) {
		List<AdminModel> res = new ArrayList<>();
		try {
			res = jdbcOp.query(Sql.ADMIN_LIST_SEATCH, new Object[] { "%" + kw + "%", skip, limit }, new AdminRowMapper());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int pubDel(int id) {
		int res = 1;
		
		try {
			res = jdbcOp.update(Sql.PUB_DEL_BY_PID, id);
		} catch (DataAccessException e) {
			res = -1;
			e.printStackTrace();
		}
		
		return res;
	}

}
