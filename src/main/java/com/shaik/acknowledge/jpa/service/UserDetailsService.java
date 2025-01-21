package com.shaik.acknowledge.jpa.service;

import com.shaik.acknowledge.jpa.domain.UserDetails;
import com.shaik.acknowledge.jpa.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    public void saveUserDetails(UserDetails userDetails) {
        userDetailsRepository.save(userDetails);
    }

    public UserDetails getUserDetails(Integer userId) {
        return userDetailsRepository.findById(userId).orElse(null);
    }

    public List<UserDetails> getAllUserDetails() { return userDetailsRepository.findAll(); }
}
