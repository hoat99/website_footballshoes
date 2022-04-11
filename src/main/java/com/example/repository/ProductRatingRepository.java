package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.ProductRating;

@Repository
public interface ProductRatingRepository extends JpaRepository<ProductRating, Long>{

	List<ProductRating> findByIdProduct(Long idProduct);
	
	@Query("select p from ProductRating p where p.idProduct = :idProduct and p.username = :username")
	ProductRating findOneByIdProductAndUsername(Long idProduct, String username);

	
}
