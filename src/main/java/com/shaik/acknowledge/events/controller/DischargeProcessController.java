package com.shaik.acknowledge.events.controller;

import com.shaik.acknowledge.events.service.PatientDischargeService;
import com.shaik.acknowledge.events.util.PatientDischargeReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/discharge")
public class DischargeProcessController {

    @Autowired
    private PatientDischargeService patientDischargeService;

    @PostMapping("patient")
    public String getDischargeDetails(@RequestBody PatientDischargeReq patientDischargeReq){

        return patientDischargeService.dischargePatient(patientDischargeReq);
    }
}
