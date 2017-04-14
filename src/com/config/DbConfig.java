package com.config;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.util.DbConstanst;

@Configuration
@ComponentScan(basePackages={"com.odyz.dao"})
public class DbConfig {

	@Bean
	public DataSource dataSource() {

		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(DbConstanst.DBDRIVER);
		ds.setUrl(DbConstanst.DBURL);
		ds.setUsername(DbConstanst.USERNAME);
		ds.setPassword(DbConstanst.PWD);
		return ds;
	}
	
	
	@Bean
	public JdbcTemplate jdbc(DataSource dataSource){
		return new JdbcTemplate(dataSource);
	}
	
	
	

}