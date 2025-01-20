package com.shaik.acknowledge.JDBCwithspring.service;

import com.shaik.acknowledge.JDBCwithspring.model.User;
import com.shaik.acknowledge.JDBCwithspring.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRespository userRespository;

    public void saveUser(String userName, Integer age){
        userRespository.saveUser(userName, age);
    }

    public List<User> getAllUsers(){
        return userRespository.getAllUsers();
    }
}
