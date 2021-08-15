package com.lance.dojoandninja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lance.dojoandninja.models.Dojo;
import com.lance.dojoandninja.repository.DojoRepo;

@Service
public class DojoService {
	@Autowired
	private DojoRepo dojoRepo;
	
	//create
	public Dojo createDojo(Dojo d) {
		return dojoRepo.save(d);
	}
	
	//READ ALL 
	public List<Dojo> allDojos(){		
		return dojoRepo.findAll();
	}
	
	//Find One Dojo and all the ninjas in the dojo
	public Dojo findOneDojo(Long id) {
		Optional<Dojo> optionalDojo  = dojoRepo.findById(id);
		
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		}else {
			return null;
		}
	}
	
}
