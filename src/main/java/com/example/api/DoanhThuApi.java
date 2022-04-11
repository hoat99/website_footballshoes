package com.example.api;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.CommonService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/doanh-thu")
public class DoanhThuApi {
	
	private final CommonService commonService;

	@GetMapping("/get")
	public List<BigDecimal> getDoanhThu() {
		return this.commonService.thongKeDoanhThu();
	}
	
	@GetMapping("/get-month-before")
	public List<BigDecimal> getDoanhThuThangTruoc() {
		return this.commonService.thongKeDoanhThuThangTruoc();
	}

}
