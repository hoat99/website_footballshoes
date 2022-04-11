package com.example.service;

import java.io.IOException;
import java.util.List;

import com.example.dto.request.ImageArticleRequest;
import com.example.dto.request.ImageRequest;
import com.example.entity.ImageArticle;
import com.example.model.ImageDatatablesModel;

public interface ImageService {

	void createImage(ImageRequest imageRequest) throws IOException;
	
	void createImageArticle(ImageArticleRequest imageArticleRequest) throws IOException;
	
	List<ImageArticle> getImageArticles();
	
	ImageDatatablesModel getImageDatatablesModel();
	
	void updateImage(ImageRequest imageRequest) throws IOException;
	
	void deleteImage(Long id);
}
