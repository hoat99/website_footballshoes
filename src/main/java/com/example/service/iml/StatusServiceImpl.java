package com.example.service.iml;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Status;
import com.example.repository.StatusRepository;
import com.example.service.StatusService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StatusServiceImpl implements StatusService{
	private final StatusRepository statusRepository;
	
	@Override
	public List<Status> getAllStatus() {
		return this.statusRepository.findAll();
	}

}
