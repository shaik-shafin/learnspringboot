package com.shaik.acknowledge.events.handler;

import com.shaik.acknowledge.events.PatientDischargeEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class HouseKeepingServiceHandler {

    @Async
    @EventListener
    public void cleanAndAssign(PatientDischargeEvent patientDischargeEvent) {
        System.out.println("2. Cleaning and Assigning after patient discharge :" + patientDischargeEvent.getPatientName() + "Thread Name : " + Thread.currentThread().getName());
    }
}
