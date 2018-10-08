package com.web.thecode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class TheCode {
	@RequestMapping("")
	public String home() {
		return "index.jsp";
	}
	
	@RequestMapping("code")
	public String code() {
		return "code.jsp";
	}
	
	@RequestMapping(value="tryCode", method=RequestMethod.POST)
	public String tryCode(@RequestParam(value="code") String code) {
		if(code.equals("bushido")) {			
			return "redirect:/code";
		}else {
			return "redirect:/codeError";
		}
	}
	@RequestMapping("codeError")
	public String codeError(RedirectAttributes redirectAtt) {
		redirectAtt.addFlashAttribute("error", "You must train harder!");
		return "redirect:/";
	}
	
	
}
