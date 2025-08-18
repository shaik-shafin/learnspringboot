package com.shaik.acknowledge.docker.service;

import com.shaik.acknowledge.docker.DTO.CustomerDetailsDTO;
import com.shaik.acknowledge.docker.domain.CustomerDetails;
import com.shaik.acknowledge.docker.repository.CustomerDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerDetailsService {

    @Autowired
    private CustomerDetailsRepository customerDetailsRepository;

    public List<CustomerDetailsDTO> getAllCustomers(){

        var userDetailsList = customerDetailsRepository.findAll();
        return Optional.ofNullable(userDetailsList)
                .map(customerDetails ->
                        customerDetails.stream()
                                .map(ud -> convertCustomerDetailsToDTO(ud))
                                .toList())
                .orElse(new ArrayList<>(0));
    }

    public CustomerDetailsDTO getCustomerDetails(Integer id){

        if(id == null)
            return new CustomerDetailsDTO();

        return customerDetailsRepository.findById(id)
                .map(ud -> convertCustomerDetailsToDTO(ud))
                .orElse(new CustomerDetailsDTO());
    }

    public boolean saveCustomerDetails(CustomerDetailsDTO customerDetailsDTO){
        if(customerDetailsDTO == null)
            return false;

        var customerDetails = convertDTOtoUserDetails(customerDetailsDTO);
        if(customerDetails == null)
            return false;
        customerDetailsRepository.save(customerDetails);

        return true;
    }

    public boolean updateCustomerDetails(Integer id, CustomerDetailsDTO customerDetailsDTO){
        if(id == null || customerDetailsDTO == null)
            return false;

        var userDetails = customerDetailsRepository.findById(id);
        userDetails.ifPresent(ud -> {
            ud.setName(customerDetailsDTO.name());
            ud.setPhoneNumber(customerDetailsDTO.phoneNumber());
            ud.setEmail(customerDetailsDTO.email());
            customerDetailsRepository.save(ud);
        });

        return true;
    }

    public boolean deleteCustomerDetails(Integer id){
        if(id == null)
            return false;

        customerDetailsRepository.deleteById(id);
        return true;
    }

    private CustomerDetailsDTO convertCustomerDetailsToDTO(CustomerDetails customerDetails){

           return new CustomerDetailsDTO(customerDetails.getId(), customerDetails.getName(),
                    customerDetails.getPhoneNumber(), customerDetails.getEmail());
    }

    private CustomerDetails convertDTOtoUserDetails(CustomerDetailsDTO customerDetailsDTO){

        if(customerDetailsDTO == null)
            return null;

        var customerDetails = new CustomerDetails();
        customerDetails.setName(customerDetailsDTO.name());
        customerDetails.setPhoneNumber(customerDetailsDTO.phoneNumber());
        customerDetails.setEmail(customerDetailsDTO.email());
        return customerDetails;
    }


}
