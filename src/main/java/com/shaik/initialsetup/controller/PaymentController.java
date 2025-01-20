package com.shaik.initialsetup.controller;

import com.shaik.initialsetup.dto.PaymentRequest;
import com.shaik.initialsetup.dto.PaymentResponse;
import com.shaik.initialsetup.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("{id}")
    public ResponseEntity<PaymentResponse> getPaymentDetails(@PathVariable Integer id){

        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setPaymentId(id);

        PaymentResponse paymentResponse = paymentService.getPaymentDetails(paymentRequest);

        return ResponseEntity.ok(paymentResponse);
    }
}
