package com.example.ovi.service;



import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.ovi.dao.UserDao;
import com.example.ovi.model.Mst_user;



public class UserService   {
	
		private UserDao uda;
		
		
		/*
		 * @Override public UserDetails loadUserByUsername(String email) throws
		 * UsernameNotFoundException { // Optional<Mst_user> userOptional =
		 * uda.findByEmail(email);
		 * 
		 * return (UserDetails) userOptional.orElseThrow(() -> new
		 * UsernameNotFoundException("User not found")); }
		 */
}
