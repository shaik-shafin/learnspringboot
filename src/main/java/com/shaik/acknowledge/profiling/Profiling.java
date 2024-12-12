package com.shaik.acknowledge.profiling;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("qa")
public class Profiling {


    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;

    @PostConstruct
    public void postConstruct(){
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        System.out.println("************************** " + this.getClass().getSimpleName() +" **************************");
    }
}
