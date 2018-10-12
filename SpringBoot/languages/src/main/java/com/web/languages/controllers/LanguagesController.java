package com.web.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.languages.models.Language;
import com.web.languages.services.LanguageService;

@Controller
@RequestMapping("/languages")
public class LanguagesController {
	private final LanguageService languageService;
	
	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}
	//get - show the page with all the languages
	@RequestMapping("")
	public String displayAndAdd(Model model, @ModelAttribute("lang") Language lang) {
		System.out.println("CAME TO LanguageControll / displayAndAdd() ");
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		System.out.println("addattribute(language, languages: "+languages);
		return "displayAndAdd.jsp";
	}
	
	//post - to create a language
	@RequestMapping(value="", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("lang") Language lang, BindingResult result) {
		System.out.println("CAME TO LanguageControll / POST create() ");
		if(result.hasErrors()) {
			return "displayAndAdd.jsp";
		}else {
			languageService.createLanguage(lang);
			return "redirect:/languages";
		}
	}
	
	//get - specific language and details given id
	@RequestMapping("/{id}")
	public String detail(@PathVariable("id") long id, Model model) {
		System.out.println("CAME TO LanguageControll / detail() id: "+id);
		model.addAttribute(languageService.findLanguage(id));
		return "detail.jsp";
	}
	//get - the edit page of a specific language given id
	@RequestMapping("/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		System.out.println("CAME TO LanguageControll / detail() id: "+id);
		Language language = languageService.findLanguage(id);
		model.addAttribute("language", language);
		return "edit.jsp";
	}
	
	//put - update a specific language given id
	@RequestMapping(value ="/{id}", method=RequestMethod.PUT)
	public String update(Model model, @Valid @ModelAttribute("language") Language language, BindingResult result) {
		System.out.println("CAME TO LanguageControll / PUT update() language: "+language);
		if(result.hasErrors()) {
			System.out.println("errors:"+result );
			model.addAttribute("language", language);
			return "edit.jsp";
		}else {
			languageService.updateLanguage(language);
			return "redirect:/languages";
		}
	}
	
	//delete - delete a specific language given id
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") long id) {
		System.out.println("CAME TO LanguageControll / DELETE delete() id: "+id);
		languageService.deleteLanguage(id);
		return "redirect:/languages";
	}
}
