package com.shaik.acknowledge.events.service;

import com.shaik.acknowledge.events.PatientDischargeEvent;
import com.shaik.acknowledge.events.handler.BillingServiceHandler;
import com.shaik.acknowledge.events.handler.HouseKeepingServiceHandler;
import com.shaik.acknowledge.events.handler.MedicalRecordsServiceHandler;
import com.shaik.acknowledge.events.handler.NotificationServiceHandler;
import com.shaik.acknowledge.events.util.PatientDischargeReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.logging.LogManager;
import java.util.logging.Logger;


@Service
public class PatientDischargeService {

    private BillingServiceHandler billingServiceHandler;

    private HouseKeepingServiceHandler houseKeepingServiceHandler;

    private MedicalRecordsServiceHandler medicalRecordsServiceHandler;

    private NotificationServiceHandler notificationServiceHandler;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public PatientDischargeService(BillingServiceHandler billingServiceHandler, HouseKeepingServiceHandler houseKeepingServiceHandler,
            MedicalRecordsServiceHandler medicalRecordsServiceHandler, NotificationServiceHandler notificationServiceHandler) {
        this.billingServiceHandler = billingServiceHandler;
        this.houseKeepingServiceHandler = houseKeepingServiceHandler;
        this.medicalRecordsServiceHandler = medicalRecordsServiceHandler;
        this.notificationServiceHandler = notificationServiceHandler;
    }

    public String dischargePatient(PatientDischargeReq patientDischargeReq) {

        System.out.println("Discharge Patient initiated: " + patientDischargeReq.getPatientName());

        /*
        ---------------------------------------
                COMMON APPROACH
        ---------------------------------------
        billingServiceHandler.processBill();
        houseKeepingServiceHandler.cleanAndAssign();
        medicalRecordsServiceHandler.updatePatientRecords();
        notificationServiceHandler.notifyPatient();

        disadvantage:
        1. Tight coupling
        2. difficult to extend
        3. Testing and maintaining difficult
        4. Lack of asynchronous processing

        */


        applicationEventPublisher.publishEvent(new PatientDischargeEvent(this, patientDischargeReq.getPatientId(), patientDischargeReq.getPatientName()));


        System.out.println("Discharge Patient completed: " + patientDischargeReq.getPatientName());

        return "Discharge Patient : " + patientDischargeReq.getPatientName();
    }

}
