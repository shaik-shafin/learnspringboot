package com.shaik.acknowledge.events.handler;

import com.shaik.acknowledge.events.PatientDischargeEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MedicalRecordsServiceHandler {

    @Async
    @EventListener
    public void updatePatientRecords(PatientDischargeEvent patientDischargeEvent) {
        System.out.println("3. Updating Patient Medical Records for Patient : " + patientDischargeEvent.getPatientName() + "Thread Name : " + Thread.currentThread().getName());
    }
}
