package com.example.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.entity.HoaDonNhap;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HoaDonNhapDatatablesModel {

private List<List<String>> data;
	
	public static HoaDonNhapDatatablesModel converter(List<HoaDonNhap> hoaDonNhaps) {
		List<List<String>> datas = new ArrayList<>();
		hoaDonNhaps.forEach(hoaDonNhap -> datas.add(Arrays.asList(hoaDonNhap.getId().toString()
				,hoaDonNhap.getSupplier().getName()
				,hoaDonNhap.getCreateAt().toString()
				)));
		return HoaDonNhapDatatablesModel.builder().data(datas).build();
	}
	
}
