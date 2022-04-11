package com.example.controller;

import java.io.IOException;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dto.request.ImageArticleRequest;
import com.example.entity.ArticleProduct;
import com.example.entity.Courtyard;
import com.example.entity.Cthdn;
import com.example.entity.ImageArticle;
import com.example.entity.Order;
import com.example.entity.OrderInfo;
import com.example.entity.Strademark;
import com.example.entity.Supplier;
import com.example.repository.CthdnRepository;
import com.example.repository.OrderInfoRepository;
import com.example.repository.OrderRepository;
import com.example.service.ArticleProductService;
import com.example.service.CommonService;
import com.example.service.CourtyardService;
import com.example.service.ImageService;
import com.example.service.ProductService;
import com.example.service.StatusService;
import com.example.service.StrademarkService;
import com.example.service.SupplierService;

import lombok.RequiredArgsConstructor;
import net.bytebuddy.asm.Advice.This;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

	private final ProductService productService;
	
	private final StrademarkService strademarkService;
	
	private final CommonService commonService;

	private final CourtyardService courtyardService;
	
	private final ImageService imageService;
	
	private final ArticleProductService articleProductService;
	
	private final SupplierService supplierService;
	
	private final OrderInfoRepository orderInfoRepository;
	
	private final CthdnRepository cthdnRepository;
	
	@GetMapping("/")
	public String index(Model model,Principal principal) {
		model.addAttribute("username", principal.getName());
		return "admin/index";
	}
	@GetMapping("/supplier")
	public String supplierPage() {
		return "admin/supplier";
	}
	@GetMapping("/goods-received")
	public String goodsReceivedPage() {
		return "admin/goods-received";
	}
	@GetMapping("/goods-received-info/{id}")
	public String goodsReceivedInfoPage(@PathVariable(name = "id") Long id,Model model) {
		model.addAttribute("title", "Quản lý chi tiết đơn nhập");
		List<Cthdn> cthdns = this.cthdnRepository.findByHoaDonNhapId(id);
		model.addAttribute("cthdns", cthdns);
		return "admin/goods-received-info";
	}
	@GetMapping("/import-goods")
	public String importGoodsPage(Model model) {
		List<Supplier> suppliers = this.supplierService.getAll();
		model.addAttribute("suppliers", suppliers);
		return "admin/import-goods";
	}
	
	@GetMapping("/product")
	public String productPage(Model model) {
		List<Strademark> strademarks = this.strademarkService.getStrademarks();
		model.addAttribute("strademarks", strademarks);
		List<Courtyard> courtyards = this.courtyardService.getAllCourtyards();
		model.addAttribute("courtyards", courtyards);
		model.addAttribute("title", "Quan ly san pham");
		return "admin/product";
	}
	
	@GetMapping("/brand")
	public String brandPage(Model model) {
		model.addAttribute("title", "Quan ly thuong hieu");
		return "admin/brand";
	}
	
	@GetMapping("/image")
	public String imagePage(Model model) {
		model.addAttribute("title", "Quan ly anh san pham");
		return "admin/image";
	}
	
	@GetMapping("/article-product")
	public String articleProductPage(Model model) {
		model.addAttribute("title", "Quản lý bài viết sản phẩm");
		return "admin/article-product";
	}
	
	@GetMapping("/create-article-product")
	public String createArticleProductPage(Model model) {
		List<ImageArticle> imageArticles = this.imageService.getImageArticles();
		model.addAttribute("imageArticles", imageArticles);
		model.addAttribute("title", "Quản lý bài viết sản phẩm");
		return "admin/create-article-product";
	}		
	
	@GetMapping("/update-article-product/{id}")
	public String updateArticleProductPage(@PathVariable(name = "id") Long id,Model model) {
		ArticleProduct articleProduct = this.articleProductService.getById(id);
		model.addAttribute("articleProduct", articleProduct);
		List<ImageArticle> imageArticles = this.imageService.getImageArticles();
		model.addAttribute("imageArticles", imageArticles);
		model.addAttribute("title", "Quản lý bài viết sản phẩm");
		System.out.println(articleProduct.getNameProduct());
		return "admin/update-article-product";
	}
		
	@GetMapping("/order")
	public String orderProductPage(Model model) {
		model.addAttribute("title", "Quản lý đơn hàng");
		
		return "admin/order";
	}
	
	@GetMapping("/order-info/{id}")
	public String orderInfoPage(@PathVariable(name = "id") Long id,Model model) {
		model.addAttribute("title", "Quản lý chi tiết đơn hàng");
		List<OrderInfo> orderInfo = this.orderInfoRepository.findByIdOrder(id);
		model.addAttribute("orderInfo", orderInfo);
		System.out.println(orderInfo);
		return "admin/order-info";
	}
	
	@GetMapping("/banner")
	public String bannerProductPage(Model model) {
		model.addAttribute("title", "Quản lý banner");
		return "admin/banner";
	}
	
	@GetMapping("/notification")
	public String notificationPage(Model model) {
		model.addAttribute("title", "Gửi thông báo");
		return "admin/notification";
	}
	
	@GetMapping("/mail")
	public String mailPage(Model model) {
		model.addAttribute("title", "Gửi email");
		return "admin/send-mail";
	}
	
	@GetMapping("/discount-campaign")
	public String discountCampaignPage(Model model) {
		model.addAttribute("title", "Chiến dịch giảm giá");
		return "admin/discount-campaign";
	}
	
	@GetMapping("/thong-ke-doanh-thu")
    public String thongKeDoanhThuPage(Model model) {
    	model.addAttribute("month", LocalDate.now().getMonthValue());
    	model.addAttribute("monthBefore", LocalDate.now().minusMonths(1).getMonthValue());
    	model.addAttribute("year", LocalDate.now().getYear());
    	List<Order> ordersReceivedThisMonth = this.commonService.getOrderReceived(LocalDate.now());
    	List<Order> ordersReceivedMonthEarlier = this.commonService.getOrderReceived(LocalDate.now().minusMonths(1));
    	List<Order> ordersNotReceivedThisMonth = this.commonService.getOrderNotReceived(LocalDate.now());
    	List<Order> ordersNotReceivedMonthEarlier = this.commonService.getOrderNotReceived(LocalDate.now().minusMonths(1));
       System.out.println(ordersReceivedThisMonth);
    	model.addAttribute("ordersReceivedThisMonth", ordersReceivedThisMonth);
        model.addAttribute("ordersReceivedMonthEarlier", ordersReceivedMonthEarlier);
        model.addAttribute("ordersNotReceivedThisMonth", ordersNotReceivedThisMonth);
        model.addAttribute("ordersNotReceivedMonthEarlier", ordersNotReceivedMonthEarlier);

        model.addAttribute("title", "Thống kê doanh thu");
        return "admin/thong-ke-doanh-thu";
    }
}
	
