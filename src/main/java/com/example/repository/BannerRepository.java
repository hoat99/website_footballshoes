package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entity.Banner;
import com.example.entity.Product;

public interface BannerRepository extends JpaRepository<Banner, Long>{
	
	@Modifying
	@Query("update Banner b set b.status= :status where b.idBanner >= 0")
	void changeStatusNotSelected(@Param(value = "status") String status);
	
	@Query("select b from Banner b where b.status like 'Selected' ")
	Banner getSelectedBanner();
	
}
