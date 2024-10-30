package com.balaji.springSecurityExample.controller;


import com.balaji.springSecurityExample.model.Users;
import com.balaji.springSecurityExample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController
{
    @Autowired
    private UserService service;
    @PostMapping("/user/register")
    public Users register(@RequestBody Users user)
    {
        return service.register(user);
    }
}
