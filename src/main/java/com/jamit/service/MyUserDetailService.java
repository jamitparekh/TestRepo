package com.jamit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jamit.model.User;
import com.jamit.repository.UserRepository;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository UserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = UserRepository.findByUsername(username);
		if(user == null)
			throw new UsernameNotFoundException("user not found");
		return new UserPrincipal(user);
	}

}
