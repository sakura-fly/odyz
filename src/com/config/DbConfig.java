package com.config;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;

import com.util.DbConstanst;

@Configuration
@ComponentScan(basePackages={"com.odyz.dao"})
//@EnableJpaRepositories(basePackages = "com.odyz.dao")
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
	
	
	

//	@Bean
//	public JpaVendorAdapter jpaVendorAdapter() {
//		EclipseLinkJpaVendorAdapter adapter = new EclipseLinkJpaVendorAdapter();
//		adapter.setDatabase(Database.MYSQL);
//		adapter.setShowSql(false);
//		adapter.setGenerateDdl(true);
//		return adapter;
//	}
//
//	@Bean
//	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource datasource,
//			JpaVendorAdapter va) {
//		LocalContainerEntityManagerFactoryBean embf = new LocalContainerEntityManagerFactoryBean();
//		embf.setPersistenceUnitName("odyz");
//		embf.setJpaVendorAdapter(va);
//		embf.setDataSource(datasource);
//		embf.setPackagesToScan("com.odyz.model");
////		embf.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());  
//		return embf;
//	}
}
