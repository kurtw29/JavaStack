package com.web.events.services;

import org.springframework.stereotype.Service;

import com.web.events.models.Event;
import com.web.events.models.Message;
import com.web.events.models.User;
import com.web.events.repositories.MessageRepository;

@Service
public class MessageService {
	private final MessageRepository messageRepo;
	
	public MessageService(MessageRepository messageRepo) {
		this.messageRepo = messageRepo;
	}
	
	//create & save a message
	public Message createMessage(String message, Event e, User u) {
		Message m = new Message(message, e, u);
		return messageRepo.save(m);
	}
	
	//retrieve all messages
	public Iterable<Message> findAll(){
		return messageRepo.findAll();
	}
}
