package com.web.events.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web.events.models.Event;
import com.web.events.models.User;
import com.web.events.services.EventService;
import com.web.events.services.MessageService;
import com.web.events.services.UserService;
import com.web.events.validator.EventValidator;

@Controller
@RequestMapping("/events")
public class EventsController {
	//dependencies injection
	private final UserService userServ;
	private final EventService eventServ;
	private final MessageService messageServ;
	private final EventValidator eventValidator;
	//constructor for dependencies injection
	public EventsController(UserService userServ, EventService eventServ, MessageService messageServ, EventValidator eventValidator) {
		this.userServ = userServ;
		this.eventServ = eventServ;
		this.messageServ = messageServ;
		this.eventValidator = eventValidator;
	}
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, orderDateEditor);
	}
	
	
	//serve dashboard-events jsp;
	@RequestMapping("")
	public String dashboard(HttpSession session, Model model, @ModelAttribute("event") Event event) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		User loggedUser = userServ.findUserById((Long) session.getAttribute("userId"));
		//If unable to find User from the session UserID - redirect back to loginReg
		if(loggedUser == null) {
			return "redirect:/";
		}
		//otherwise - model User and serve dashboard jsp	
		model.addAttribute("logUser", loggedUser);
		//list of all events with the same state as user's
		List<Event> sameStateEvents = eventServ.findByState(loggedUser.getState());
		model.addAttribute("sameStateEvents", sameStateEvents);
		//list of all events NOT in same state as user's
		List<Event> otherStateEvents = eventServ.findByStateNot(loggedUser.getState());
		model.addAttribute("otherStateEvents", otherStateEvents);
		return "dashboardEvent.jsp";
	}
	
	//joining user to the event
	@RequestMapping("/{eventId}/join")
	public String join(@PathVariable("eventId") Long eventId, HttpSession session) {
		//find User via session.userId
		User user = userServ.findUserById((Long)session.getAttribute("userId"));
		eventServ.addAttendee(eventId, user);
		//find event via "eventId"
		return "redirect:/events";
	}
	
	//cancelling user from the event
	@RequestMapping("/{eventId}/cancel")
	public String cancel(@PathVariable("eventId") Long eventId, HttpSession session) {
		//find User via session.userId
		User user = userServ.findUserById((Long)session.getAttribute("userId"));
		eventServ.removeAttendee(eventId, user);
		return "redirect:/events";
	}
	
	//deleting event
	@RequestMapping("/{eventId}/delete")
	public String delete(@PathVariable("eventId") Long eventId, HttpSession session) {
		//find the event to delete
		Event eventToDelete = eventServ.findEventById(eventId);
		//check if host == logged user
		Long uId = (Long) session.getAttribute("userId");
		if(eventToDelete.getHost().getId() == uId) {
			//eventService.deleteById(eventId)
			eventServ.deleteEvent(eventId);			
		}
		return "redirect:/events";
	}
	
	//creating event
	@PostMapping("/create")
	public String createEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, Model model, HttpSession session) { //@Valid @ModelAttribute
		User loggedUser = userServ.findUserById((Long) session.getAttribute("userId"));
		eventValidator.validate(event, result);
		if(result.hasErrors()) {
			//***if there's error in Event Form - return along with all other information: **
			//If unable to find User from the session UserID - redirect back to loginReg
			if(loggedUser == null) {
				return "redirect:/";
			}
			//otherwise - model User and serve dashboard jsp	
			model.addAttribute("logUser", loggedUser);
			//list of all events with the same state as user's
			List<Event> sameStateEvents = eventServ.findByState(loggedUser.getState());
			model.addAttribute("sameStateEvents", sameStateEvents);
			//list of all events NOT in same state as user's
			List<Event> otherStateEvents = eventServ.findByStateNot(loggedUser.getState());
			model.addAttribute("otherStateEvents", otherStateEvents);
			return "dashboardEvent.jsp";
		}
		//save Event
		event.setHost(loggedUser);
		eventServ.createEvent(event);
		return "redirect:/events";
	}
	
	//serve edit-event jsp
	@RequestMapping("/{id}/edit")
	public String editEvent(@PathVariable("id") Long eventID, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		Event event = eventServ.findEventById(eventID);
		model.addAttribute("event", event);
		model.addAttribute("eventId", event.getId());
		return "editEvent.jsp";
	}
	
	//process POST/PUT update event
	@PutMapping("/{eventId}/update")
	public String updateEvent(@PathVariable("eventId") Long eventId, @Valid @ModelAttribute("event") Event event, BindingResult result, Model model) {
		eventValidator.validate(event, result);
		if(result.hasErrors()) {
			return "editEvent.jsp";
		}else {
			eventServ.updateEvent(eventId, event);
		return "redirect:/events";
		}
	}

	//serve detail-event jsp
	@RequestMapping("/{id}")
	public String detailEvent(@PathVariable("id") Long eventId, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		//get Event by eventId & pass the event info to jsp
		Event event = eventServ.findEventById(eventId);
		model.addAttribute("event", event);
		//get list of messages & pass message list to jsp
		model.addAttribute("messages", event.getMessages());
		return "detailEvent.jsp";
	}
	
	//process POST create a message
	@PostMapping("/{eventId}/message")
	public String createMessage(HttpSession session, @RequestParam("message") String message, @PathVariable("eventId") Long eventId, RedirectAttributes redirectAttributes, Model model) {
		if(message.length() <= 0) {
			redirectAttributes.addFlashAttribute("error", "Cannot Submit a blank message");
			model.addAttribute("event", eventServ.findEventById(eventId));
			return "redirect:/events/"+eventId;			
		}else {
			Event e = eventServ.findEventById(eventId);
			User u = userServ.findUserById((Long)session.getAttribute("userId"));
			//save message
			messageServ.createMessage(message, e, u );
			model.addAttribute("event", eventServ.findEventById(eventId));
			return "redirect:/events/"+eventId;
		}
	}
}
