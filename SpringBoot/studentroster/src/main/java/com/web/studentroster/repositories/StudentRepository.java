package com.web.studentroster.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.web.studentroster.models.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{

}
