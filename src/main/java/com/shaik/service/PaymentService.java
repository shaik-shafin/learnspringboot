package com.shaik.service;

import com.shaik.dto.PaymentRequest;
import com.shaik.dto.PaymentResponse;
import com.shaik.entity.PaymentEntity;
import com.shaik.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public PaymentResponse getPaymentDetails(PaymentRequest paymentRequest){

        PaymentEntity paymentEntity = paymentRepository.getPaymentDetails(paymentRequest);
        PaymentResponse paymentResponse = mapModelToResponseDto(paymentEntity);
        return  paymentResponse;
    }

    private PaymentResponse mapModelToResponseDto(PaymentEntity paymentEntity){

        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setPaymentId(paymentEntity.getCardId());
        paymentResponse.setAmount(paymentEntity.getPaymentAmount());
        paymentResponse.setCurrency(paymentEntity.getPaymentCurrency());
        paymentResponse.setEmail(paymentEntity.getUserEmail());
        return paymentResponse;
    }
}
