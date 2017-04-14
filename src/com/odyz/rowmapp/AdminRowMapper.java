package com.odyz.rowmapp;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.odyz.model.AdminModel;

public final class AdminRowMapper implements RowMapper<AdminModel> {

	@Override
	public AdminModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new AdminModel(rs.getInt("id"), rs.getString("userName"), rs.getString("pwd"));
	}

}
