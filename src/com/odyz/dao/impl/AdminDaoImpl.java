package com.odyz.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Inject;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.odyz.dao.AdminDao;
import com.odyz.model.AdminModel;
import com.util.Sql;

@Repository
//@ComponentScan
public class AdminDaoImpl implements AdminDao{

	private JdbcOperations jdbcOp;
	
	@Inject
	public AdminDaoImpl(JdbcOperations jdbcOp) {
		this.jdbcOp = jdbcOp;
	}
	
	@Override
	public AdminModel login(AdminModel admin) {
		AdminModel adminx = null;
		try {
			adminx = jdbcOp.queryForObject(Sql.ADMIN_LOGIN, new AdminRpwMapper(),admin.getUserName(),admin.getPwd());
		} catch (Exception e) {
			 e.printStackTrace();
		}
		return adminx;
	}
	
	private static final class AdminRpwMapper implements RowMapper<AdminModel>{

		@Override
		public AdminModel mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new AdminModel(rs.getInt("id"),rs.getString("userName"),rs.getString("pwd"));
		}
		
	}

}
