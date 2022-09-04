package com.tafa.farmer.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tafa.farmer.controllers.dto.cropdto;
import com.tafa.farmer.models.crop;

@Service
public interface CropService {
	
	
	crop save(cropdto CropDto);

	crop findcropByname(String name);

	crop findcropById(Long Id) throws Exception;

	List<crop> findcropBykeyword(String keyword);

	List<crop> findAll();

	Boolean iscropExitsById(long l);
	
//	Boolean isGameExitsById(Long id);

}
