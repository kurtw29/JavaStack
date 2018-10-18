package com.web.events.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.events.models.User;
import com.web.events.services.UserService;
import com.web.events.validator.UserValidator;

@Controller
public class LoginRegController {
	//dependencies injection
		private final UserService userServ;
		private final UserValidator userValidator;
		//constructor for dependencies injection
		public LoginRegController(UserService userServ, UserValidator userValidator) {
			this.userServ = userServ;
			this.userValidator = userValidator;
		}
		
		//serve login & reg jsp
		@RequestMapping("/")
		public String loginReg(@ModelAttribute("user") User user) {
			return "loginReg.jsp";
		}
		
		//process POST registration
		@RequestMapping(value="/reg", method=RequestMethod.POST)
		public String reg(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
			userValidator.validate(user, result);
			if(result.hasErrors()) {
				return "loginReg.jsp";
			}else {
				User registeredUser = userServ.registerUser(user);
				//save registered user's id in session
				session.setAttribute("userId", registeredUser.getId());
				return "redirect:/events";
			}
		}
		
		//process POST login
		@RequestMapping(value="/login", method=RequestMethod.POST)
		public String login(HttpSession session, @RequestParam("emailLog") String email, @RequestParam("passwordLog") String password, Model model, @ModelAttribute("user") User user) {
			if(!userServ.authenticateUser(email, password)) {
				model.addAttribute("loginError", "Invalid email/password");
				return "loginReg.jsp";
			}else {
				User loggedUser = userServ.findUserByEmail(email);
				session.setAttribute("userId", loggedUser.getId());
				return "redirect:/events";
			}
		}
		
		//logout
		@RequestMapping("/logout")
		public String logout(HttpSession session) {
			session.invalidate();
			return "redirect:/";
		}
}
