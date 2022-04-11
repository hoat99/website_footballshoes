package com.example.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

	@Query("select u from User u where u.email = :email")
	public User findByEmail(@Param("email") String email);
	
	public User findByResetPasswordToken(String token);
	
	@Query("SELECT u FROM User u WHERE u.verificationCode = ?1")
    public User findByVerificationCode(String code);
}
