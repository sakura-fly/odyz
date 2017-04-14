package com.config;


import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;

import com.util.DbConstanst;

@Configuration
@EnableJpaRepositories(basePackages = "com.odyz.dao")
public class DbConfig {

//	@Bean
//	public DataSource dataSource() {
//
//		BasicDataSource ds = new BasicDataSource();
//		ds.setDriverClassName(DbConstanst.DBDRIVER);
//		ds.setUrl(DbConstanst.DBURL);
//		ds.setUsername(DbConstanst.USERNAME);
//		ds.setPassword(DbConstanst.PWD);
//		return ds;
//	}

//	@Bean
//	public HibernateJpaVendorAdapter jpaVendorAdapter() {
//		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
//		adapter.setDatabase(Database.MYSQL);
//		adapter.setShowSql(false);
//		adapter.setGenerateDdl(true);
//		return adapter;
//	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
			) {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(DbConstanst.DBDRIVER);
		ds.setUrl(DbConstanst.DBURL);
		ds.setUsername(DbConstanst.USERNAME);
		ds.setPassword(DbConstanst.PWD);
		
		EclipseLinkJpaVendorAdapter adapter = new EclipseLinkJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setShowSql(false);
		adapter.setGenerateDdl(true);
		
		LocalContainerEntityManagerFactoryBean embf = new LocalContainerEntityManagerFactoryBean();
		embf.setPersistenceUnitName("odyz");
		embf.setJpaVendorAdapter(adapter);
		embf.setDataSource(ds);
		embf.setPackagesToScan("com.odyz.model");
		return embf;
	}
}
