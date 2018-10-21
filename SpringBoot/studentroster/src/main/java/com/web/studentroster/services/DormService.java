package com.web.studentroster.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.web.studentroster.models.Dorm;
import com.web.studentroster.models.Student;
import com.web.studentroster.repositories.DormRepository;

@Service
public class DormService {
	private final DormRepository dormRepo;
	
	public DormService(DormRepository dormRepo) {
		this.dormRepo = dormRepo;
	}
	
	//find all dorms
	public Iterable<Dorm> findAllDorms() {
		return dormRepo.findAll();
	}
	
	//find a dorm by id
	public Dorm findDormById(Long dormId) {
		return dormRepo.findDormById(dormId);
	}
	
	//create a dorm
	public Dorm createDorm(String name) {
		Dorm newDorm = new Dorm(name);
		return dormRepo.save(newDorm);
	}
	
}
