package com.example.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.OrderDetail;
import com.example.entity.ProductRating;

public interface OrderTestRepository extends JpaRepository<OrderDetail, Long>{
	
	List<OrderDetail> findByUsername(String username);

	List<OrderDetail> findByUsername(Sort by, String username);
	
//	@Query("select o from Order o where o.idProduct = :idProduct and o.username = :username")
//	Order findByIdProductAndUsername(Long idProduct, String username);
	
}
