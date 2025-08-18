package com.shaik.acknowledge.docker.repository;

import com.shaik.acknowledge.docker.domain.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, Integer> {
}
