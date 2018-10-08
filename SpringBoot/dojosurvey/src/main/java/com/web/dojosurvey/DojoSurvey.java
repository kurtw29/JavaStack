package com.web.dojosurvey;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class DojoSurvey {
	@RequestMapping("")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping(value="result", method=RequestMethod.POST)
	public String result(Model model, @RequestParam(value="name") String name, @RequestParam(value="location") String location, @RequestParam(value="language") String language, @RequestParam(value="comment", required=false) String comment) {
		model.addAttribute("name", name);
		model.addAttribute("location", location);
		model.addAttribute("language", language);
		model.addAttribute("comment", comment);
		if(language.equals("java")) {
			return "javaResult.jsp";
		}else {
		return "result.jsp";
		}
	}
	
	@RequestMapping("procSurvey")
	public String procSurvey() {
		return "redirect:/result";
	}
}
