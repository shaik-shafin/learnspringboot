package com.shaik.acknowledge.DI.ondynamic;

public class Paytm implements Payment {

    public void pay() {
        System.out.println("Paytm payment done");
    }

    public Paytm() {
        System.out.println("*************************** Paytm object created ***************************");
    }
}
