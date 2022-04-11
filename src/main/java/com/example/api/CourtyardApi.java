package com.example.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.CourtyardDatatablesModel;
import com.example.service.CourtyardService;
import com.example.service.StrademarkService;
import com.example.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin/courtyard")
@RequiredArgsConstructor
public class CourtyardApi {

	private final CourtyardService courtyardService;
	
	@GetMapping("/get-all")
	public CourtyardDatatablesModel getAllCourtyard() {
		return this.courtyardService.getCourtyardDatatablesModel();
	}
	
}
