package com.example.api;

import com.example.dto.request.BannerRequest;
import com.example.dto.request.ShopDTO;
import com.example.dto.request.StrademarkDTO;
import com.example.dto.request.UserProfileRequest;

import com.example.dto.response.UserProfileResponse;
import com.example.entity.OrderDetail;
import com.example.entity.Product;
import com.example.entity.Strademark;
import com.example.service.BannerService;
import com.example.service.OrderService;
import com.example.service.ProductService;
import com.example.service.StrademarkService;
import com.example.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProfileApi {

    private final UserProfileService userProfileService;
    
    private final BannerService bannerService;
    
    private final ProductService productService;
    
    private final StrademarkService strademarkService;

    private final OrderService orderService;
    
    @GetMapping("user-profile")
    public UserProfileResponse getUserProfile() {
        return this.userProfileService.getUserProfile();
    }

    @PostMapping("/create_banner")
    public void updateProfile(@Valid BannerRequest bannerRequest) throws IOException {
        this.bannerService.createBanner(bannerRequest);
    }

    @GetMapping("/product/get-all")
    public List<Product> getProduct() {
        return this.productService.getAllProducts();
    }
    
    @GetMapping("/strade/get-all")
    public List<Strademark> ggg() {
        return this.strademarkService.getStrademarks();
    }
    
    @GetMapping("/strade/get-one")
    public Optional<StrademarkDTO> g(@RequestParam(name = "id") Long id) {
        return this.strademarkService.findOne(id);
    }
    
    @GetMapping("/strade/get")
    public Optional<StrademarkDTO> ga(@RequestParam(name = "id") Long id) {
        return this.strademarkService.ggga(id);
    }

    
   
}
