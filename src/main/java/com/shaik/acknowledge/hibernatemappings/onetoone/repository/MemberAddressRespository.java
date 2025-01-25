package com.shaik.acknowledge.hibernatemappings.onetoone.repository;

import com.shaik.acknowledge.hibernatemappings.onetoone.domain.MemberAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberAddressRespository extends JpaRepository<MemberAddress, Integer> {
}
