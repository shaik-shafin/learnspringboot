package com.shaik.acknowledge.Junit.repository;

import com.shaik.acknowledge.Junit.domain.CandidateDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateDetailsRepository extends JpaRepository<CandidateDetails, Integer> {
}
