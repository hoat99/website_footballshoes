package com.example.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.example.dto.request.BannerRequest;
import com.example.dto.response.BannerResponse;
import com.example.entity.Banner;
import com.example.entity.SelectedBanner;
import com.example.model.BannerDatatablesModel;
import com.example.repository.SelectedBannerRepository;

public interface BannerService {

	void createBanner(BannerRequest bannerRequest) throws IOException;
	
	void updateBanner(BannerRequest bannerRequest) throws IOException;
	
	void deleteBanner(Long idBanner);
	
	void changeStatus(Long idBanner);
	void changeStatus1(Long idBanner);
	
    Banner getBannerById(Long idBanner);
	
    Banner getBannerByIds(Integer id);
    
	List<Banner> getAllBanner();
	

	void addSelectedBanner(Banner banner);
	
	List<SelectedBanner> getSelectedBanner();
	
	void deleteSelectedBanner(Long idBanner);
	
	BannerDatatablesModel getBannerDatatablesModel();
	
	Banner getBannerSelected();
}
