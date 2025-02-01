package com.shaik.acknowledge.security.service;

import com.shaik.acknowledge.security.domain.AuthDetails;
import com.shaik.acknowledge.security.repository.AuthDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthRegisterService {

    @Autowired
    private AuthDetailsRepository authDetailsRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public AuthDetails register(AuthDetails authDetails) {
        authDetails.setAuthPassword(encoder.encode(authDetails.getAuthPassword()));
        return authDetailsRepository.save(authDetails);
    }
}
