package com.shaik.acknowledge.DI;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class OfflineOrder implements Order{

    @Override
    public void placeOrder() {
        System.out.println("Offline order placed");
    }


    public OfflineOrder() {
        System.out.println("*************************** OfflineOrder object created ***************************");
    }
}
