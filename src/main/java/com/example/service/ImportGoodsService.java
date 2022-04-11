package com.example.service;

import com.example.dto.request.CreateImportGoodsRequest;
import com.example.model.HoaDonNhapDatatablesModel;

public interface ImportGoodsService {

	void createGoodsReceived(CreateImportGoodsRequest createImportGoodsRequest);
	
	HoaDonNhapDatatablesModel getHoaDonNhapDatatablesModel();
	
	void deleteCthdnAndHoaDonNhap(Long id);
}
