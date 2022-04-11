package com.example.service;

import java.util.List;

import com.example.dto.request.SupplierRequest;
import com.example.entity.Supplier;
import com.example.model.BrandDatatablesModel;
import com.example.model.SupplierDatatablesModel;

public interface SupplierService {
	SupplierDatatablesModel getSupplierDatatablesModel();

	void createSupplier(SupplierRequest supplierRequest);
	void updateSupplier(SupplierRequest supplierRequest);
	void deleteSupplier(Long id);
	
	List<Supplier> getAll();
	
}
