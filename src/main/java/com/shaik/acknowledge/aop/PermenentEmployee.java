package com.shaik.acknowledge.aop;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
public class PermenentEmployee implements IEmployee {

    @Override
    public void doWork() {
        System.out.println("Permanent employee working");
    }
}
