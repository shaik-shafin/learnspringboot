package com.shaik.acknowledge.hibernatemappings.onetoone.service;

import com.shaik.acknowledge.hibernatemappings.onetoone.domain.MemberDetails;
import com.shaik.acknowledge.hibernatemappings.onetoone.repository.MemberDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberDetailsService {

    @Autowired
    private MemberDetailsRepository memberDetailsRepository;

    public void saveMemberDetails(MemberDetails memberDetails){
        memberDetailsRepository.save(memberDetails);
    }

    public MemberDetails getMemberDetailsById(Integer id){
        return memberDetailsRepository.findById(id).orElse(null);
    }

    public void deleteMemberDetails(Integer id) {
        memberDetailsRepository.deleteById(id);
    }
}
