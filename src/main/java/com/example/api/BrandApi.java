package com.example.api;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.request.StrademarkRequest;
import com.example.entity.Strademark;
import com.example.entity.User;
import com.example.model.BrandDatatablesModel;
import com.example.model.CreateBrandRequest;
import com.example.service.StrademarkService;
import com.example.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin/brand")
@RequiredArgsConstructor
public class BrandApi {

	private final StrademarkService strademarkService;
	
	private final UserService userService;
	
	@GetMapping("find-all")
	public BrandDatatablesModel getAll() {
		return this.strademarkService.getAllStrademark();
	}
	
	@PostMapping("/create")
	public void createBrand( CreateBrandRequest createBrandRequest) throws IOException {
		System.out.println(createBrandRequest.getName());
		System.out.println(createBrandRequest.getImg());
		this.strademarkService.createBrand(createBrandRequest);
	}
	
	@PutMapping("/update")
	public void updateBrand(StrademarkRequest strademarkRequest) throws IOException {
		System.out.println(strademarkRequest.getIdStrademark());
		System.out.println(strademarkRequest.getName());
		System.out.println(strademarkRequest.getImg());
		this.strademarkService.updateStrademark(strademarkRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteBrand(@PathVariable(name = "id") Long id) {
		this.strademarkService.deleteStrademark(id);
	}
	
}
