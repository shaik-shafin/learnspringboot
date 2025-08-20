package com.shaik.acknowledge.Junit.controller;

import com.shaik.acknowledge.Junit.DTO.CandidateDetailsDTO;
import com.shaik.acknowledge.Junit.domain.CandidateDetails;
import com.shaik.acknowledge.Junit.service.CandidateDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CandidateController {

    @Autowired
    private CandidateDetailsService candidateDetailsService;

    @GetMapping
    public ResponseEntity<List<CandidateDetailsDTO>> getAllCandidates(){
        var allList = candidateDetailsService.getAll();
        return ResponseEntity.ok(allList);
    }
}
