package com.shaik.springboot.Junit.service;

import com.shaik.acknowledge.Junit.domain.CandidateDetails;
import com.shaik.acknowledge.Junit.repository.CandidateDetailsRepository;
import com.shaik.acknowledge.Junit.service.CandidateDetailsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * @ExtendWith annotation is required when you make use of @Mock annotation
 * **/
@ExtendWith(MockitoExtension.class)
public class CandidateDetailsServiceTest {

    /**
     * @Mock annotation will create and mock object (dummy object)
     * **/
    @Mock
    CandidateDetailsRepository candidateDetailsRepository;

    /**
     * @InjectMocks annotation is used for mock the object (dummy object).
     * Along with that It will inject required dependency that presence in current class.
     * **/
    @InjectMocks
    CandidateDetailsService candidateDetailsService;

    /**
     * @Test first step to take the testing and which required
     * **/
    @Test
    void saveSuccessfully(){
        var candidateDetails = new CandidateDetails();
        candidateDetails.setId(1);
        candidateDetails.setName("shaik shafin");
        candidateDetails.setEmail("shaik.shafin@netlocal.tv");

        /**
         * when you do when() inside operation then the thenReturn() inside code return
         * which is like mocking the particular operation
         * **/
        Mockito.when(candidateDetailsService.save(candidateDetails)).thenReturn(candidateDetails);

        var savedCandidateDetails = candidateDetailsService.save(candidateDetails);

        /**
         * Assertions used to test the expected value and actual value
         * **/
        Assertions.assertNotNull(savedCandidateDetails);
        Assertions.assertEquals(candidateDetails.getId(), savedCandidateDetails.getId());
        Assertions.assertEquals(candidateDetails.getName(), savedCandidateDetails.getName());
        Assertions.assertEquals(candidateDetails.getEmail(), savedCandidateDetails.getEmail());
        Assertions.assertTrue(candidateDetails.equals(savedCandidateDetails));
    }
}
