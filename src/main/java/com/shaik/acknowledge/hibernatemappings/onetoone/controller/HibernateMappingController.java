package com.shaik.acknowledge.hibernatemappings.onetoone.controller;

import com.shaik.acknowledge.hibernatemappings.onetoone.domain.MemberAddress;
import com.shaik.acknowledge.hibernatemappings.onetoone.service.MemberAddressService;
import com.shaik.acknowledge.hibernatemappings.onetoone.domain.MemberDetails;
import com.shaik.acknowledge.hibernatemappings.onetoone.service.MemberDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hibernate-mapping")
public class HibernateMappingController {

    @Autowired
    private MemberDetailsService memberDetailsService;

    @Autowired
    private MemberAddressService memberAddressService;

    @GetMapping("get-one-to-one-uni/{id}")
    public MemberDetails getMemberDetailsById(@PathVariable Integer id) {

        return memberDetailsService.getMemberDetailsById(id);
    }

    @PostMapping("save-one-to-one-uni")
    public String executeRequest(@RequestBody MemberDetails memberDetails){

        memberDetailsService.saveMemberDetails(memberDetails);
        return "object saved successfully.";
    }

    @DeleteMapping("delete-one-to-one-uni/{id}")
    public String deleteMemberDetails(@PathVariable Integer id) {
        memberDetailsService.deleteMemberDetails(id);
        return "object deleted successfully.";
    }

    @GetMapping("get-one-to-one-bi/{id}")
    public MemberAddress getMemberAddressById(@PathVariable Integer id) {

        MemberAddress memberAddress = memberAddressService.getMemberAddressById(id);
        //when we use @JsonBackReference then memberDetails will not be formatted to JSON but we can fetch like below and do further operations
        MemberDetails memberDetails = memberAddress.getMemberDetails();

        return memberAddress;
    }
}
