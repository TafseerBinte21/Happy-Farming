package com.tafa.farmer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.tafa.farmer.controllers.dto.cropdto;
import com.tafa.farmer.exception.ResourceNotFoundException;
import com.tafa.farmer.models.crop;
import com.tafa.farmer.repository.CropRepository;

@Service
public class CropServiceImpl implements CropService {

	@Autowired
	private CropRepository cRepository;

	@Override
	public crop save(cropdto CropDto) {
		crop c = new crop(CropDto.getId(), CropDto.getName(), CropDto.getDescription(),
				CropDto.getPrice(), CropDto.getImage(), CropDto.getVideo(), CropDto.getTime(), CropDto.getTemperature(), CropDto.getpH(), CropDto.getWaterLevel(),
				CropDto.getFertilizer());

		return cRepository.save(c);
	}

	@Override
	public crop findcropByname(String name) {

		return cRepository.findByname(name);
	}

	@Override
	public List<crop> findcropBykeyword(String keyword) {
		return cRepository.findByKeyword(keyword);
	}

	@Override
	public crop findcropById(Long Id) {
		crop crp = cRepository.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("Game with id:" + Id + " not found"));
		return crp;
	}

	@Override
	public List<crop> findAll() {
		List<crop> cr = cRepository.findAll();
		return cr;
	}

	@Override
	public Boolean iscropExitsById(long l) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	 @Override
//	public Boolean isGameExitsById(Long id) {
//		 return gRepository.isGameExitsById(id);
//	 }

}
