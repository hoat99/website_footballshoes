package com.example.service.iml;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.common.FileUtils;
import com.example.dto.request.ImageArticleRequest;
import com.example.dto.request.ImageRequest;
import com.example.entity.Image;
import com.example.entity.ImageArticle;
import com.example.model.ImageDatatablesModel;
import com.example.repository.ImageArticleRepository;
import com.example.repository.ImageRepository;
import com.example.service.ImageService;
import com.google.api.client.http.HttpRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

	private final ImageRepository imageRepository;

	private final ImageArticleRepository imageArticleRepository;

	private final HttpServletRequest request;

	@Value("${image.location}")
	private String location;

	@Override
	public void createImage(ImageRequest imageRequest) throws IOException {
		Image image = new Image();

		image.setNameProduct(imageRequest.getNameProduct());
		image.setAvatar(imageRequest.getAvatar());
		image.setImage1(imageRequest.getImage1());
		image.setImage2(imageRequest.getImage2());
		image.setImage3(imageRequest.getImage3());
		image.setImage4(imageRequest.getImage4());

//		if (imageRequest.getAvatar() != null) {
//			image.setAvatar(FileUtils.saveAvatar(imageRequest.getAvatar(), location, request));
//		}
//		if (imageRequest.getImage1() != null) {
//			image.setImage1(FileUtils.saveAvatar(imageRequest.getImage1(), location, request));
//
//		}
//		if (imageRequest.getImage2() != null) {
//			image.setImage2(FileUtils.saveAvatar(imageRequest.getImage2(), location, request));
//
//		}
//		if (imageRequest.getImage3() != null) {
//			image.setImage3(FileUtils.saveAvatar(imageRequest.getImage3(), location, request));
//
//		}
//		if (imageRequest.getImage4() != null) {
//			image.setImage4(FileUtils.saveAvatar(imageRequest.getImage4(), location, request));
//
//		}
		

		this.imageRepository.save(image);
	}

	@Override
	public void createImageArticle(ImageArticleRequest imageArticleRequest) throws IOException {
		ImageArticle imageArticle = new ImageArticle();
		imageArticle.setNameProduct(imageArticleRequest.getName());
//		imageArticle.setImg1(FileUtils.saveAvatar(imageArticleRequest.getImg1(), location, request));
//		imageArticle.setImg2(FileUtils.saveAvatar(imageArticleRequest.getImg2(), location, request));
//		imageArticle.setImg3(FileUtils.saveAvatar(imageArticleRequest.getImg3(), location, request));
//		imageArticle.setImg4(FileUtils.saveAvatar(imageArticleRequest.getImg4(), location, request));
//		imageArticle.setImg5(FileUtils.saveAvatar(imageArticleRequest.getImg5(), location, request));
//		imageArticle.setImg6(FileUtils.saveAvatar(imageArticleRequest.getImg6(), location, request));
		imageArticle.setImg1(imageArticleRequest.getImg1());
		imageArticle.setImg2(imageArticleRequest.getImg2());
		imageArticle.setImg3(imageArticleRequest.getImg3());
		imageArticle.setImg4(imageArticleRequest.getImg4());
		imageArticle.setImg5(imageArticleRequest.getImg5());
		imageArticle.setImg6(imageArticleRequest.getImg6());
		this.imageArticleRepository.save(imageArticle);
	}

	@Override
	public List<ImageArticle> getImageArticles() {
		return this.imageArticleRepository.findAll();
	}

	@Override
	public ImageDatatablesModel getImageDatatablesModel() {
		return ImageDatatablesModel.converter(this.imageRepository.findAll());
	}

	@Override
	public void updateImage(ImageRequest imageRequest) throws IOException {
		Image image = this.imageRepository.getById(imageRequest.getId());
		image.setNameProduct(imageRequest.getNameProduct());
		image.setAvatar(imageRequest.getAvatar());
		image.setImage1(imageRequest.getImage1());
		image.setImage2(imageRequest.getImage2());
		image.setImage3(imageRequest.getImage3());
		image.setImage4(imageRequest.getImage4());
//		if (imageRequest.getAvatar() != null) {
//			image.setAvatar(FileUtils.saveAvatar(imageRequest.getAvatar(), location, request));
//		}
//		if (imageRequest.getImage1() != null) {
//			image.setImage1(FileUtils.saveAvatar(imageRequest.getImage1(), location, request));
//
//		}
//		if (imageRequest.getImage2() != null) {
//			image.setImage2(FileUtils.saveAvatar(imageRequest.getImage2(), location, request));
//
//		}
//		if (imageRequest.getImage3() != null) {
//			image.setImage3(FileUtils.saveAvatar(imageRequest.getImage3(), location, request));
//
//		}
//		if (imageRequest.getImage4() != null) {
//			image.setImage4(FileUtils.saveAvatar(imageRequest.getImage4(), location, request));
//
//		}
		imageRepository.save(image);
	}

	@Override
	public void deleteImage(Long id) {
this.imageRepository.deleteById(id);		
	}

}
