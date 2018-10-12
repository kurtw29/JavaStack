package com.web.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.web.languages.models.Language;
import com.web.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository languageRepo;
	public LanguageService(LanguageRepository languageRepo) {
		this.languageRepo = languageRepo;
	}
	
	//retrieve all languages
	public List<Language> allLanguages(){
		return (List<Language>) languageRepo.findAll();
	}
	
	//retrieve a language by id
	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage = languageRepo.findById(id);
		if(optionalLanguage.isPresent()) {
			return optionalLanguage.get();			
		}else {
			return null;
		}
	}
	
	//create a languages
	public void createLanguage(Language language) {
		languageRepo.save(language);
	}
	
	//update a language
	public Language updateLanguage(Long id, String name, String creator, String version) {
		Optional<Language> optionalLanguage = languageRepo.findById(id);
		if(optionalLanguage.isPresent()) {
			optionalLanguage.get().setName(name);
			optionalLanguage.get().setCreator(creator);
			optionalLanguage.get().setVersion(version);
			return languageRepo.save(optionalLanguage.get());
		}else {
			return null;
		}
	}
	
	//update a language given "language" object
	public Language updateLanguage(Language language) {
      	return languageRepo.save(language);
    }
	
	//delete a language of that id
	public void deleteLanguage(Long id) {
		languageRepo.deleteById(id);
	}
}
