package com.web.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Counter {
	@RequestMapping("")
	public String welcome(HttpSession session) {
		int count;
		if(session.getAttribute("count") == null) {
			count = 1;
		}else {
			count = (int)session.getAttribute("count") + 1;
		}
		session.setAttribute("count", count);
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
}
