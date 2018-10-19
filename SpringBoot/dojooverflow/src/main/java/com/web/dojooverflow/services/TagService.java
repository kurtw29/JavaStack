package com.web.dojooverflow.services;

import org.springframework.stereotype.Service;

import com.web.dojooverflow.models.Question;
import com.web.dojooverflow.models.Tag;
import com.web.dojooverflow.repositories.TagRepository;


@Service
public class TagService {
	private final TagRepository tagRepo;
	
	public TagService(TagRepository tagRepo) {
		this.tagRepo = tagRepo;
	}
	
	//Retrieve all the tags
	public Iterable<Tag> findAll(){
		return tagRepo.findAll();
	}
	
	//Create tag
	public Tag createTag(String subject) {
		Tag tag = new Tag(subject);
		return tagRepo.save(tag);
	}
	
	//Retrieve a tag by subject
	public Tag findTagBySubject(String subject) {
		return tagRepo.findTagBySubject(subject);
	}
	
	//Add tag to a question
	public void addToQuestion(Question question, Tag tag) {
		//find tag by ID
		question.getTags().add(tag);
		
		System.out.println("added tag.Subject("+tag.getSubject()+") to questionId("+question.getId()+")");
	}
	
//	
//	//Check if tag already exists
//	public boolean checkTag(Tag tag) {
//		for(Tag t:tagRepo.findAll()) {
//			if(t.getId() == tag.getId()) {
//				return true;
//			}
//		}
//		return false;
//	}
}
