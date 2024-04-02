package com.example.ovi.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.type.TrueFalseConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ovi.model.Question;

@Repository
public interface Questiondao extends JpaRepository<Question, Long> {

	

	List<Question> findBycategory(String category);
	
	

	@Query(value="select * from question where category=:category ORDER BY  RAND () LIMIT :numQ ",nativeQuery = true)
	List<Question> findRandomQuestionByCategory(String category, int numQ);



	
	
	
	
	
}
