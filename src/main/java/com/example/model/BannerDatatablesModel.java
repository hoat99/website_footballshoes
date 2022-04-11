package com.example.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.entity.ArticleProduct;
import com.example.entity.Banner;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BannerDatatablesModel {
private List<List<String>> data;
	
	public static BannerDatatablesModel converter(List<Banner> banners) {
		List<List<String>> datas = new ArrayList<>();
		banners.forEach(banner -> datas.add(Arrays.asList(banner.getIdBanner().toString()
				,banner.getContent()
				,banner.getShortDescription()
				,banner.getImg()
				,banner.getStatus())));
		return BannerDatatablesModel.builder().data(datas).build();
	}
}
