package com.esisa.Cardmaster.service;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.esisa.Cardmaster.models.User;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder bcryptEncoder;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.getUser(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}

	public User save( User user) {
		
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		
		return userService.addUser(user);
	}
}