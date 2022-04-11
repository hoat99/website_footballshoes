package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.ArticleProduct;

@Repository
public interface ArticleProductRepository extends JpaRepository<ArticleProduct,Long>{

	@Query("select ap From ArticleProduct ap where ap.nameProduct like :nameProduct")
	Optional<ArticleProduct> findByNameProduct(String nameProduct);
	
	ArticleProduct findByIdArticleProduct(Long idArticleProduct);

	
}
