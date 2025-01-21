package com.shaik.acknowledge.jpa.controller;

import com.shaik.acknowledge.jpa.domain.UserDetails;
import com.shaik.acknowledge.jpa.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpa")
public class HomeController {

    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping("get-all-users")
    public List<UserDetails> getAllUsers(){
        return userDetailsService.getAllUserDetails();
    }

    @PostMapping("create-user")
    public String saveUserDetails(@RequestBody UserDetails userDetails) {
        userDetailsService.saveUserDetails(userDetails);

        return "User details saved successfully";
    }

    @PutMapping("update-user/{userId}")
    public void updateUserDetails(@PathVariable Integer userId){

    }

    @DeleteMapping("delete-user/{userId}")
    public void deleteUserDetails(@PathVariable Integer userId){

    }
}
