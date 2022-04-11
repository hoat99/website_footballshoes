package com.example.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.dto.request.BannerRequest;
import com.example.dto.request.ImageArticleRequest;
import com.example.dto.request.LoginRequest;
import com.example.dto.request.RegisterRequest;
import com.example.dto.request.ShopDTO;
import com.example.dto.request.StrademarkRequest;
import com.example.dto.response.BannerResponse;
import com.example.entity.Banner;
import com.example.entity.Courtyard;
import com.example.entity.Product;
import com.example.entity.SelectedBanner;
import com.example.entity.Strademark;
import com.example.entity.User;
import com.example.repository.BannerRepository;
import com.example.security.user.CustomUserDetail;
import com.example.service.AuthenService;
import com.example.service.BannerService;
import com.example.service.CommonService;
import com.example.service.CourtyardService;
import com.example.service.ImageService;
import com.example.service.ProductService;
import com.example.service.StrademarkService;
import com.example.service.UserService;

import lombok.RequiredArgsConstructor;
import net.bytebuddy.asm.Advice.This;

@Controller
@RequiredArgsConstructor
public class BaseController {

	private final AuthenService authenService;
	
	private final BannerService bannerService;
	
	private final StrademarkService strademarkService;
	
	private final ProductService productService;
	
	private final CourtyardService courtyardService;
		
	private final CommonService commonService;
	
	private final BannerRepository bannerRepository;
	
	private final UserService userService;
	
	private final ImageService imageService;
	
	
	@GetMapping("/")
    public String index(Model model) {
		model.addAttribute("selectedBanner", this.bannerService.getBannerSelected());
		model.addAttribute("popularProducts", this.productService.getPopularProduct());
		model.addAttribute("lastestProducts", this.productService.getLastestProduct());
		this.commonService.getCommonObj(model);

        return "user/index";
    }

    @GetMapping("/login")
    public String loginPage(Model model,RegisterRequest registerRequest) {
        model.addAttribute("googleAuthorization", "/oauth2/authorization/google");
        model.addAttribute("facebookAuthorization", "/oauth2/authorization/facebook");
        return "user/login";
    }

    @GetMapping("/register")
    public String registerPage(Model model,RegisterRequest registerRequest) {
    	model.addAttribute("googleAuthorization", "/oauth2/authorization/google");
        model.addAttribute("facebookAuthorization", "/oauth2/authorization/facebook");
        return "user/register-user";
    }
    
    @PostMapping("/register")
    public String doRegister(HttpServletRequest request, Model model, @Valid RegisterRequest registerRequest, BindingResult bindingResult) throws UnsupportedEncodingException, MessagingException {
        if (bindingResult.hasErrors()) {
            return "user/register-user";
        }
        
        if (this.authenService.checkUserExist(registerRequest.getUsername())) {
        	model.addAttribute("existUser", "Tên này đã tồn tại, hãy nhập tên khác!");
			return "user/register-user";
		}
        if (this.userService.checkExistsEmail(registerRequest.getEmail())) {
        	model.addAttribute("existEmail", "Email đã tồn tại, hãy sử dụng email khác!");
			return "user/register-user";
		}
        String URL = (request.getRequestURL().toString().toString()).replace(request.getServletPath(), "");
        authenService.registerUser(request, model, registerRequest, URL);
        System.out.println(registerRequest);
        return "user/register_success";
    }
    
    @GetMapping("/verify")
    public String verifyUser(@Param("code") String code) {
        if (userService.verify(code)) {
            return "user/verify_success";
        } else {
            return "user/verify_fail";
        }
    }
    
    @GetMapping("/profile")
    public String profilePage(Principal principal, Model model) {
    	if (principal != null) {
    		User user = this.userService.getUser(principal.getName());
    		model.addAttribute("user", user);
			return "user/profile";
		}
    	return "redirect:/";
    }
   	
    @PostMapping("/update-password")
    public String updatePassword(@RequestParam("oldPassword") String oldPassword,
    		@RequestParam("username1") String username,
    		@RequestParam("newPassword") String newPassword, RedirectAttributes ra) {
    	
    	
    	System.out.println(oldPassword);
    	System.out.println(username);
    	System.out.println(newPassword);
    	
    		this.userService.changePassword(username, oldPassword, newPassword,ra);
    	
    		return "redirect:/profile";
    		}
    
//    @ResponseBody
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    @GetMapping("/pre-authorize")
//    public String preAuthorize() {
//        return "API này chỉ Admin mới được truy cập!";
//    }
//    
//    @ResponseBody
//    @GetMapping("/get-user-info")
//    public Object getUserBySpringSecurity(HttpServletRequest request) {
////        User user = (User) ((Authentication) request.getUserPrincipal()).getPrincipal();
//        return SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof CustomUserDetail;
//    }

    @ResponseBody
    @GetMapping("/oauth2-username")
    public Map<String, Object> username(@AuthenticationPrincipal OAuth2User principal) {
        return Collections.singletonMap("name", principal.getAttribute("name"));
    }

    @ResponseBody
    @GetMapping("/oauth2-user")
    public OAuth2User user(@AuthenticationPrincipal OAuth2User principal) {
        return principal;
    }
    
    
             
    @GetMapping("/huong-dan-mua-hang")
    public String huongDanMuaHangPage(Model model){
    	this.commonService.getCommonObj(model);
    	return "user/huong-dan-mua-hang";
    }
    @GetMapping("/chinh-sach-van-chuyen")
    public String chinhSachVanChuyenPage(Model model){
    	this.commonService.getCommonObj(model);
    	return "user/chinh-sach-van-chuyen";
    }
    @GetMapping("/chinh-sach-bao-hanh")
    public String chinhSachBaoHanhPage(Model model){
    	this.commonService.getCommonObj(model);
    	return "user/chinh-sach-bao-hanh";
    }
    @GetMapping("/quy-dinh-doi-tra")
    public String quyDinhDoiTraPage(Model model){
    	this.commonService.getCommonObj(model);
    	return "user/quy-dinh-doi-tra";
    }
    @GetMapping("/cach-chon-size")
    public String cachChonSizePage(Model model){
    	this.commonService.getCommonObj(model);
    	return "user/cach-chon-size";
    }
       
    @GetMapping("/about")
    public String aboutPage(Model model) {
    	model.addAttribute("title", "About");
    	return "user/about";
    }
    
    @GetMapping("/thankyou")
    public String thankyouPage(Model model) {
    	model.addAttribute("title", "Cảm ơn");
    	return "user/thankyou";
    }
}
