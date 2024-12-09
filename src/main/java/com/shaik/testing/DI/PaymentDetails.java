package com.shaik.testing.DI;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class PaymentDetails {

    private Integer id;
    private Integer type;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }


    public PaymentDetails(){
        System.out.println("*************************** PaymentDetails object created ***************************");
    }
}
