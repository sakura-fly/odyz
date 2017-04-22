package com.odyz.rowmapp;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.odyz.model.ReportModel;

public final class ReportRowMapper implements RowMapper<ReportModel> {

	@Override
	public ReportModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new ReportModel(rs.getInt("rid"),rs.getString("tipName"),rs.getString("uname"),rs.getString("pname"),
				rs.getString("reason"),rs.getTimestamp("tipTime"),rs.getInt("tipStatus"));    
	}

}
