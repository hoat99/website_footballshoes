package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Image;

public interface ImageRepository extends JpaRepository<Image, Long>{

	Optional<Image> findByNameProduct(String nameProduct);
	
}
