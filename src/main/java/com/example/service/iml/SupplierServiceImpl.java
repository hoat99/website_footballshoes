package com.example.service.iml;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dto.request.SupplierRequest;
import com.example.entity.Supplier;
import com.example.model.SupplierDatatablesModel;
import com.example.repository.SupplierRepository;
import com.example.service.SupplierService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

	private final SupplierRepository supplierRepository;

	@Override
	public void createSupplier(SupplierRequest supplierRequest) {
		Supplier supplier = new Supplier();
		supplier.setName(supplierRequest.getName());
		supplier.setDescription(supplierRequest.getDescription());
		supplierRepository.save(supplier);
	}

	@Override
	public void updateSupplier(SupplierRequest supplierRequest) {
		Supplier supplier = this.supplierRepository.getById(supplierRequest.getId());
		supplier.setName(supplierRequest.getName());
		supplier.setDescription(supplierRequest.getDescription());
		supplierRepository.save(supplier);
	}

	@Override
	public void deleteSupplier(Long id) {
this.supplierRepository.deleteById(id);
	}

	@Override
	public SupplierDatatablesModel getSupplierDatatablesModel() {
		return SupplierDatatablesModel.converter(this.supplierRepository.findAll());
	}

	@Override
	public List<Supplier> getAll() {
		// TODO Auto-generated method stub
		return this.supplierRepository.findAll();
	}

}
