package com.balaji.springSecurityExample.service;

import com.balaji.springSecurityExample.model.Users;
import com.balaji.springSecurityExample.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService
{

    @Autowired
    private UserRepository repo;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jservice;

    public Users register(Users user)
    {
        user.setPassword(new BCryptPasswordEncoder(12).encode(
                user.getPassword()
        ));
        return repo.save(user);

    }

    public String verify(Users user) {
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if(authentication.isAuthenticated()){

            return jservice.generateToken(user.getUsername());
        }
        else
        {
         return "not found";
        }
    }
}
