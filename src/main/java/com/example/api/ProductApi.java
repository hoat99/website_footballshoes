package com.example.api;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.request.ProductRequest;
import com.example.dto.request.ShopDTO;
import com.example.dto.request.StrademarkRequest;
import com.example.model.ProductDatatablesModel;
import com.example.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/admin/product")
@RequiredArgsConstructor
@RestController
public class ProductApi {

	private final ProductService productService;
	
	@GetMapping("/get-all")
	public ProductDatatablesModel getAllProduct() {
		return this.productService.getProductDatatablesModel();
	}

	@PostMapping("/create")
	public void createProduct(@RequestBody ProductRequest productRequest) {
		System.out.println(productRequest);
		this.productService.createProduct(productRequest);
	}
	
	@PutMapping("/update")
	public void updateProduct(@RequestBody ProductRequest productRequest) throws IOException {
		System.out.println(productRequest);
		this.productService.updateProduct(productRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteProduct(@PathVariable(name = "id") Long id) {
		this.productService.deleteProduct(id);
	}
	
}
