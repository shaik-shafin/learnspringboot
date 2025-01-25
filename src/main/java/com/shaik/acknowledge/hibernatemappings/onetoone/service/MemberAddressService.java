package com.shaik.acknowledge.hibernatemappings.onetoone.service;

import com.shaik.acknowledge.hibernatemappings.onetoone.domain.MemberAddress;
import com.shaik.acknowledge.hibernatemappings.onetoone.repository.MemberAddressRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberAddressService {

    @Autowired
    private MemberAddressRespository memberAddressRespository;

    public MemberAddress getMemberAddressById(Integer id) {

        return memberAddressRespository.findById(id).orElse(null);
    }
}
