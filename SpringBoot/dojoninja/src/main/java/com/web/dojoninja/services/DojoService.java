package com.web.dojoninja.services;


import java.util.Optional;

import org.springframework.stereotype.Service;

import com.web.dojoninja.models.Dojo;
import com.web.dojoninja.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepo;
	
	public DojoService(DojoRepository dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	
	//Retrieve all the dojos
	public Iterable<Dojo> findAll(){
		return dojoRepo.findAll();
	}
	
	//Create a dojo given an object Dojo
	public Dojo addDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	//find a dojo by id
	public Dojo findById(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		}else
		return null;
	}
	
}
