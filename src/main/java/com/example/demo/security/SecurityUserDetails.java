package com.example.demo.security;

import com.example.demo.users.UserModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class SecurityUserDetails implements UserDetailsService {

    @Autowired
    UserModelRepository userModelRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("SECURITY DETAILS  " + username);
        UserDetails userDetails = (UserDetails) userModelRepository.findByLogin(username);
        System.out.println("SECURITY DETAILS  " + userDetails.getUsername() + "   " + userDetails.getPassword());
        return userDetails;
    }
}
