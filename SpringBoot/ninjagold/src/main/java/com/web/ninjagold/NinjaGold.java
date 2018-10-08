package com.web.ninjagold;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NinjaGold {
	public static ArrayList<String> list = new ArrayList<String>();
	@RequestMapping("/")
	public String home() {
		return "redirect:/Gold";
	}
	@RequestMapping("/Gold")
	public String index(HttpSession session, Model model) {
//		Set up the gold counter; gold starts with 0, or equals to existing gold record
		int gold;
		int earned = 0;
		if(session.getAttribute("gold") != null) {
			gold = (int) session.getAttribute("gold");
		}else {
			gold = 0;
		}
//		Check if "farm"/"cave"/"House"/"casino" clicked and add & update gold in session
		if(session.getAttribute("name") != null) {
			if(session.getAttribute("name").equals("farm")){
//			random(between 0-1) * (21-10) + 10
				earned += (int)(Math.random()*11)+10;
				gold += earned;
			}else
				if(session.getAttribute("name").equals("cave")){
//			random(between 0-1) * (11-5) + 5
					earned += (int)(Math.random()*6)+5;
					gold += earned;
				}else
					if(session.getAttribute("name").equals("house")) {
//			random(between 0-1) * (6-2) + 2
						earned += (int)(Math.random()*4)+2;
						gold += earned;
					}else
						if(session.getAttribute("name").equals("casino")) {
//				random(between 0-1) * (50+50+1) - 50
							earned =(int)(Math.random()*101) - 50;
							gold += earned;
						}
		}
		model.addAttribute("gold", gold);
		session.setAttribute("gold", gold);
		String date = new SimpleDateFormat("MMMM d YYYY h:mm a").format(new Date()).toString();
//		model.addAttribute("earned", earned);
//		model.addAttribute("name", session.getAttribute("name"));
//		model.addAttribute("date", date);
		String log = "You entered a "+session.getAttribute("name")+" and earned "+earned+" gold. "+date+" .";
		Collections.reverse(list);
		NinjaGold.list.add(log);
		Collections.reverse(list);
		model.addAttribute("list", NinjaGold.list);
		return "index.jsp";
	}
	
	@RequestMapping("/procGold")
	public String procGold(@RequestParam(value="name") String name, HttpSession session) {
		session.setAttribute("name", name);
		return "redirect:/Gold";
	
	}
}
