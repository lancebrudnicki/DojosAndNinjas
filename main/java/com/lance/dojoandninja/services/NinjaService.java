package com.lance.dojoandninja.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lance.dojoandninja.models.Ninja;
import com.lance.dojoandninja.repository.NinjaRepo;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepo ninjaRepo;
	
	//create
	public Ninja createNinja(Ninja n) {
		return ninjaRepo.save(n);
	}
	
	//Read All
	public List<Ninja> allNinjas(){
		return ninjaRepo.findAll();
	}
	
}
