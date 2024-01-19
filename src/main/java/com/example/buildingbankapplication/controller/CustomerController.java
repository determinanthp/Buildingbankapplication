package com.example.buildingbankapplication.controller;

import com.example.buildingbankapplication.response.BankResponse;
import com.example.buildingbankapplication.dto.CustomerRequest;
import com.example.buildingbankapplication.dto.EnquiryRequest;
import com.example.buildingbankapplication.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public BankResponse createAccount(@RequestBody CustomerRequest customerRequest){
        return customerService.createAccount(customerRequest);
    }
      @GetMapping
      public BankResponse balanceEnquiry(@PathVariable ("id") Long id, @RequestBody EnquiryRequest request){
        return customerService.balanceEnquiry(request);
      }
}
