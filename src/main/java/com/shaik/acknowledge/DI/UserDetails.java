package com.shaik.acknowledge.DI;

import com.shaik.acknowledge.DI.ondynamic.Payment;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class UserDetails {


    private Integer id;

    private String name;

    private final OrderItem orderItem;

    @Lazy
    @Autowired
    private PaymentDetails paymentDetails;

    @Autowired
    private Order order;

    @Autowired
    private Payment payment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Autowired
    public UserDetails(OrderItem orderItem) {
        this.orderItem = orderItem;
        System.out.println("************************************* UserDetails constructor created *************************************");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Call Payment Details id method and let spring to initialize the obj = " + paymentDetails.getId());
    }
}
