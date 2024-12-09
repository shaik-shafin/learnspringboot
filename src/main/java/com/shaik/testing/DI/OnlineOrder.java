package com.shaik.testing.DI;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class OnlineOrder implements Order {

    @Override
    public void placeOrder() {
        System.out.println("Online order placed");
    }


    public OnlineOrder() {
        System.out.println("*************************** OnlineOrder object created ***************************");
    }
}
