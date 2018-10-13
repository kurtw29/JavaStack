package com.web.driverlicense.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.web.driverlicense.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
}
