package com.example.service.iml;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dto.request.CourtyardDTO;
import com.example.dto.request.StrademarkDTO;
import com.example.entity.Courtyard;
import com.example.entity.Product;
import com.example.entity.Strademark;
import com.example.model.CourtyardDatatablesModel;
import com.example.repository.CourtyardRepository;
import com.example.service.CourtyardService;
import com.example.service.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourtyardServiceImpl implements CourtyardService{

	private final CourtyardRepository courtyardRepository;
	
	private final ProductService productService;
	
	@Override
	public List<Courtyard> getAllCourtyards() {
		return this.courtyardRepository.findAll();
	}

	@Override
	public List<CourtyardDTO> getAllCourtyardsDTO() {
		List<Courtyard> courtyards = this.courtyardRepository.findAll();
		List<CourtyardDTO> courtyardDTOs = new ArrayList<>();
		List<Product> products = this.productService.getAllProducts();
		for (int i=0 ; i<courtyards.size() ; i++) {
			Courtyard courtyard = courtyards.get(i);
			CourtyardDTO courtyardDTO =  CourtyardDTO.builder()
					.id(courtyard.getIdCourtyard()).type(courtyard.getType())
					.numberProduct(getNumberProducts(products,courtyard.getType()))
					.build();
			courtyardDTOs.add(courtyardDTO);
		}
		return courtyardDTOs;
	}
	
	public Integer getNumberProducts(List<Product> listProduct, String courtyard) {
		List<String> name = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < listProduct.size(); i++) {
			boolean flag = false;
			
			Product product = listProduct.get(i);
			if(product.getCourtyard().getType().compareTo(courtyard) == 0)
			{
			for (int j = 0; j < name.size(); j++) {
				if (product.getName().compareTo(name.get(j)) == 0) {
					flag = true;
					break;
				}
			}
			if (flag == false) {
				count++;
				name.add(product.getName());
			}}
		}
		return count;
	}

	@Override
	public CourtyardDatatablesModel getCourtyardDatatablesModel() {
		return CourtyardDatatablesModel.converter(this.courtyardRepository.findAll());
	}

}
