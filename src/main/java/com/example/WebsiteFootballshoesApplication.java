package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.repository.ProductRespository;
import com.example.service.CommonService;
import com.example.service.ProductService;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class WebsiteFootballshoesApplication implements CommandLineRunner {

	private final ProductService productService;
	
	private final ProductRespository productRespository;
	
	private final CommonService commonService;
	
	public static void main(String[] args) {
		SpringApplication.run(WebsiteFootballshoesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		productService.getAllProducts().forEach(product -> {
//			String removedAccent = commonService.removeAccent(product.getName());
//			product.setNameRemovedAccent(removedAccent);
//			productRespository.save(product);
//		});		
	}

	
}
