package com.example.service.iml;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.dto.request.ArticleProductRequest;
import com.example.entity.ArticleProduct;
import com.example.model.ArticleProductDatatablesModel;
import com.example.repository.ArticleProductRepository;
import com.example.service.ArticleProductService;

@Service
@RequiredArgsConstructor
public class ArticleProductServiceImpl implements ArticleProductService {

	private final ArticleProductRepository articleProductRepository;

	@Override
	public void createArticle(ArticleProductRequest articleProductRequest) {
		ArticleProduct articleProduct = new ArticleProduct();
		articleProduct.setNameProduct(articleProductRequest.getNameProduct());
		articleProduct.setContent(articleProductRequest.getContent());
		articleProductRepository.save(articleProduct);
	}

	@Override
	public Optional<ArticleProduct> getArticleProductByNameProduct(String nameProduct) {
		return this.articleProductRepository.findByNameProduct(nameProduct);
	}

	@Override
	public ArticleProductDatatablesModel getArticleProductDatatablesModel() {
		return ArticleProductDatatablesModel.converter(this.articleProductRepository.findAll());
	}

	@Override
	public ArticleProduct getById(Long id) {
		// TODO Auto-generated method stub
		return this.articleProductRepository.findByIdArticleProduct(id);
	}

	@Override
	public void updateArticle(ArticleProductRequest articleProductRequest) {
		ArticleProduct articleProduct = this.articleProductRepository
				.findByIdArticleProduct(articleProductRequest.getId());
		articleProduct.setNameProduct(articleProductRequest.getNameProduct());
		articleProduct.setContent(articleProductRequest.getContent());
		articleProductRepository.save(articleProduct);

	}

	@Override
	public void deleteArticle(Long id) {
		this.articleProductRepository.deleteById(id);
	}

}
