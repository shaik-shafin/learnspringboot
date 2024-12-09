package com.shaik.config;

import com.shaik.testing.DI.ondynamic.PaymentMode;
import com.shaik.testing.DI.ondynamic.Payment;
import com.shaik.testing.DI.ondynamic.Paytm;
import com.shaik.testing.DI.ondynamic.PhonePe;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig1 {

    @Bean
    public Payment getPayment(@Value("${payment.mode}") String paymentMode) {

        if(paymentMode.equals(PaymentMode.PAYTM.getName())){
            return new Paytm();
        }else if(paymentMode.equals(PaymentMode.PHONE_PE.getName())){
            return new PhonePe();
        }else{
            return null;
        }
    }
}