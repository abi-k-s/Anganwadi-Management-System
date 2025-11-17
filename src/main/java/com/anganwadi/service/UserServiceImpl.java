package com.anganwadi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.anganwadi.model.Users;
import com.anganwadi.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Users findByUsername(String username) {
		return userRepository.findByUsername(username);// .orElse(null);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userRepository.findByUsername(username);
		/*
		 * .orElseThrow(() -> new UsernameNotFoundException("User not found")); return
		 * new UserDetailsImpl(user);
		 */

		if (user == null) {
			System.out.println("User not found");
			throw new UsernameNotFoundException("User not found");
		}
		return new UserDetailsImpl(user);

	}

}
