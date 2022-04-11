package com.example.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.entity.Strademark;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BrandDatatablesModel {

	private List<List<String>> data;
	
	public static BrandDatatablesModel converter(List<Strademark> strademarks) {
		List<List<String>> datas = new ArrayList<>();
		strademarks.forEach(strademark -> datas.add(Arrays.asList(strademark.getIdStrademark().toString()
				,strademark.getName()
				,strademark.getImg())));
		return BrandDatatablesModel.builder().data(datas).build();
	}
	
}
