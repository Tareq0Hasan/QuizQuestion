package com.example.ovi.configuration;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.ovi.model.Mst_user;

public class CustomUser implements UserDetails {

	private static final long serialVersionUID = 1L;
	private Mst_user msuser;

	public CustomUser(Mst_user msuser) {
		super();
		this.msuser = msuser;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority= new SimpleGrantedAuthority(msuser.getRole());
		return Arrays.asList(authority);
	}

	@Override
	public String getPassword() {
		
		return msuser.getPassword();
	}

	@Override
	public String getUsername() {
	
		return msuser.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
	
		return true;
	}

}
