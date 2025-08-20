package com.shaik.acknowledge.Junit.service;

import com.shaik.acknowledge.Junit.DTO.CandidateDetailsDTO;
import com.shaik.acknowledge.Junit.domain.CandidateDetails;
import com.shaik.acknowledge.Junit.repository.CandidateDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CandidateDetailsService {

    private CandidateDetailsRepository candidateDetailsRepository;

    @Autowired
    public CandidateDetailsService(CandidateDetailsRepository candidateDetailsRepository){
        this.candidateDetailsRepository = candidateDetailsRepository;
    }

    public List<CandidateDetailsDTO> getAll(){
        var allList = candidateDetailsRepository.findAll();

        return Optional.ofNullable(allList)
                .map(list -> list.stream().peek(cd -> convertToDTO(cd)).toList())
                .orElse(new ArrayList());
    }

    public CandidateDetails save(CandidateDetails candidateDetails){
        return candidateDetailsRepository.save(candidateDetails);
    }

    private CandidateDetailsDTO convertToDTO(CandidateDetails candidateDetails){

        var candidateDetailsDTO = new CandidateDetailsDTO();
        candidateDetailsDTO.setId(candidateDetails.getId());
        candidateDetailsDTO.setName(candidateDetails.getName());
        candidateDetailsDTO.setEmail(candidateDetails.getEmail());
        candidateDetailsDTO.setPhone(candidateDetails.getPhone());
        return  candidateDetailsDTO;
    }

}
