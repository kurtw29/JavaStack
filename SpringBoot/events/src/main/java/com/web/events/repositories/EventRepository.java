package com.web.events.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.web.events.models.Event;
@Repository
public interface EventRepository extends CrudRepository<Event, Long>{
	
	Event findEventById(Long id);
	
	//list of states in a given state
	List<Event> findByState(String state);
	
	//list of other states NOT in a given state
	List<Event> findByStateNot(String state);
	
	//Add user to attendees list
}
