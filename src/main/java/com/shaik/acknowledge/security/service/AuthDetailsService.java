package com.shaik.acknowledge.security.service;

import com.shaik.acknowledge.security.domain.AuthDetails;
import com.shaik.acknowledge.security.model.MyAuthDetails;
import com.shaik.acknowledge.security.repository.AuthDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthDetailsService implements UserDetailsService {

    @Autowired
    private AuthDetailsRepository authDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AuthDetails authDetails = authDetailsRepository.findByAuthName(username);

        if(authDetails == null){
            throw new UsernameNotFoundException("User not found");
        }

        return new MyAuthDetails(authDetails);
    }
}
