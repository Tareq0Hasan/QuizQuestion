package com.example.ovi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ovi.model.Quiz;

@Repository
public interface Quizdao extends JpaRepository<Quiz, Integer> {

}
