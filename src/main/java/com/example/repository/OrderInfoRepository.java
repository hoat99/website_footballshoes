package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.OrderInfo;
import com.example.entity.OrderInfoID;
import com.example.entity.ProductRating;

@Repository
public interface OrderInfoRepository extends JpaRepository<OrderInfo, OrderInfoID>{

	@Query(value = "SELECT * FROM order_info o WHERE o.id_order = :idOrder", nativeQuery = true)
	List<OrderInfo> findByIdOrder(@Param("idOrder") Long idOrder);
	
}
