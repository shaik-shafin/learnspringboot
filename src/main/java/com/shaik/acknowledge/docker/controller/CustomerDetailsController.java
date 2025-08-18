package com.shaik.acknowledge.docker.controller;

import com.shaik.acknowledge.docker.DTO.CustomerDetailsDTO;
import com.shaik.acknowledge.docker.service.CustomerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerDetailsController {

    private final CustomerDetailsService customerDetailsService;

    @Autowired
    public CustomerDetailsController(CustomerDetailsService customerDetailsService){
        this.customerDetailsService = customerDetailsService;
    }

    @GetMapping("all")
    public ResponseEntity<List<CustomerDetailsDTO>> getAllCustomers(){

        var allUsers = customerDetailsService.getAllCustomers();
        return ResponseEntity.ok(allUsers);
    }

    @GetMapping("{id}")
    public ResponseEntity getCustomerDetails(@PathVariable Integer id){

        var customerDetails = customerDetailsService.getCustomerDetails(id);
        return ResponseEntity.ok(customerDetails);
    }

    @PostMapping("save")
    public ResponseEntity saveCustomerDetails(@RequestBody CustomerDetailsDTO customerDetailsDTO){

        var isCustomerDetailsSaved = customerDetailsService.saveCustomerDetails(customerDetailsDTO);
        if(isCustomerDetailsSaved){
            return ResponseEntity.ok("Customer Details saved successfully.");
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("{id}")
    public ResponseEntity updateCustomerDetails(@PathVariable Integer id, @RequestBody CustomerDetailsDTO customerDetailsDTO){

        var isCustomerDetailsUpdated = customerDetailsService.updateCustomerDetails(id, customerDetailsDTO);
        if(isCustomerDetailsUpdated){
            return ResponseEntity.ok("Customer Details updated successfully.");
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteCustomerDetails(@PathVariable Integer id){

        var isCustomerDetailsDeleted = customerDetailsService.deleteCustomerDetails(id);
        if(isCustomerDetailsDeleted){
            return ResponseEntity.ok("Customer Details deleted successfully.");
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

}
