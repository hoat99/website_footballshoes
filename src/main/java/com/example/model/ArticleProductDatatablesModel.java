package com.example.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.entity.ArticleProduct;
import com.example.entity.Strademark;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArticleProductDatatablesModel {

private List<List<String>> data;
	
	public static ArticleProductDatatablesModel converter(List<ArticleProduct> articleProducts) {
		List<List<String>> datas = new ArrayList<>();
		articleProducts.forEach(articleProduct -> datas.add(Arrays.asList(articleProduct.getIdArticleProduct().toString()
				,articleProduct.getNameProduct()
				,articleProduct.getContent())));
		return ArticleProductDatatablesModel.builder().data(datas).build();
	}
	
}
