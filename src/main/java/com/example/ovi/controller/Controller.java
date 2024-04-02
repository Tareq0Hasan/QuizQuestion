package com.example.ovi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ovi.model.Question;
import com.example.ovi.service.QuestionService;

@RestController
@RequestMapping("/question")
public class Controller {
	@Autowired
	QuestionService qs;
	
	@GetMapping("/getall")
	public ResponseEntity<List<Question>>  getallQuestion() {
		
		return qs.getAlldata();		
	}
	
	
	@GetMapping("/")
	public String getindex() {
		
		return "heello";		
	}
	
	@GetMapping("/category/{category}")
	public ResponseEntity<List<Question>> getquestionBycategory(@PathVariable String category ){
		
		return qs.getdataBycategory(category);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String>  addquestion(@RequestBody Question question) {
		 
		 return qs.addquestion(question);
	}
	
	@GetMapping("/databyid/{id}")
	public Optional<Question> getdataByid(@PathVariable Long id){
		
		return qs.getdataByid(id);
	}
	
	@DeleteMapping    ("/deletebyid/{id}")
	public String deletedata(@PathVariable Long id) {
		
		return qs.deletedataByid(id);
	}
	

	
	
	
}
