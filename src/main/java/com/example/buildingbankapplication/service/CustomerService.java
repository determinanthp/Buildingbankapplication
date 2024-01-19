package com.example.buildingbankapplication.service;

import com.example.buildingbankapplication.response.BankResponse;
import com.example.buildingbankapplication.dto.CustomerRequest;
import com.example.buildingbankapplication.dto.EnquiryRequest;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService{

    BankResponse createAccount(CustomerRequest customerRequest);

    BankResponse balanceEnquiry(EnquiryRequest request);

    String nameEnquiry(EnquiryRequest request);
}

