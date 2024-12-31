package com.eazybytes.account.Service;

import com.eazybytes.account.DTO.CustomerDto;

import java.util.List;

public interface IAccountService {
    void createAccount(CustomerDto dto);

    CustomerDto getCustomerDetails(String mobileNumber);

    boolean updateAccount(CustomerDto dto);

    boolean deleteAccount(String mobileNumber);

    List getAllCustomers();
}
