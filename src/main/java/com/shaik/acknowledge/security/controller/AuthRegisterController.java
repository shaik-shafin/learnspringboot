package com.shaik.acknowledge.security.controller;


import com.shaik.acknowledge.security.domain.AuthDetails;
import com.shaik.acknowledge.security.service.AuthRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthRegisterController {

    @Autowired
    private AuthRegisterService authRegisterService;

    @PostMapping("register")
    public AuthDetails register(@RequestBody AuthDetails authDetails){

        return authRegisterService.register(authDetails);
    }

    @PostMapping("login")
    public String login(@RequestBody AuthDetails authDetails){

        return authRegisterService.verify(authDetails);
    }
}
