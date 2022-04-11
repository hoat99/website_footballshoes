package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.Subscribers;

public interface SubscribersRepository extends JpaRepository<Subscribers, Long>{

	@Query("Select s from Subscribers s where s.email like :email")
	Subscribers getSubscribersByEmail(String email);
	

	
}
