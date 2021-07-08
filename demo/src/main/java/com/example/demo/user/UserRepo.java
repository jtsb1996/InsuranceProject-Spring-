package com.example.demo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserClass, Integer>{

	@Query(value = "Select * from user_class uu where uu.first_name = ?1", nativeQuery = true)
	public UserClass getByName(String name);
	
	@Query(value = "Select * from user_class uu where uu.user_name = ?1", nativeQuery = true)
	public UserClass getByUserName(String username);
}
