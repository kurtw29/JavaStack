package com.web.events.validator;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.web.events.models.Event;


@Component
public class EventValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Event.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Event event = (Event) target;
		Date currentDate = new Date();
		if(event.getDate().compareTo(currentDate)<0) {
			errors.rejectValue("date", "Future");
		}
	}
	
}
