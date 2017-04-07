package com.odyz.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odyz.model.AdminModel;

public interface AdminRepositoyr extends JpaRepository<AdminModel, Long>{
	public AdminModel findByUserNameAndPwd(String uname,String pwd);
}
