package com.web.driverlicense.Controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.driverlicense.models.License;
import com.web.driverlicense.models.Person;
import com.web.driverlicense.services.LicenseService;
import com.web.driverlicense.services.PersonService;

@Controller
public class DriverLicenseController {
	private PersonService personService;
	private LicenseService licenseServ;
	
	public DriverLicenseController(PersonService personService, LicenseService licenseServ) {
		this.personService = personService;
		this.licenseServ = licenseServ;
	}
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
		CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, orderDateEditor);
	}
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/persons/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		System.out.println("came to /persons/new");
		return "newPerson.jsp";
	}
	
	@RequestMapping(value="/persons/new", method=RequestMethod.POST)
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "newPerson.jsp";
		}else {
			personService.addPerson(person);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/licenses/new")
	public String newLicense(Model model, @ModelAttribute("license") License license) {
		System.out.println("came to /licenses/new");
		model.addAttribute("persons", personService.findAll());
		return "newLicense.jsp";
	}
	
	@RequestMapping(value="/addNewLicense", method=RequestMethod.POST)
	public String addLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		System.out.println("POST addLicense() license.GETeXPIRATION_DATE: "+license.getExpiration_date()+" \nlicense.getState(): "+license.getState()+" \n license.getPerson: "+license.getPerson());
		if(result.hasErrors()) {
			return "newLicense.jsp";
		}else {
			licenseServ.addLicense(license);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/persons/{id}")
	public String showLicense(@PathVariable("id") Long id, Model model) {
		model.addAttribute("info", personService.findById(id));
		return "showLicense.jsp";
	}
}
