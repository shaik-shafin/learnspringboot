package com.shaik.acknowledge.JDBCwithspring.controller;

import com.shaik.acknowledge.JDBCwithspring.model.User;
import com.shaik.acknowledge.JDBCwithspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jdbc-with-spring")
public class HomeController {

    @Autowired
    private UserService userService;

    @PostMapping("create-user")
    public String createUser(@RequestParam String userName, @RequestParam Integer userAge){

        userService.saveUser(userName, userAge);
        return "user created successfully";
    }

    @GetMapping("get-all-users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
}
