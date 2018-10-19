package com.web.dojooverflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.web.dojooverflow.models.Question;
import com.web.dojooverflow.models.Tag;
import com.web.dojooverflow.repositories.QuestionRepository;

@Service
public class QuestionService {
	private final QuestionRepository questionRepo;
	
	public QuestionService(QuestionRepository questionRepo) {
		this.questionRepo = questionRepo;
	}
	
	//retrieve all the questions
	public Iterable<Question> findAll(){
		return questionRepo.findAll();
	}
	
	//retrieve a question by id
	public Question findById(Long id) {
		return questionRepo.findQuestionById(id);
	}
	
	//create a question given String question
	public Question create(String question) {
		Question q = new Question();
		q.setQuestion(question);
		return questionRepo.save(q);
	}
	
	
	//Add a tag to the question
	public void addTag(Question q, Tag tag) {
//		Question q = questionRepo.findQuestionById(qId);
//		System.out.println("QuestionService // addTag() what is q.getId(): "+q.getId());
//		System.out.println("QuestionService // addTag() what is tag.getSubject(): "+tag.getSubject());
//		System.out.println("QuestionService // addTag() what is q.getTags(): "+q.getTags());
//		//list of Tags of a question:
//		List<Tag> qList = q.getTags();
//		qList.add(tag);
		q.getTags().add(tag);
		questionRepo.save(q);
	}
}
