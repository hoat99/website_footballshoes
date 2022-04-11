package com.example.api;

import java.io.IOException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.request.BannerRequest;
import com.example.model.BannerDatatablesModel;
import com.example.service.ArticleProductService;
import com.example.service.BannerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin/banner")
@RequiredArgsConstructor
public class BannerApi {

	private final BannerService bannerService;
	
	@GetMapping("/get-all")
	public BannerDatatablesModel getBannerDatatablesModel() {
		return this.bannerService.getBannerDatatablesModel();
	}
	
	@PostMapping("/create")
	public void createBanner(BannerRequest bannerRequest) throws IOException {
		this.bannerService.createBanner(bannerRequest);
	}
	
	@PutMapping("/update")
	public void updateBanner(BannerRequest bannerRequest) throws IOException {
		this.bannerService.updateBanner(bannerRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteBanner(@PathVariable(name = "id") Long id){
		this.bannerService.deleteBanner(id);
	}
	
	@PutMapping("/change-status/{id}")
	public void changeStatusBanner(@PathVariable(name = "id") Long id){
		this.bannerService.changeStatus(id);
	}
	
}
