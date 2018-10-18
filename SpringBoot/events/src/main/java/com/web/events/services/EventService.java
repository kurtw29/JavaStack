package com.web.events.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.web.events.models.Event;
import com.web.events.models.User;
import com.web.events.repositories.EventRepository;

@Service
public class EventService {
	private final EventRepository eventRepo;
	
	public EventService(EventRepository eventRepo) {
		this.eventRepo = eventRepo;
	}
	
	//get all the events
	public List<Event> allEvents(){
		return (List<Event>) eventRepo.findAll();
	}
	
	//get an event by id
	public Event findEventById(Long eventId) {
		return eventRepo.findEventById(eventId);
	}
	
	//get all events in a given state
	public List<Event> findByState(String state) {
		return eventRepo.findByState(state);
	}
	
	//get all events outside of a given state
	public List<Event> findByStateNot(String state){
		return eventRepo.findByStateNot(state);
	}

	//create an event
	public Event createEvent(Event event) {
		return eventRepo.save(event);
	}
	
	//add a user to an event's attendees list
	public Event addAttendee(Long eventId, User user) {
		//query add event to User's List<Event>
		Event event = eventRepo.findEventById(eventId);
		event.getAttendees().add(user);
		//save event
		return eventRepo.save(event);
	}
	
	//remove a user from event's attendees list
	public Event removeAttendee(Long eventId, User user) {
		//find the event and remove user from list of attendees
		Event event = eventRepo.findEventById(eventId);
		event.getAttendees().remove(user);
		//save user
		return eventRepo.save(event);
	}
	
	//update an event
	public Event updateEvent(Long eventId, Event event) {
		Event e = eventRepo.findEventById(eventId);
		e.setName(event.getName());
		e.setDate(event.getDate());
		e.setLocation(event.getLocation());
		e.setState(event.getState());
		return eventRepo.save(e);
	}
	
	//delete an event
	public void deleteEvent(Long eventId) {
		eventRepo.deleteById(eventId);
	}
}
