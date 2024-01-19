package com.example.buildingbankapplication.service.impl;

import com.example.buildingbankapplication.response.AccountInfo;
import com.example.buildingbankapplication.response.BankResponse;
import com.example.buildingbankapplication.dto.CustomerRequest;
import com.example.buildingbankapplication.dto.EnquiryRequest;
import com.example.buildingbankapplication.entity.Customer;
import com.example.buildingbankapplication.repository.CustomerRepository;
import com.example.buildingbankapplication.service.CustomerService;
import com.example.buildingbankapplication.utils.AccountUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public BankResponse createAccount(CustomerRequest customerRequest) {

        /**
         * Creating an account = saving a new customer into the db
         * Check if customer already has an account
         */
        if (customerRepository.existsByEmail(customerRequest.getEmail())) {
            return BankResponse.builder()
                    .responseCode(AccountUtils.ACCOUNT_EXISTS_CODE)
                    .responseMessage(AccountUtils.ACCOUNT_EXISTS_MESSAGE)
                    .accountInfo(null)
                    .build();
        }
        Customer customer = Customer.builder()
                .firstName(customerRequest.getFirstName())
                .lastName(customerRequest.getLastName())
                .otherName(customerRequest.getOtherName())
                .gender(customerRequest.getGender())
                .address(customerRequest.getAddress())
                .stateOfOrigin(customerRequest.getStateOfOrigin())
                .accountNumber(AccountUtils.generateAccountNumber())
                .accountBalance(BigDecimal.ZERO)
                .email(customerRequest.getEmail())
                .phoneNumber(customerRequest.getPhoneNumber())
                .alternativePhoneNumber(customerRequest.getAlternativePhoneNumber())
                .status("ACTIVE")
                .build();

        Customer savedCustomer = customerRepository.save(new Customer());
        return BankResponse.builder()
                .responseCode(AccountUtils.ACCOUNT_CREATION_SUCCESS)
                .responseMessage(AccountUtils.ACCOUNT_CREATION_MESSAGE)
                .accountInfo(AccountInfo.builder()
                        .accountBalance(savedCustomer.getAccountBalance())
                        .accountNumber(savedCustomer.getAccountNumber())
                        .accountName(savedCustomer.getFirstName() + " " + savedCustomer.getLastName() + " " + savedCustomer.getOtherName())
                        .build())
                .build();
    }

    @Override
    public BankResponse balanceEnquiry(EnquiryRequest request) {

        //check if the provided account number exists in the db

        boolean isAccountExist = customerRepository.existsByAccountBalance(request.getAccountBalance());
        if (!isAccountExist) {
            return BankResponse.builder()
                    .responseCode(AccountUtils.ACCOUNT_NOT_EXIST_CODE)
                    .responseMessage(AccountUtils.ACCOUNT_NOT_EXIST_MESSAGE)
                    .accountInfo(null)
                    .build();
        }

        Customer foundCustomer = customerRepository.findByAccountNumber(request.getAccountNumber());
        return BankResponse.builder()
                .responseCode(AccountUtils.ACCOUNT_FOUND_CODE)
                .responseMessage(AccountUtils.ACCOUNT_FOUND_SUCCESS)
                .accountInfo(null)
                .accountBalance(foundCustomer.getAccountBalance())
                .accountNumber(request.getAccountNumber())
                .accountName(foundCustomer.getFirstName() + "" + foundCustomer.getLastName() + "" + foundCustomer.getOtherName())
                .build();
    }

    @Override
    public String nameEnquiry(EnquiryRequest request) {
        boolean isAccountExist = customerRepository.existsByAccountBalance(request.getAccountBalance());
        if (!isAccountExist) {
            return AccountUtils.ACCOUNT_NOT_EXIST_MESSAGE;
        }
        Customer foundCustomer = customerRepository.findByAccountNumber(request.getAccountNumber());
        return foundCustomer.getFirstName() + " " + foundCustomer.getLastName() + " " + foundCustomer.getOtherName();

        // balance Enquiry, name Enquiry, credit, debit, transfer, Reverse amount if transaction not successful.
    }
}