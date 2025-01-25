package com.shaik.acknowledge.hibernatemappings.onetoone.repository;

import com.shaik.acknowledge.hibernatemappings.onetoone.domain.MemberDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDetailsRepository extends JpaRepository<MemberDetails, Integer> {
}
