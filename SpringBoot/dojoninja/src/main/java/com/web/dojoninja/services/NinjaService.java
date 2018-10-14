package com.web.dojoninja.services;


import org.springframework.stereotype.Service;

import com.web.dojoninja.models.Ninja;
import com.web.dojoninja.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepo;
	
	public NinjaService(NinjaRepository ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}
	
	//retrieve all ninjas
	public Iterable<Ninja> findAll(){
		return ninjaRepo.findAll();
	}
	
	//create a ninja
	public Ninja addNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
}
