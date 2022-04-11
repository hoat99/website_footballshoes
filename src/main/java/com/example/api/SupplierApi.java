package com.example.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.request.SupplierRequest;
import com.example.model.SupplierDatatablesModel;
import com.example.service.OrderService;
import com.example.service.SupplierService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin/supplier")
@RequiredArgsConstructor
public class SupplierApi {

	private final SupplierService supplierService;
	
	@GetMapping("/get-all")
	public SupplierDatatablesModel getSupplierDatatablesModel() {
		return this.supplierService.getSupplierDatatablesModel();
	}
	
	@PostMapping("/create")
	public void createSupplier(@RequestBody SupplierRequest supplierRequest) {
		this.supplierService.createSupplier(supplierRequest);
	}
	
	@PutMapping("/update")
	public void updateSupplier(@RequestBody SupplierRequest supplierRequest) {
		this.supplierService.updateSupplier(supplierRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		this.supplierService.deleteSupplier(id);
	}
	
}
