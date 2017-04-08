package com.odyz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.odyz.model.UserModel;

public interface UserRepositpry extends JpaRepository<UserModel, Long>{
	
//	@Query(value="update olddeal_user set memberLevel = ?1 where uid = ?0")
//	public int closeUser(int uid,int stat);
}
