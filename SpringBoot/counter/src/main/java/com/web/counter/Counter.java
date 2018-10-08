package com.web.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/")
public class Counter {
	@RequestMapping("")
	public String welcome(HttpSession session) {
		int count;
		int countTwo;
		if(session.getAttribute("count") == null) {
			count = 1;
		}else {
			count = (int)session.getAttribute("count") + 1;
		}
		session.setAttribute("count", count);
		
		if(session.getAttribute("countTwo") == null) {
			countTwo = 2;
		}else {
			countTwo = (int)session.getAttribute("countTwo") + 2;
		}
		session.setAttribute("count", count);
		session.setAttribute("countTwo", countTwo);
		return "welcome.jsp";
	}
	
	@RequestMapping("counter")
	public String counter(Model model, HttpSession session) {
		int count = 0;
		if(session.getAttribute("count") != null) {
			count = (int) session.getAttribute("count");
		}
		model.addAttribute("count", count);
		return "counter.jsp";
	}
	
	@RequestMapping("counter2")
	public String counterTwo(Model model, HttpSession session) {
		int countTwo = 0;
		if(session.getAttribute("countTwo") !=null) {
			countTwo = (int) session.getAttribute("countTwo");
		}
		model.addAttribute("countTwo", countTwo);
		return "countTwo.jsp";
	}
	
	@RequestMapping("resetCounter")
	public RedirectView resetCounter(HttpSession session) {
		session.setAttribute("count", 0);
		return new RedirectView("/counter");
	}
	
	@RequestMapping("resetCounterTwo")
	public RedirectView resetCounterTwo(HttpSession session) {
		session.setAttribute("countTwo", 0);
		return new RedirectView("/counter2");
	}
}
