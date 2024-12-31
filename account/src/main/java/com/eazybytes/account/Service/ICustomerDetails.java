package com.eazybytes.account.Service;

import com.eazybytes.account.DTO.CustomerDetailsDto;

public interface ICustomerDetails {

    CustomerDetailsDto fetchCustomerDetails(  String mobileNumber);
}
