package com.example.model;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.entity.Product;

import ch.qos.logback.core.joran.conditional.IfAction;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDatatablesModel {
private List<List<String>> data;
	
	public static ProductDatatablesModel converter(List<Product> products) {
		List<List<String>> datas = new ArrayList<>();
		
		products.forEach(product -> datas.add(Arrays.asList(
				product.getIdProduct().toString()
				,product.getName() != null ? product.getName() : " "
				,product.getCost() != null ? product.getCost().toString() : " "
				,product.getQuantity() != null ? product.getQuantity().toString() : " "
				,product.getImage() != null ? product.getImage().getAvatar() : " "
				,product.getSize() != null ? product.getSize().toString() : " "
				,product.getAlbum() != null ? product.getAlbum() : " "
				,product.getColor() != null ? product.getColor() : " "
				,product.getCourtyard() != null ? product.getCourtyard().getType().toString() : " "
				,product.getMaterial() != null ? product.getMaterial() : " "
				,product.getRepresentativePlayer() != null ? product.getRepresentativePlayer() : " "
				,product.getStrademark().getName()!= null ? product.getStrademark().getName().toString() : " "
				,product.getTechnology() != null ? product.getTechnology() : " "
				,(product.getYearOfProduction()) != null ? product.getYearOfProduction().toString() : " "
				)));
		return ProductDatatablesModel.builder().data(datas).build();
	}
}
