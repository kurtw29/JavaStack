package com.web.studentroster.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.studentroster.models.Dorm;
import com.web.studentroster.models.Student;
import com.web.studentroster.services.DormService;
import com.web.studentroster.services.StudentService;

@Controller
public class DormController {
	private final DormService dormServ;
	private final StudentService studentServ;
	
	public DormController(DormService dormServ, StudentService studentServ) {
		this.dormServ = dormServ;
		this.studentServ = studentServ;
	}
	
	//serve new dorm jsp
	@RequestMapping("/dorms/new")
	public String newDorm() {
		return "newDorm.jsp";
	}
	
	//proccess POST new dorm form
	@RequestMapping("/dorms/create")
	public String createDorm(@RequestParam("name") String name) {
		System.out.println("Arrived at /dorms/create for processing");
		//create dorm
		Dorm dorm = dormServ.createDorm(name);
		System.out.println("created dorm with name: "+name);
		return "redirect:/dorms/"+dorm.getId();
	}
	
	//process index show-dorm selection
	@RequestMapping("/dorms/show/")
	public String directShowDorm(@RequestParam("dormId") Long dormId) {
		return "redirect:/dorms/"+dormId;
	}
	
	//serve Show Dorm jsp
	@RequestMapping("/dorms/{id}")
	public String showDorm(@PathVariable("id") Long dormId, Model model){
		System.out.println("Came to show dorm - /dorms/{id} with id:"+dormId);
		Dorm dorm = dormServ.findDormById(dormId);
		model.addAttribute("dorm", dorm);
		//Find list of students who are not in the dorm
		List<Student> studentList = new ArrayList<>(studentServ.findAll());
		studentList.removeAll(dorm.getStudents());
		model.addAttribute("students", studentList);
		return "showDorm.jsp";
	}
	
	//process add student to dorm
	@RequestMapping("/dorm/{dormId}/add")
	public String addStudentToDorm(@PathVariable("dormId") Long dormId, @RequestParam("student") Long studentId) {
		System.out.println("Came to /dorm/"+dormId+"/add with studentId: "+studentId);
		Student student = studentServ.findStudentById(studentId);
		Dorm dorm = dormServ.findDormById(dormId);
		studentServ.setDorm(studentId, dorm);
		return "redirect:/dorms/"+dormId;
	}
	
	//process remove student from dorm
	@RequestMapping("dorm/{dormId}/remove")
	public String removeStudentFromDrom(@RequestParam("studentId") Long studentId, @PathVariable("dormId") Long dormId) {
		System.out.println("came to dorm/"+dormId+"/remove with studentId: "+studentId);
		studentServ.removeDorm(studentId);
		return "redirect:/dorms/"+dormId;
	}	
}
