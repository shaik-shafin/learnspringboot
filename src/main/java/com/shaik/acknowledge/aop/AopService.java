package com.shaik.acknowledge.aop;

import org.springframework.stereotype.Service;

@Service
public class AopService {

    public void printMessage(){
        System.out.println("printMessage() called :");
    }
}
