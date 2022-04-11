package com.example.api;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.request.DiscountCampaignRequest;
import com.example.model.DiscountCampaignModel;
import com.example.service.ArticleProductService;
import com.example.service.DiscountCampaignService;
import com.example.service.ImageService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin/discount-campaign")
@RequiredArgsConstructor
public class DiscountCampaignApi {

	private final DiscountCampaignService discountCampaignService;
	
	@GetMapping("/get-all")
	public DiscountCampaignModel getAllDiscountCampaign() {
	return	discountCampaignService.getAllDiscountCampaignModel();
	}
	
	@PostMapping("/create")
	public void createCampaign(DiscountCampaignRequest discountCampaignRequest, HttpServletResponse response) {
		System.out.println(discountCampaignRequest.getStartAt());

		this.discountCampaignService.createCampaign(discountCampaignRequest);
	}
	
	@PutMapping("/update")
	public void updateCampaign(DiscountCampaignRequest discountCampaignRequest, HttpServletResponse response) {
		this.discountCampaignService.updateCampaign(discountCampaignRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteCampaign(@PathVariable(name = "id") Long id, HttpServletResponse response) {
		this.discountCampaignService.deleteCampaign(id);
	}
}
