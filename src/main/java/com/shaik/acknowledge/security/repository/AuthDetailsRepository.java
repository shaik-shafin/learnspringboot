package com.shaik.acknowledge.security.repository;

import com.shaik.acknowledge.security.domain.AuthDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthDetailsRepository extends JpaRepository<AuthDetails, Integer> {

    AuthDetails findByAuthName(String authName);
}
