package com.web.driverlicense.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.web.driverlicense.models.Person;
import com.web.driverlicense.repositories.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository personRepo;
	public PersonService(PersonRepository personRepo) {
		this.personRepo = personRepo;
	}
	
	public Person addPerson(Person person) {
		System.out.println("came to PersonService, svae please");
		return personRepo.save(person);
	}
	
	public Person findById(Long id) {
		Optional<Person> optionalPerson = personRepo.findById(id);
		if(optionalPerson.isPresent()) {
			return optionalPerson.get();
		}else {
			return null;
		}
	}
	
	public Iterable<Person> findAll(){
		return personRepo.findAll();
	}
}
