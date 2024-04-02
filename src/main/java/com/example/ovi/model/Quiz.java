package com.example.ovi.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import lombok.Data;

@Entity

public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String title;
	@ManyToMany
	private List<Question> questionT;
	
	
	
	
	
	
	
	
	
	
	
	

	public Quiz() {
		super();
	}

	public Quiz(Integer id, String title, List<Question> questionT) {
		super();
		this.id = id;
		this.title = title;
		this.questionT = questionT;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Question> getQuestion() {
		return questionT;
	}

	public void setQuestion(List<Question> question) {
		this.questionT = question;
	}

}
