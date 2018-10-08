package com.web.displaydate;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DisplayDate {
	@RequestMapping("")
	public String home() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		String dayOfWeek = new SimpleDateFormat("EEEE").format(new Date()).toString();
		String dateOfMonth = new SimpleDateFormat("dd").format(new Date()).toString();
		String month = new SimpleDateFormat("MMMM").format(new Date()).toString();
		String year = new SimpleDateFormat("YYYY").format(new Date()).toString();
		model.addAttribute("date", dayOfWeek+", the "+dateOfMonth+" of "+month+", "+year);
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		String time = new SimpleDateFormat("h:mm a").format(new Date()).toString();
		model.addAttribute("time", time);
		return "time.jsp";
	}
}
