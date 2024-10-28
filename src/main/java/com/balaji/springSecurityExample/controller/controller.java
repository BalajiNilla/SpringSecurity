package com.balaji.springSecurityExample.controller;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @GetMapping("/")
    public String hello(HttpServletRequest request){
        return "Welcome to the application "+request.getSession().getId();
    }

}
