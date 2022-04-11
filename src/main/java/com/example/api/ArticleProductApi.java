package com.example.api;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.request.ArticleProductRequest;
import com.example.dto.request.ImageArticleRequest;
import com.example.model.ArticleProductDatatablesModel;
import com.example.service.ArticleProductService;
import com.example.service.ImageService;
import com.example.service.StrademarkService;
import com.example.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin/article-product")
@RequiredArgsConstructor
public class ArticleProductApi {

	private final ArticleProductService articleProductService;
	
	private final ImageService imageService;
	
	@GetMapping("/get-all")
	public ArticleProductDatatablesModel getAllArticleProductDatatablesModel() {
		return this.articleProductService.getArticleProductDatatablesModel();
	}
	
	@PostMapping("/create")
	public void createArticle(ArticleProductRequest articleProductRequest) {
		this.articleProductService.createArticle(articleProductRequest);
	}
	
	@PutMapping("/update")
	public void updateArticle(ArticleProductRequest articleProductRequest) {
		this.articleProductService.updateArticle(articleProductRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteArticle(@PathVariable(name = "id") Long id) {
		this.articleProductService.deleteArticle(id);
	}
	
	@PostMapping("/create-image-article")
    public void createAmageArticle(ImageArticleRequest imageArticleRequest, HttpServletResponse response) throws IOException {
    	this.imageService.createImageArticle(imageArticleRequest);
    	response.addHeader("response", "success");
    }
}
