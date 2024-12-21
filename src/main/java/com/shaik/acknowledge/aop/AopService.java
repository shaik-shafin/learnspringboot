package com.shaik.acknowledge.aop;

import com.shaik.acknowledge.aop.annotation.MyCustomAnnotation;
import org.springframework.stereotype.Service;

@Service
public class AopService {

    @MyCustomAnnotation(key = 143)
    public void printMessage(){
        System.out.println("printMessage() called :");
    }
}
