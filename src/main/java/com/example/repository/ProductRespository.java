package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.Product;
import com.example.entity.Strademark;

public interface ProductRespository extends JpaRepository<Product, Long>{

	@Query("SELECT s.name, s.img FROM Strademark s WHERE s.idStrademark = :idStrademark")
	Optional<Strademark> findOneStrademark(Long idStrademark);
	
    @Query("from Product ")
    Slice<Product> getAllRecord(Pageable pageable);
    
    @Query("SELECT p FROM Product p WHERE p.name = :name")
    List<Product> getGroupProduct(String name);
    
    @Query("SELECT p FROM Product p WHERE p.nameRemovedAccent like :keyword")
    List<Product> searchProductByName(String keyword);
}
