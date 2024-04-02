package com.example.ovi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.ovi.dao.Questiondao;
import com.example.ovi.dao.Quizdao;
import com.example.ovi.model.Question;
import com.example.ovi.model.QuestionWrapper;
import com.example.ovi.model.Quiz;
import com.example.ovi.model.Response;

@Service
public class Quizservice {
	
	@Autowired
	Quizdao quizd;
	@Autowired
	Questiondao qd;

	public ResponseEntity<String> createquiz(String category, int numQ, String title) {
		
		
		
		
		List<Question> questions=qd.findRandomQuestionByCategory(category,numQ);
		
		Quiz qzm = new Quiz();
		
		qzm.setTitle(title);
		qzm.setQuestion(questions);
		
		quizd.save(qzm);
		
		return new ResponseEntity<>("created",HttpStatus.CREATED);
	}
	
	// it returns only the question part

	public ResponseEntity<List<QuestionWrapper>> getquizquestion(int id) {

		Optional<Quiz> quiz = quizd.findById(id);

		List<Question> questionfromDB = quiz.get().getQuestion();
		List<QuestionWrapper> questionforuser = new ArrayList<>();

		for (Question q : questionfromDB) {

			QuestionWrapper qrap = new QuestionWrapper(q.getId(), q.getQuestiontitle(), q.getOption1(), q.getOption2(),
					q.getOption3(), q.getOption4());
			;

			questionforuser.add(qrap);
		}

		return new ResponseEntity<>(questionforuser, HttpStatus.FOUND);

	}

	//it returns all the attribute of the question
	
	public Optional<List<Question>> getquizquestionall(int id) {
		
		   
		Optional<Quiz> quiz= quizd.findById(id);
		
		
		List<Question> qu= quiz.get().getQuestion();
		
		Optional<List<Question>> quizC=convertListToOptional(qu);
		
		return  quizC;
			
	}
		
	public Optional<List<Question>> convertListToOptional(List<Question> myList) {
        return Optional.ofNullable(myList);
    }

	public Optional<Quiz>  getquizquestionallwithqdata(int id) {
		
		return  quizd.findById(id);
	}

	public Integer calculateresult(int id, List<Response> response) {
		Quiz quiz= quizd.findById(id).get();
		
		List<Question> questions= quiz.getQuestion();
		
		int i=0;
		int right=0;
		
		for (Response res:response) {
			System.out.println(res.getId()+res.getResponse());
			if (res.getResponse().equals(questions.get(0).getRightanswere()))
				System.out.println(right);
			right++;
								
					
			 
				
			
			
			i++;
		}
		
		return right;
	
	}
	

}
