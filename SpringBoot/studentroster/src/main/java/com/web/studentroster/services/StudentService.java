package com.web.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.web.studentroster.models.Dorm;
import com.web.studentroster.models.Student;
import com.web.studentroster.repositories.StudentRepository;

@Service
public class StudentService {
	private final StudentRepository studentRepo;
	
	public StudentService(StudentRepository studentRepo) {
		this.studentRepo = studentRepo;
	}
	
	//retrieve all students
	public List<Student> findAll() {
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
	
	//set student dorm
	public Student setDorm(Long studentId, Dorm dorm) {
		Student student = studentRepo.findStudentById(studentId);
		student.setDorm(dorm);
		return studentRepo.save(student);
	}
	
	//remove student from dorm
	public Student removeDorm(Long studentId) {
		Student student = studentRepo.findStudentById(studentId);
		student.setDorm(null);
		return studentRepo.save(student);
	}
}
