package com.odyz.rowmapp;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.odyz.model.StuValidate;

public final class StudentRowMapper implements RowMapper<StuValidate> {

	@Override
	public StuValidate mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new StuValidate(rs.getInt("stuNumber"), rs.getString("stuSchool"), rs.getString("stuName"),rs.getInt("stuCollege"),rs.getInt("stuId"),rs.getString("stuPic"),rs.getInt("stuStat"));
	}

}
