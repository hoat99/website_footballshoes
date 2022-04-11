package com.example.controller;

import lombok.RequiredArgsConstructor;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dto.request.CourtyardDTO;
import com.example.dto.request.ShopDTO;
import com.example.dto.request.StrademarkDTO;
import com.example.entity.ArticleProduct;
import com.example.entity.Courtyard;
import com.example.entity.Product;
import com.example.entity.SelectedBanner;
import com.example.entity.Strademark;
import com.example.service.ArticleProductService;
import com.example.service.BannerService;
import com.example.service.CommonService;
import com.example.service.CourtyardService;
import com.example.service.ProductService;
import com.example.service.StrademarkService;

@Controller
@RequiredArgsConstructor
public class ShopController {

	private final ProductService productService;
	
	private final BannerService bannerService;
	
	private final StrademarkService strademarkService;
	
	private final CourtyardService courtyardService;
	
	private final CommonService commonService;

	private final ArticleProductService articleProductService;
	@GetMapping("/shop")
    public String shopPage(Model model, @RequestParam(name = "pageNumber", required = false) Optional<Integer> pageNumber,
			@RequestParam(name = "pageSize", required = false) Optional<Integer> pageSize,
			@RequestParam(name = "option", required =  false) Optional<String> option,
			@RequestParam(name = "strademark", required = false) Optional<String> strademark,
			@RequestParam(name = "courtyard", required = false) Optional<String> courtyard)  {
		this.commonService.getCommonObj(model);
    	String opt = option.orElse("");
    	List<ShopDTO> products = null;
    	boolean isEmty = true;
    	/**
    	 * Các option
    	 * 1.Mặc định
    	 * 2.Sắp xếp theo giá tăng dần
    	 * 3.Sắp xếp theo giá giảm dần
    	 * */
    	switch (opt) {
		case "":
			products = this.productService.getProductByPage(pageNumber.orElseGet(() -> 1) - 1, pageSize.orElse(30));
			break;
		case "lowToHigh":
			products = this.productService.getSortedProductByPage(pageNumber.orElseGet(() -> 1) - 1, pageSize.orElse(30),"lowToHigh","%" + strademark.orElse("") + "%","%" + courtyard.orElse("") + "%");
			break;
		case "highToLow":
			products = this.productService.getSortedProductByPage(pageNumber.orElseGet(() -> 1) - 1, pageSize.orElse(30),"highToLow","%" + strademark.orElse("") + "%","%" + courtyard.orElse("") + "%");
			break;
		case "search":
			products = this.productService.getFoundedProductByPage(pageNumber.orElseGet(() -> 1) - 1, pageSize.orElse(30),"%" + strademark.orElse("") + "%","%" + courtyard.orElse("") + "%");
			if (products.isEmpty()) isEmty = false;
			break;
		case "lastest":
			products = this.productService.getSortOnTimeProduct(pageNumber.orElseGet(() -> 1) - 1, pageSize.orElse(30),"lastest");
			break;
		case "oldest":
			products = this.productService.getSortOnTimeProduct(pageNumber.orElseGet(() -> 1) - 1, pageSize.orElse(30),"oldest");
			break;
		default:
			break;
		}
    	List<ShopDTO> productShow = this.productService.getShowProducts(products);
		System.out.println(productShow);

    	model.addAttribute("products", productShow);
		int numberOfPage = this.productService.getNumberOfPage(pageSize.orElse(30),"%" + strademark.orElse("") + "%","%" + courtyard.orElse("").toString() + "%");
		List<Integer> paginationList = IntStream.rangeClosed(1, numberOfPage).boxed().collect(Collectors.toList());
		model.addAttribute("paginationList", paginationList);
		model.addAttribute("activePage", pageNumber.orElseGet(() -> 1));
		model.addAttribute("pageSize", pageSize.orElse(30));
		List<SelectedBanner> selectedBanners = this.bannerService.getSelectedBanner();
		model.addAttribute("selectedBanners", selectedBanners);	
		model.addAttribute("isEmty", isEmty);
		List<StrademarkDTO> strademarkDTOs = this.strademarkService.geStrademarksWithQuantityProduct();
		model.addAttribute("strademarkDTOs", strademarkDTOs);
		List<CourtyardDTO> courtyardDTOs = this.courtyardService.getAllCourtyardsDTO();
		model.addAttribute("courtyardDTOs", courtyardDTOs);
		model.addAttribute("option", opt);
		model.addAttribute("strademark", strademark.orElse(""));
		model.addAttribute("courtyard", courtyard.orElse(""));
    	return "user/shop";
    }
	
	@GetMapping("/shop-single/{id}")
	public String getProduct(@PathVariable(name = "id") Long id,Model model, Principal principal) {
		Product product = this.productService.getProductById(id);
		model.addAttribute("product", product);
		Optional<ArticleProduct> articleProduct = this.articleProductService.getArticleProductByNameProduct(product.getName());
		model.addAttribute("articleProduct", articleProduct.orElse(null));
		List<Product> productGroups = this.productService.getGroupProducts(product.getName(), id);
		model.addAttribute("productGroups", productGroups);
		
		List<ShopDTO> products = this.productService.getReferenceProducts(product.getStrademark().getName());
		List<ShopDTO> productShow = this.productService.getShowProducts(products);
		List<ShopDTO> products1 = new ArrayList<>();
		for ( int i=0 ; i<productShow.size() ; i++) {
			products1.add(productShow.get(i));
			if (i == 5) {
				break;
			}
		}
		model.addAttribute("products1", products1);
		
		Integer statusQuantity = 0;
		for (Product product2 : productGroups) {
			if (product2.getQuantity() != 0) {
				statusQuantity = 1;
			}		
		}
		model.addAttribute("statusQuantity", statusQuantity);
		
		String username = null;	
		if (principal != null) {
			username = principal.getName();
		}
		model.addAttribute("username", username);
		this.commonService.getCommonObj(model);
		return "user/shop-single";
	}
}
