package com.example.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.dto.request.ShopDTO;
import com.example.entity.Banner;
import com.example.entity.Product;
import com.example.service.BannerService;
import com.example.service.CommonService;
import com.example.service.ProductService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SearchProductController {

	private final ProductService productService;

	private final CommonService commonService;
	
	private final BannerService bannerService;
	
	@GetMapping("/search")
	public String searchPage(Model model,
			@RequestParam(name = "pageNumber", required = false) Optional<Integer> pageNumber,
			@RequestParam(name = "pageSize", required = false) Optional<Integer> pageSize,
			@RequestParam(name = "keyword", required = false) Optional<String> keyword) {

		model.addAttribute("title", "Tìm kiếm sản phẩm");
		String keywordForSearch = this.commonService.removeAccent(keyword.orElse(""));

		model.addAttribute("title", "Demo JPA-Hibernate");
		List<ShopDTO> products = this.productService.productFound("%" + keywordForSearch + "%",
				pageNumber.orElseGet(() -> 1) - 1, pageSize.orElse(10));
		List<ShopDTO> productShow = this.productService.getShowProducts(products);
		model.addAttribute("products", productShow);
		int numberOfPage = this.productService.getNumberOfPage2(pageSize.orElse(10), "%" + keywordForSearch + "%");
		List<Integer> paginationList = IntStream.rangeClosed(1, numberOfPage).boxed().collect(Collectors.toList());
		model.addAttribute("paginationList", paginationList);
		model.addAttribute("activePage", pageNumber.orElseGet(() -> 1));
		model.addAttribute("pageSize", pageSize.orElse(10));
		String notFound = null;
		if (products.isEmpty()) {
			notFound = "Không có kết quả!";
		}
		model.addAttribute("selectedBanner", this.bannerService.getBannerSelected());
		model.addAttribute("notFound", notFound);
		model.addAttribute("keyword", keyword.orElse(""));
		this.commonService.getCommonObj(model);
		return "user/search";
	}

	@PostMapping("/search-product")
	public String searchProduct(@RequestParam(name = "keyword", required = false) String keyword,
			RedirectAttributes redirectAttributes) {
		redirectAttributes.addAttribute("keyword", keyword);
		return "redirect:/search";
	}
}
