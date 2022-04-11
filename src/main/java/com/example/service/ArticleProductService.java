package com.example.service;

import java.util.Optional;

import com.example.dto.request.ArticleProductRequest;
import com.example.entity.ArticleProduct;
import com.example.model.ArticleProductDatatablesModel;

public interface ArticleProductService {

	void createArticle(ArticleProductRequest articleProductRequest);
	
	Optional<ArticleProduct>  getArticleProductByNameProduct(String nameProduct);
	
	ArticleProductDatatablesModel getArticleProductDatatablesModel();
	
	ArticleProduct getById(Long id);
	
	void updateArticle(ArticleProductRequest articleProductRequest);
	
	void deleteArticle(Long id);
}
