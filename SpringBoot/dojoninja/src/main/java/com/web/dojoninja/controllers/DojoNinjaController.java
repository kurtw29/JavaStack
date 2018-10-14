package com.web.dojoninja.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.dojoninja.models.Dojo;
import com.web.dojoninja.models.Ninja;
import com.web.dojoninja.services.DojoService;
import com.web.dojoninja.services.NinjaService;

@Controller
public class DojoNinjaController {
	
	//Declare dojoService & NinjaService
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	
	//Create constructor to instantiate DojoService & NinjaService
	public DojoNinjaController(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	
	//Services jsp for Index page that shows links to "New Dojo", "New Ninja", & "Dojo's Ninjas"
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("dojos", dojoService.findAll());
		return "index.jsp";
	}
	
	//Serves jsp for creating a new dojo "New Dojo"
	@RequestMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}
	
	//Proc creating a new dojo & redirect
	@RequestMapping(value="/dojos/create", method=RequestMethod.POST)
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "newDojo.jsp";
		}else {
			dojoService.addDojo(dojo);
			return "redirect:/";
		}
	}
	
	//Serves jsp for creating a new ninja "New Ninja"
	@RequestMapping("/ninjas/new")
	public String newNinja(Model model, @ModelAttribute("ninja") Ninja ninja) {
		model.addAttribute("dojos", dojoService.findAll());
		return "newNinja.jsp";
	}
	
	//Proc creating a new ninja & redirect
	@RequestMapping(value="/ninjas/create", method=RequestMethod.POST)
	public String createNinja(Model model, @Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			model.addAttribute("dojos", dojoService.findAll());
			return "newNinja.jsp";
		}else {
			ninjaService.addNinja(ninja);
			return "redirect:/";
		}
	}
	
	//Re-route incoming POST of a particular dojo & redirect to display all ninjas
	@RequestMapping("/findDojo")
	public String findDojo(@RequestParam(value="locationId") Long id) {
		return "redirect:/dojos/"+id;
	}
	//Serves jsp for displaying all the ninjas of a specific location
	@RequestMapping("/dojos/{id}")
	public String dojoNinja(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", dojoService.findById(id));
		System.out.println("Can we please show all the ninjas for this dojo?\n");
		System.out.println(dojoService.findById(id).getNinjas());
		return "dojoNinjas.jsp";
	}
}
