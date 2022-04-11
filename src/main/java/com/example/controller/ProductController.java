package com.example.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.dto.request.ProductRequest;
import com.example.entity.Courtyard;
import com.example.entity.Product;
import com.example.entity.Strademark;
import com.example.service.CommonService;
import com.example.service.CourtyardService;
import com.example.service.ProductService;
import com.example.service.StrademarkService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;
	
	private final StrademarkService strademarkService;
	
	private final CommonService commonService;

	private final CourtyardService courtyardService;
	
	@GetMapping("/product")
	public String productPage(Model model) {
		List<Strademark> strademarks = this.strademarkService.getStrademarks();
		model.addAttribute("strademarks", strademarks);
		List<Courtyard> courtyards = this.courtyardService.getAllCourtyards();
		model.addAttribute("courtyards", courtyards);
		List<Product> products = this.productService.getAllProducts();
		model.addAttribute("products", products);
		this.commonService.getCommonObj(model);
		return "product";
	};
	
	@PostMapping("/create-product")
	public String createProduct(ProductRequest productRequest) {
		
		this.productService.createProduct(productRequest);
		return "redirect:/product";
	}
	
	
	
	@GetMapping("/update-product/{idProduct}")
	public String updateProductPage(@PathVariable(name = "idProduct") Long idProduct, Model model) {
		Product product = this.productService.getProductById(idProduct);
		model.addAttribute("product", product);
		List<Strademark> strademarks = this.strademarkService.getStrademarks();
		model.addAttribute("strademarks", strademarks);
		List<Courtyard> courtyards = this.courtyardService.getAllCourtyards();
		model.addAttribute("courtyards", courtyards);
		return "update-product";
	}
	
	@PostMapping("/update-product")
	public String updateProduct(ProductRequest productRequest) {
		this.productService.updateProduct(productRequest);
		return "redirect:/product";
	}
	
	@GetMapping("/delete-product/{idProduct}")
	public String deleteProduct(@PathVariable(name = "idProduct") Long idProduct) {
		this.productService.deleteProduct(idProduct);
		return "redirect:/product";
	}
}
