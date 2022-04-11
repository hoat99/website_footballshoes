package com.example.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.request.CreateImportGoodsRequest;
import com.example.model.HoaDonNhapDatatablesModel;
import com.example.service.ImportGoodsService;
import com.example.service.ProductService;
import com.example.service.StrademarkService;
import com.example.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin/import-goods")
@RequiredArgsConstructor
public class ImportGoodsApi {

	private final ImportGoodsService importGoodsService;
	
	@GetMapping("/get-all")
	HoaDonNhapDatatablesModel getHoaDonNhapDatatablesModel() {
		return this.importGoodsService.getHoaDonNhapDatatablesModel();
	}
	
	@PostMapping("/create")
	public void createGoodsReceived(@RequestBody CreateImportGoodsRequest createImportGoodsRequest) {
		this.importGoodsService.createGoodsReceived(createImportGoodsRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		this.importGoodsService.deleteCthdnAndHoaDonNhap(id);
	}
	
}
