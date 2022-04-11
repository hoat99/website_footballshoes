package com.example.controller;

import java.math.BigDecimal;
import java.security.Principal;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.example.dto.request.CartRequest;
import com.example.dto.request.UpdateCartRequest;
import com.example.entity.Banner;
import com.example.entity.Cart;
import com.example.entity.Product;
import com.example.service.CartService;
import com.example.service.CommonService;
import com.example.service.ProductService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CartController {

	private final CartService cartService;
	
	private final ProductService productService;
	
	private final CommonService commonService;
	
	@GetMapping("/cart")
	public String cartPage(Principal principal, Model model, @ModelAttribute(name =  "outOfQuantity") String outOfQuantity) {
		this.commonService.getCommonObj(model);
		if (principal == null) {
			String notFoundProduct = "<a href=" + "/shop" +">Giỏ hàng rỗng, hãy quay lại mua hàng </a>";
			model.addAttribute("notFoundProduct", notFoundProduct);
			return "user/cart";
		}
		
		List<Cart> carts = this.cartService.getAllCart(principal.getName());
		if (carts.isEmpty()) {
			String notFoundProduct = "<a href=" + "/shop" +">Giỏ hàng rỗng, hãy quay lại mua hàng </a>";
			model.addAttribute("notFoundProduct", notFoundProduct);
			return "user/cart";
		}	
		Long subtotal1 =(long) 0;
		for (Cart cart : carts) {
			subtotal1 = subtotal1 + cart.getQuantity() * cart.getCost().longValue();
		}
		BigDecimal subtotal2 = BigDecimal.valueOf(subtotal1);
		
		Locale localeVN = new Locale("vi", "VN");
	    NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
	    
	    String subtotal = currencyVN.format(subtotal2);
	    	    
		model.addAttribute("carts", carts);
		model.addAttribute("subtotal", subtotal);
		model.addAttribute("outOfQuantity", outOfQuantity);
		
		return "user/cart";		
	}
	
//	@GetMapping("/add-to-cart/{idProduct}")
//    public String updateBannerPage(@PathVariable(name = "idProduct") Long idProduct, Model model,Principal principal,CartRequest cartRequest) {
//    	Product product = this.productService.getProductById(idProduct);
//    	model.addAttribute("product", product);
//    	String username = principal.getName();
//    	model.addAttribute("username", username);
//    	return "user/add-to-cart";
//    };
    
	
//	@PostMapping("/add-to-cart")
//	public String addToCart(Principal principal,CartRequest cartRequest) {
//			this.cartService.addProductToCart2(cartRequest, principal.getName());
//			return "redirect:/cart";			
//	}
	
	@PostMapping("/update-cart")
	public String updateCart(@RequestBody UpdateCartRequest cartRequest, Model model, RedirectAttributes redirectAttributes) {
		this.cartService.updateCart(cartRequest);
		return "redirect:/cart";		
	}
	

	
	@GetMapping("/cart1")
	public String ajfaj(@ModelAttribute(name = "outOfQuantity") String outOfQuantity, Model model) {
		model.addAttribute("outOfQuantity", outOfQuantity);
		return "user/cart1";
	}
	
//	@GetMapping("/delete-cart/{idCart}")
//	public String updateCart(@PathVariable(name = "idCart") Long idCart) {
//		this.cartService.deleteCart(idCart);		
//		return "user/cart";	
//	}

}
