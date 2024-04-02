package com.example.ovi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ovi.model.Question;
import com.example.ovi.model.QuestionWrapper;
import com.example.ovi.model.Quiz;
import com.example.ovi.model.Response;
import com.example.ovi.service.Quizservice;

@RestController
@RequestMapping("quiz")
public class QuizController {
	
@Autowired
	Quizservice qs;
	
	@PostMapping("createquiz")
	ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ,@RequestParam String title) {

		return qs.createquiz(category,numQ,title);

	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<List<QuestionWrapper> > getquizquestion(@PathVariable int id){
		
		return  qs.getquizquestion(id);
		
	}
	
	@GetMapping("getq/{id}")
	public Optional<List<Question>> getquizquestions(@PathVariable int id){
		
		return  qs.getquizquestionall(id);
		
	}
	
	@GetMapping("getqaq/{id}")
	public Optional<Quiz> getquizquestionsal(@PathVariable int id){
		
		return  qs.getquizquestionallwithqdata(id);
		
	}
	
	@PostMapping("/submit/{id}")
	public Integer submitquiz(@PathVariable int id,@RequestBody List<Response> response) {
		
		return qs.calculateresult(id, response);
	}
	
	
	
}
