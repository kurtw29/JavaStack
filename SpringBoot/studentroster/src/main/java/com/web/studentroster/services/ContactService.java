package com.web.studentroster.services;

import org.springframework.stereotype.Service;

import com.web.studentroster.models.Contact;
import com.web.studentroster.models.Student;
import com.web.studentroster.repositories.ContactRepository;
@Service
public class ContactService {
	private final ContactRepository contactRepo;
	
	public ContactService(ContactRepository contactRepo) {
		this.contactRepo = contactRepo;
	}
	
	public Iterable<Contact> findAll(){
		return contactRepo.findAll(); 
	}
	
	public Contact createContact(String address, String city, String state, Student student) {
		Contact newContact = new Contact(address, city, state, student);
		return contactRepo.save(newContact);
	}
}
