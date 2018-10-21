package com.web.studentroster.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.web.studentroster.models.Dorm;

@Repository
public interface DormRepository extends CrudRepository<Dorm, Long>{
	Dorm findDormById(Long dormId);
}
