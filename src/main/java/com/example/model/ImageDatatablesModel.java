package com.example.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.entity.Image;
import com.example.entity.Strademark;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ImageDatatablesModel {
private List<List<String>> data;
	
	public static ImageDatatablesModel converter(List<Image> images) {
		List<List<String>> datas = new ArrayList<>();
		images.forEach(image -> datas.add(Arrays.asList(image.getIdImage().toString()
				,image.getNameProduct() != null ? image.getNameProduct():""
				,image.getAvatar()!= null ? image.getAvatar():""
				,image.getImage1()!= null ? image.getImage1():""
					,image.getImage2()!= null ? image.getImage2():""
						,image.getImage3()!= null ? image.getImage3():""
							,image.getImage4()!= null ? image.getImage4():"")));
		return ImageDatatablesModel.builder().data(datas).build();
	}
	
}
