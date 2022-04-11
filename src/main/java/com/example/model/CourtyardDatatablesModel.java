package com.example.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.entity.Courtyard;
import com.example.entity.Strademark;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CourtyardDatatablesModel {
private List<List<String>> data;
	
	public static CourtyardDatatablesModel converter(List<Courtyard> courtyards) {
		List<List<String>> datas = new ArrayList<>();
		courtyards.forEach(courtyard -> datas.add(Arrays.asList(courtyard.getIdCourtyard().toString()
				,courtyard.getType())));
		return CourtyardDatatablesModel.builder().data(datas).build();
	}
}
