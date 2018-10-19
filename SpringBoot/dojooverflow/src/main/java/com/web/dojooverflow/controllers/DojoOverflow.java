package com.web.dojooverflow.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web.dojooverflow.models.Answer;
import com.web.dojooverflow.models.Question;
import com.web.dojooverflow.models.Tag;
import com.web.dojooverflow.services.AnswerService;
import com.web.dojooverflow.services.QuestionService;
import com.web.dojooverflow.services.TagService;

@Controller
public class DojoOverflow {
	QuestionService questionServ;
	AnswerService answerServ;
	TagService tagServ;
	public DojoOverflow(QuestionService questionServ, TagService tagServ, AnswerService answerServ) {
		this.questionServ = questionServ;
		this.answerServ = answerServ;
		this.tagServ = tagServ;		
	}
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/questions";
	};
	
	//serve display-all-questions jsp
	@RequestMapping("/questions")
	public String display(Model model) {
		model.addAttribute("questions", questionServ.findAll());
		model.addAttribute("tags", tagServ.findAll());
		return "index.jsp";
	}
	
	//serve new question-form jsp
	@RequestMapping("/questions/new")
	public String newQuestion(){
		return "newQuestion.jsp";
	};
	
	//proc POST question-form
	@RequestMapping(value="/questions/create", method=RequestMethod.POST)
	public String createQuestion(@RequestParam("question") String question, @RequestParam("tags") String tag, RedirectAttributes redirectAttributes) {
		//check if submitted "question" is empty or not
		if(!question.isEmpty()) {
			//create question
			Question savedQ = questionServ.create(question);
			//check if there are any tags"
			if(tag.length()>0) {
				//if there are tags, split the string into array of string tags
				String[] tagArr = tag.split("[,\\s\\.-_+]+");
				System.out.println("POST newQuestion - tagArr: "+tagArr);
				if(tagArr.length > 3) {
					//if there are more than 3 tags, send back flash error message
					redirectAttributes.addFlashAttribute("tagError", "Cannot enter more than 3 tags");
					return "redirect:/questions/new";
				}else {
					//if tagArr is less than 3 tags, loop through string[]
					System.out.println("what is tagArr: "+ tagArr);
					for(String tagStr:tagArr) {
						tagStr = tagStr.trim().toLowerCase();
						System.out.println("what is tagStr: "+ tagStr);
						//check if this tag already exists in database
						Tag t = tagServ.findTagBySubject(tagStr);
						if(t == null) {
							System.out.println("tag is not in DATABASE");
							//if tag does NOT exists -> save tag
							t = tagServ.createTag(tagStr);
//							questionServ.addTag(savedQ.getId(), t);
						}
						//add the tags into the question's List<tag>
						System.out.println("Adding tags - what is savedQ.getID(): "+ savedQ.getId());
//						tagServ.addToQuestion(savedQ, t);
						questionServ.addTag(savedQ, t);
						System.out.println("FINISH ADDING tag("+savedQ.getTags()+")");
						
					}
				}
			}
			return "redirect:/questions";
		}else {
			redirectAttributes.addFlashAttribute("questionError", "Question cannot be blank!");
			return "redirect:/questions/new";
		}
	}
	
	//serve question-detail & answers-list & new answer-form
	@RequestMapping("/questions/{id}")
	public String showQuestion(@PathVariable("id") Long id, Model model, @ModelAttribute("answerForm")Answer answer){
		model.addAttribute("question", questionServ.findById(id));
		return "showQuestion.jsp";
	};
	
	//proc POST answer-form
	@RequestMapping(value="/answers/create/{id}", method=RequestMethod.POST)
	public String creatAnswer(@Valid @ModelAttribute("answerForm") Answer answer, BindingResult result, @PathVariable("id") Long id, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("question", questionServ.findById(id));
			return "showQuestion.jsp";
		}else {
			answer.setQuestion(questionServ.findById(id));
			Answer ans = answerServ.createAnswer(answer);
			System.out.println("Created answer answer.getAnswer():"+ans.getAnswer());
			return "redirect:/questions/"+answer.getQuestion().getId(); //{question.id}
		}
	}
}
