package com.example.api;

import java.io.IOException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.request.ImageRequest;
import com.example.model.ImageDatatablesModel;
import com.example.service.ImageService;
import com.example.service.StrademarkService;
import com.example.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin/image")
@RequiredArgsConstructor
public class ImageApi {

	private final ImageService imageService;
	
	@GetMapping("/get-all")
	public  ImageDatatablesModel getAllImageDatatablesModel() {
		return this.imageService.getImageDatatablesModel();
	}
	
	@PostMapping("/create")
	public void createImage(ImageRequest imageRequest) throws IOException{
		this.imageService.createImage(imageRequest);
	}
	
	@PutMapping("/update")
	public void updateImage(ImageRequest imageRequest)throws IOException{
		this.imageService.updateImage(imageRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteImage(@PathVariable(name = "id")Long id){
		this.imageService.deleteImage(id);
	}
}
