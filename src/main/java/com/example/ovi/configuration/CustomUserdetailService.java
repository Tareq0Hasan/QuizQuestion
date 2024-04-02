package com.example.ovi.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.ovi.dao.UserDao;
import com.example.ovi.model.Mst_user;

@Component
public class CustomUserdetailService implements UserDetailsService {
	@Autowired
	private UserDao userd;
	

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Mst_user msuser= userd.findByEmail(email);
		if(msuser==null) {
			throw new UsernameNotFoundException("email not found");
		}else {
			return new CustomUser(msuser);
		}
		
		
		
	}

}
