package com.example.ovi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.ovi.dao.Questiondao;
import com.example.ovi.model.Question;

@Service
public class QuestionService {

	@Autowired
	Questiondao qd;


	public ResponseEntity<List<Question>> getAlldata() {
		
		try {

		return  new ResponseEntity(qd.findAll(),HttpStatus.FOUND);

		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity(new ArrayList<>(),HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<List<Question>>  getdataBycategory(String category) {
		
		try {

		return   new ResponseEntity<>(qd.findBycategory(category),HttpStatus.FOUND);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return   new ResponseEntity<>(new ArrayList<>(),HttpStatus.NOT_FOUND);
	}
	

	public ResponseEntity<String>addquestion(Question question) {

		try {
		qd.save(question);

		return   new ResponseEntity<>("success",HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(" ",HttpStatus.NOT_IMPLEMENTED);
	}

	public Optional<Question> getdataByid(Long id) {
		return qd.findById(id);

	}

	public String deletedataByid(Long id) {
		qd.deleteById(id);
		return "delete completed";

	}

}
