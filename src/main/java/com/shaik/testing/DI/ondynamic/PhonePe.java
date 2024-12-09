package com.shaik.testing.DI.ondynamic;

public class PhonePe implements Payment {

    public PhonePe() {
        System.out.println("*************************** PhonePe object created ***************************");
    }

    public void pay() {
        System.out.println("PhonePe payment done");
    }
}
