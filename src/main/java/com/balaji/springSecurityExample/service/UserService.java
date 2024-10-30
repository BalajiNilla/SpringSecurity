package com.balaji.springSecurityExample.service;

import com.balaji.springSecurityExample.model.Users;
import com.balaji.springSecurityExample.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService
{

    @Autowired
    private UserRepository repo;

    public Users register(Users user)
    {
        user.setPassword(new BCryptPasswordEncoder(12).encode(
                user.getPassword()
        ));
        return repo.save(user);

    }
}
