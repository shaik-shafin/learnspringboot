package com.shaik.acknowledge.security.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String homePage(HttpServletRequest request){
        return "Hello Welcome. SessionId = " + request.getSession().getId();
    }
}
