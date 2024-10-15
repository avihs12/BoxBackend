package com.boxproject.backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.boxproject.backend.Entities.Userr;
import com.boxproject.backend.Repos.UserRepository;

@Component
public class UserDetailsI implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    private Userr emp;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Userr user = userRepository.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("could not find user");
        }
        return new UserDetailsEntity(user);
    }

}
