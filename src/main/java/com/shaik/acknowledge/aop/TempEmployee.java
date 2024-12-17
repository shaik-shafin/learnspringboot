package com.shaik.acknowledge.aop;

import org.springframework.stereotype.Service;

@Service
public class TempEmployee implements IEmployee {

    @Override
    public void doWork() {
        System.out.println("Temp employee working");
    }
}
