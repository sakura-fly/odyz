package com.odyz.rowmapp;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.odyz.model.StuValidate;

public final class StudentRowMapper implements RowMapper<StuValidate> {

	@Override
	public StuValidate mapRow(ResultSet rs, int rowNum) throws SQLException {


		return new StuValidate(rs.getInt("userId"), rs.getString("stuSchool"), rs.getString("stuCollege"),
				rs.getString("stuNumber"), rs.getString("stuName"), rs.getString("stuImg"), rs.getInt("verifyStatus"));
	}

}
