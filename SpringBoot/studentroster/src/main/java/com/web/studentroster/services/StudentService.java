package com.web.studentroster.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.web.studentroster.models.Student;
import com.web.studentroster.repositories.StudentRepository;

@Service
public class StudentService {
	private final StudentRepository studentRepo;
	
	public StudentService(StudentRepository studentRepo) {
		this.studentRepo = studentRepo;
	}
	
	//retrieve all students
	public Iterable<Student> findAll() {
		return studentRepo.findAll();
	}
	
	//retrieve student by id
	public Student findStudentById(Long studentId) {
		Optional<Student> s = studentRepo.findById(studentId);
		if(s.isPresent()) {
			return s.get();
		}else {
			System.out.println("Did not find any Student for studentID: "+studentId);
			return null;
		}
	}
	
	//create a student
	public Student createStudent(String first, String last, int age) {
		Student newStudent = new Student(first, last, age);
		return studentRepo.save(newStudent);
	}
}
