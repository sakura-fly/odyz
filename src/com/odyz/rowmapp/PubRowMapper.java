package com.odyz.rowmapp;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.odyz.model.Pub;

public final class PubRowMapper implements RowMapper<Pub> {

	@Override
	public Pub mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Pub(rs.getInt("pid"), rs.getInt("userid"), rs.getString("uname"), rs.getString("pname"),
				rs.getString("pone"), rs.getString("ptwo"), rs.getDouble("price"), rs.getString("newold"),
				rs.getDate("pubtime"), rs.getString("RETAINTIME"), rs.getInt("staus"), rs.getString("pdesc"),
				rs.getString("pres"), rs.getString("pic1"), rs.getString("pic2"), rs.getString("pic3"),
				rs.getString("pic4"), rs.getString("pic5"),rs.getString("pic6"));
	}

}
