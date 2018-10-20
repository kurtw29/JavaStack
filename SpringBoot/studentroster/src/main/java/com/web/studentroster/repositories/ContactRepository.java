package com.web.studentroster.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.web.studentroster.models.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long>{

}
