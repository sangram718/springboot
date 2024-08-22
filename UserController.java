package com.sangram.stock.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sangram.stock.model.Users;
import com.sangram.stock.service.JwtService;
import com.sangram.stock.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    @Autowired
    private JwtService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;
    
    @PostMapping("register")
    public Users register(@RequestBody Users user){
        return service.saveUser(user);
    }

    @PostMapping("login")
    public String login(@RequestBody Users user){

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if(authentication.isAuthenticated())
        return jwtService.generateToken(user.getUsername());
        else
        return "failed";
    }
    
}
