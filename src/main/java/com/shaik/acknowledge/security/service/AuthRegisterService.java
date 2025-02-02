package com.shaik.acknowledge.security.service;

import com.shaik.acknowledge.security.domain.AuthDetails;
import com.shaik.acknowledge.security.repository.AuthDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthRegisterService {

    @Autowired
    private AuthDetailsRepository authDetailsRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    public AuthDetails register(AuthDetails authDetails) {
        authDetails.setAuthPassword(encoder.encode(authDetails.getAuthPassword()));
        return authDetailsRepository.save(authDetails);
    }

    public String verify(AuthDetails authDetails) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authDetails.getAuthName(), authDetails.getAuthPassword()));

        if(authentication.isAuthenticated())
            return jwtService.generateToken(authDetails);

        return "fails";
    }
}
