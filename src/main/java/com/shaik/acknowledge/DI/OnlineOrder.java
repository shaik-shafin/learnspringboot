package com.shaik.acknowledge.DI;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Lazy
@Primary
public class OnlineOrder implements Order {

    @Override
    public void placeOrder() {
        System.out.println("Online order placed");
    }


    public OnlineOrder() {
        System.out.println("*************************** OnlineOrder object created ***************************");
    }
}
