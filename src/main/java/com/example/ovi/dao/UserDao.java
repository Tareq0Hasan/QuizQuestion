package com.example.ovi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.ovi.model.Mst_user;

@Repository

public interface UserDao extends JpaRepository<Mst_user, Integer> {

	Mst_user findByEmail(String email);

}
