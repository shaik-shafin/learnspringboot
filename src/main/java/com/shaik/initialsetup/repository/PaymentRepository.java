package com.shaik.initialsetup.repository;

import com.shaik.initialsetup.dto.PaymentRequest;
import com.shaik.initialsetup.entity.PaymentEntity;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentRepository {

    public PaymentEntity getPaymentDetails(PaymentRequest paymentRequest){

        PaymentEntity paymentEntity = getPaymentEntity(paymentRequest);
        return paymentEntity;
    }

    private PaymentEntity getPaymentEntity(PaymentRequest paymentRequest){

        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setCardId(paymentRequest.getPaymentId());
        paymentEntity.setPaymentCurrency("INR");
        paymentEntity.setPaymentAmount(100.00);
        paymentEntity.setUserEmail("shaik.shafin057@gmail.com");

        return paymentEntity;
    }
}
