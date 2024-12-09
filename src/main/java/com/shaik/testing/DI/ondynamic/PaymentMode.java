package com.shaik.testing.DI.ondynamic;

import java.util.ArrayList;
import java.util.List;

public enum PaymentMode {

    PHONE_PE(1, "PhonePe"),
    PAYTM(2, "Paytm");

    private int id;
    private String name;

    PaymentMode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static PaymentMode getPaymentMode(int id) {
        for (PaymentMode paymentMode : PaymentMode.values()) {
            if (paymentMode.getId() == id) {
                return paymentMode;
            }
        }
        return null;
    }

    public static PaymentMode getPaymentMode(String name) {
        for (PaymentMode paymentMode : PaymentMode.values()) {
            if (paymentMode.getName().equals(name)) {
                return paymentMode;
            }
        }
        return null;
    }

    public static List<PaymentMode> getPaymentModes() {
        List<PaymentMode> paymentModes = new ArrayList<>();
        for (PaymentMode paymentMode : PaymentMode.values()) {
            paymentModes.add(paymentMode);
        }
        return paymentModes;
    }
}
