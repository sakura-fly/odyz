package com.odyz.rowmapp;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.odyz.model.UserModel;

public class UserRowMapp implements RowMapper<UserModel> {
	@Override
	public UserModel mapRow(ResultSet rs, int arg1) throws SQLException {
		return new UserModel(rs.getInt("uid"), rs.getString("uname"), rs.getString("upwd"), rs.getString("corfirmupwd"),
				rs.getString("QQ"), rs.getString("safe"), rs.getString("answer"), rs.getInt("integral"),
				rs.getInt("memberLevel"), rs.getString("headImg"));
	}

}
