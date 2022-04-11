package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.Cart;
import com.example.entity.Product;

public interface CartRepository extends JpaRepository<Cart, Long>{

	List<Cart> findByUsername(String username);
	
	Optional<Cart> findByProduct(Product product);
	
	@Query("SELECT c FROM Cart c WHERE c.username = :username AND c.product = :product")
	Optional<Cart> findByUsernameAndProduct(String username, Product product);
}
