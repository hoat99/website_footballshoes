package com.example.service.iml;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.common.FileUtils;
import com.example.dto.request.BannerRequest;
import com.example.entity.Banner;
import com.example.entity.SelectedBanner;
import com.example.model.BannerDatatablesModel;
import com.example.repository.BannerRepository;
import com.example.repository.SelectedBannerRepository;
import com.example.service.BannerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BannerServiceImpl implements BannerService{
	
	private final BannerRepository bannerRepository;
	
    private final HttpServletRequest request;
    
    private final EntityManager entityManager;

    private final SelectedBannerRepository selectedBannerRepository;
    @Value("${image.location}")
    private String location;
	
	@Override
	@Transactional
	public void createBanner(BannerRequest bannerRequest) throws IOException {
		Banner banner = new Banner();
//		banner.setImg(FileUtils.saveAvatar(bannerRequest.getImg(), this.location, request));
		banner.setImg(bannerRequest.getImg());
		banner.setContent(bannerRequest.getContent());
		banner.setShortDescription(bannerRequest.getShortDescription());
		banner.setStatus("Not selected");
		this.bannerRepository.save(banner);
	}

	@Override
	@Transactional
	public void updateBanner(BannerRequest bannerRequest) throws IOException {
		Optional<Banner> optionalBanner = this.bannerRepository.findById(bannerRequest.getIdBanner());
		Banner banner = optionalBanner.get();
		banner.setIdBanner(bannerRequest.getIdBanner());
		banner.setShortDescription(bannerRequest.getShortDescription());
		banner.setContent(bannerRequest.getContent());
		if (bannerRequest.getImg() != null) {
//			banner.setImg(FileUtils.saveAvatar(bannerRequest.getImg(), this.location, request));
			banner.setImg(bannerRequest.getImg());
		}
		this.bannerRepository.save(banner)	;	
	}
	

	@Override
	public void deleteBanner(Long idBanner) {
		this.bannerRepository.deleteById(idBanner);
		
	}

	@Override
	public List<Banner> getAllBanner() {	
		return this.bannerRepository.findAll();
	}

	@Override
	public Banner getBannerByIds(Integer id) {
		// TODO Auto-generated method stub
		return  entityManager.find(Banner.class, id);
	}

	@Override
	public Banner getBannerById(Long idBanner) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Banner.class, idBanner);
	}

	@Override
	public void addSelectedBanner(Banner banner) {
		SelectedBanner selectedBanner = new SelectedBanner();
		selectedBanner.setId(banner.getIdBanner());
		selectedBanner.setContent(banner.getContent());
		selectedBanner.setShortDescription(banner.getShortDescription());
		selectedBanner.setImg(banner.getImg());
		selectedBannerRepository.save(selectedBanner);		
	}

	@Override
	public List<SelectedBanner> getSelectedBanner() {
		// TODO Auto-generated method stub
		return this.selectedBannerRepository.findAll();
	}

	@Transactional
	@Override
	public void changeStatus(Long idBanner) {
		this.bannerRepository.changeStatusNotSelected("Not selected");
		Banner banner = this.entityManager.find(Banner.class, idBanner);
		banner.setStatus("Selected");
		bannerRepository.save(banner);
		
	}

	@Transactional
	@Override
	public void changeStatus1(Long idBanner) {
		Banner banner = this.entityManager.find(Banner.class, idBanner);
		banner.setStatus("Not Selected");
		bannerRepository.save(banner);
		
	}

	@Override
	public void deleteSelectedBanner(Long idBanner) {
		Optional<SelectedBanner> selectedBanner = this.selectedBannerRepository.findById(idBanner);	
		if (selectedBanner.isPresent()) {
			this.selectedBannerRepository.deleteById(idBanner);
		}
	}

	@Override
	public BannerDatatablesModel getBannerDatatablesModel() {
		return BannerDatatablesModel.converter(this.bannerRepository.findAll());
	}

	@Override
	public Banner getBannerSelected() {
		return this.bannerRepository.getSelectedBanner();
	}







}
