package com.boxproject.backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.boxproject.backend.Entities.Userr;
import com.boxproject.backend.Repos.UserRepository;

@Service
public class JwtUtils implements UserDetailsService {

	@Autowired
	private JwtService jwtService;

	@Autowired
	private UserRepository repo;

	public JwtResponse createJwtToken(AuthRequest authRequest) throws Exception {
		String userName = authRequest.getUsername();
		String Password = authRequest.getPassword();
		String newGeneratedToken = jwtService.generateToken(authRequest.getUsername());

		Userr user = repo.getUserByUsername(userName);
		return new JwtResponse(user, newGeneratedToken);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Userr user = repo.getUserByUsername(username);
		return null;
	}
}
