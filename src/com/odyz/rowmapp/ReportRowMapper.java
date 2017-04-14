package com.odyz.rowmapp;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.odyz.model.ReportModel;

public final class ReportRowMapper implements RowMapper<ReportModel> {

	@Override
	public ReportModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new ReportModel(rs.getInt("id"), rs.getInt("userid"), rs.getInt("tipid"), rs.getString("tipmessage"),rs.getInt("tipstatus"),rs.getDate("tiptime"));
	}

}
