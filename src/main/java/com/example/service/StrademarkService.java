package com.example.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.example.dto.request.StrademarkDTO;
import com.example.dto.request.StrademarkRequest;
import com.example.entity.Strademark;
import com.example.model.BrandDatatablesModel;
import com.example.model.CreateBrandRequest;

public interface StrademarkService {

	void createStrademark(StrademarkRequest strademarkRequest) throws IOException;
	
	void updateStrademark(StrademarkRequest strademarkRequest) throws IOException;
	
	void deleteStrademark(Long idStrademark);
	
	List<Strademark> getStrademarks();
	
	Strademark getStrademarkById(Long id);
	
	BrandDatatablesModel getAllStrademark();
	
	void createBrand(CreateBrandRequest createBrandRequest) throws IOException;
	
	Optional<StrademarkDTO> findOne(Long id);
	
	Optional<StrademarkDTO> ggga(Long id);
	
	List<StrademarkDTO> geStrademarksWithQuantityProduct();
}
