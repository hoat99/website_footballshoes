package com.example.service;

import java.util.List;

import com.example.dto.request.CourtyardDTO;
import com.example.entity.Courtyard;
import com.example.model.CourtyardDatatablesModel;

public interface CourtyardService {

	List<Courtyard> getAllCourtyards();
	
	List<CourtyardDTO> getAllCourtyardsDTO();
	
	CourtyardDatatablesModel getCourtyardDatatablesModel();
}
