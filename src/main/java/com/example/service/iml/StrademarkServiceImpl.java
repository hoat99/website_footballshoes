package com.example.service.iml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.common.FileUtils;
import com.example.dto.request.ShopDTO;
import com.example.dto.request.StrademarkDTO;
import com.example.dto.request.StrademarkRequest;
import com.example.entity.Product;
import com.example.entity.Strademark;
import com.example.model.BrandDatatablesModel;
import com.example.model.CreateBrandRequest;
import com.example.repository.StrademarkRepository;
import com.example.service.ProductService;
import com.example.service.StrademarkService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StrademarkServiceImpl implements StrademarkService {

	private final StrademarkRepository strademarkRepository;
	
	private final ProductService productService;

	private final HttpServletRequest request;
	@Value("${image.location}")
	private String location;

	@Override
	@Transactional
	public void createStrademark(StrademarkRequest strademarkRequest) throws IOException {
		Strademark strademark = new Strademark();
		strademark.setName(strademarkRequest.getName());
//		strademark.setImg(FileUtils.saveAvatar(strademarkRequest.getImg(), this.location, request));
		strademark.setImg(strademarkRequest.getImg());
		strademarkRepository.save(strademark);
	}

	@Override
	public void updateStrademark(StrademarkRequest strademarkRequest) throws IOException {
		Strademark strademark = this.strademarkRepository.getById(strademarkRequest.getIdStrademark());
		strademark.setName(strademarkRequest.getName());
		if (strademarkRequest.getImg() != null) {
//			strademark.setImg(FileUtils.saveAvatar(strademarkRequest.getImg(), this.location, request));
			strademark.setImg(strademarkRequest.getImg());

		}
		strademarkRepository.save(strademark);
	}

	@Override
	public List<Strademark> getStrademarks() {
		return this.strademarkRepository.findAll();
	}

	@Override
	public void deleteStrademark(Long idStrademark) {
		this.strademarkRepository.deleteById(idStrademark);

	}

	@Override
	public Strademark getStrademarkById(Long id) {
		return this.strademarkRepository.getById(id);
	}

	@Override
	public BrandDatatablesModel getAllStrademark() {

		return BrandDatatablesModel.converter(this.strademarkRepository.findAll());
	}

	@org.springframework.transaction.annotation.Transactional
	@Override
	public void createBrand(CreateBrandRequest createBrandRequest) throws IOException {
		Strademark strademark = new Strademark();
		strademark.setName(createBrandRequest.getName());
		strademark.setImg(createBrandRequest.getImg());

//		strademark.setImg(FileUtils.saveAvatar(createBrandRequest.getImg(), location, request));
		this.strademarkRepository.save(strademark);
	}

	@Override
	public Optional<StrademarkDTO> findOne(Long id) {
		return this.strademarkRepository.findOneStrademark(id);
	}

//	private StrademarkDTO stradeMapper(Strademark strademark) {
//		return StrademarkDTO.builder().id(strademark.getIdStrademark()).name(strademark.getName())
//				.img(strademark.getImg()).build();
//	}

	@Override
	public Optional<StrademarkDTO> ggga(Long id) {
		return this.strademarkRepository.findOneStrademark(id);
	}

	@Override
	public List<StrademarkDTO> geStrademarksWithQuantityProduct() {
		List<Strademark> strademarks = this.strademarkRepository.findAll();
		List<StrademarkDTO> strademarkDTOs = new ArrayList<>();
		List<Product> products = this.productService.getAllProducts();
		for (int i = 0; i < strademarks.size(); i++) {
			Strademark strademark = strademarks.get(i);
			StrademarkDTO strademarkDTO = StrademarkDTO.builder().id(strademark.getIdStrademark())
					.name(strademark.getName()).img(strademark.getImg()).numberProduct(getShowProducts(products, strademark.getName()))
					.build();
			;
			strademarkDTOs.add(strademarkDTO);
		}
		return strademarkDTOs;
	}

	public Integer getShowProducts(List<Product> listProduct, String strademark) {
		List<String> name = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < listProduct.size(); i++) {
			boolean flag = false;
			
			Product product = listProduct.get(i);
			if(product.getStrademark().getName().compareTo(strademark) == 0)
			{
			for (int j = 0; j < name.size(); j++) {
				if (product.getName().compareTo(name.get(j)) == 0) {
					flag = true;
					break;
				}
			}
			if (flag == false) {
				count++;
				name.add(product.getName());
			}}
		}
		return count;
	}
}
