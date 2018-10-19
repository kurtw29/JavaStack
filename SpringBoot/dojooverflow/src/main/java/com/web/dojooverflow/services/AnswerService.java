package com.web.dojooverflow.services;

import org.springframework.stereotype.Service;

import com.web.dojooverflow.models.Answer;
import com.web.dojooverflow.repositories.AnswerRepository;

@Service
public class AnswerService {
	private final AnswerRepository answerRepo;
	
	public AnswerService(AnswerRepository answerRepo) {
		this.answerRepo = answerRepo;
	}
	
	//create an answer
	public Answer createAnswer(Answer ans) {
		return answerRepo.save(ans);
	}
}
