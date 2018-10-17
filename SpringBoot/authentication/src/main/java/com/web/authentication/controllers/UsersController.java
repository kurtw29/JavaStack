package com.web.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.authentication.models.User;
import com.web.authentication.services.UserService;
import com.web.authentication.validator.UserValidator;

@Controller
public class UsersController {
	private final UserService userServ;
	private final UserValidator userValidator;
	
	public UsersController(UserService userServ, UserValidator userValidator) {
		this.userServ = userServ;
		this.userValidator = userValidator;
	}
	//redirect
	@RequestMapping("/")
	public String index() {
		return "testing.jsp";
	}
	//serve registration-page jsp
	@RequestMapping("/registration")
	public String registerForm(@ModelAttribute("user") User user) {
		System.out.println("arrived at /registration");
		return "registrationPage.jsp";
	}
	
	//serve login-page jsp
	@RequestMapping("/login")
	public String login() {
		return "loginPage.jsp";
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		userValidator.validate(user, result);
		//if result has error, return the registration page
		if(result.hasErrors()) {
			return "registrationPage.jsp";
		}else {
			// else, save the user in the database, save the user id in session, and redirect them to the /home route
			User u = userServ.registerUser(user);
			session.setAttribute("userId", u.getId());
			return "redirect:/home";
		}
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
		// if the user is authenticated, save their user id in session
		if(userServ.authenticateUser(email, password)) {
			User user = userServ.findByEmail(email);
			session.setAttribute("userId", user.getId());
			return "redirect:/home";
		}else {
			// else, add error messages and return the login page
			model.addAttribute("error", "Unable to log in");
			return "loginPage.jsp";
		}
	}
	
	@RequestMapping("/home")
	public String home(HttpSession session, Model model) {
		if(session.getAttribute("userId") != null) {
			model.addAttribute("user", userServ.findById((Long)session.getAttribute("userId")));
			return "homePage.jsp";
		}else {
			return "redirect:/login";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}
