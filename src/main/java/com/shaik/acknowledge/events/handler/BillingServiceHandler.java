package com.shaik.acknowledge.events.handler;

import com.shaik.acknowledge.events.PatientDischargeEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class BillingServiceHandler {

    @Async
    @EventListener
    public void processBill(PatientDischargeEvent patientDischargeEvent) {
        System.out.println("1. Processing Bill for :" + patientDischargeEvent.getPatientName() + "Thread Name : " + Thread.currentThread().getName());
    }
}
