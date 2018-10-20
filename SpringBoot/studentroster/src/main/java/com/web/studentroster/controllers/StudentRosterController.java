package com.web.studentroster.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.studentroster.models.Student;
import com.web.studentroster.services.ContactService;
import com.web.studentroster.services.StudentService;

@Controller
public class StudentRosterController {
	private final StudentService studentServ;
	private final ContactService contactServ;
	
	public StudentRosterController(StudentService studentServ, ContactService contactServ ) {
		this.studentServ = studentServ;
		this.contactServ = contactServ;
	}
	
	//serve home jsp
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	//serve new student form JSP
	@RequestMapping("/students/new")
	public String newStudent() {
		return "newStudent.jsp";
	}
	
	//process new student form
	@RequestMapping("/students/create")
	public String createStudent(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("age") int age) {
		System.out.println("Came to /student/create");
		studentServ.createStudent(firstName, lastName, age);
		return "redirect:/";
	}
	
	//serve new contact form JSP
	@RequestMapping("/contact/new")
	public String newContact(Model model) {
		model.addAttribute("students", studentServ.findAll());
		return "newContact.jsp";
	}
	
	//process new contact form
	@RequestMapping("/contact/create")
	public String createContact(@RequestParam("student") Long studentId, String address, String city, String state) {
		System.out.println("Came to /contact/create");
		Student student = studentServ.findStudentById(studentId);
		contactServ.createContact(address, city, state, student);
		return "redirect:/";
	}
	
	//serve all students jsp
	@RequestMapping("/students")
	public String students(Model model) {
		model.addAttribute("contacts", contactServ.findAll());
		return "allStudents.jsp";
	}
}
