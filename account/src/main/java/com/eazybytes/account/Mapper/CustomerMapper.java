package com.eazybytes.account.Mapper;

import com.eazybytes.account.DTO.CustomerDetailsDto;
import com.eazybytes.account.DTO.CustomerDto;
import com.eazybytes.account.Entity.customer;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
public class CustomerMapper {


    public static CustomerDto mapToCustomerDto(customer customer, CustomerDto customerDto) {
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setMobileNumber(customer.getMobileNumber());
        return customerDto;
    }
    public static CustomerDetailsDto mapToCustomerDto(customer customer, CustomerDetailsDto customerDetailsDto) {
        customerDetailsDto.setName(customer.getName());
        customerDetailsDto.setEmail(customer.getEmail());
        customerDetailsDto.setMobileNumber(customer.getMobileNumber());
        return customerDetailsDto;
    }
    public static customer mapToCustomer(CustomerDetailsDto customerDto, customer customer) {
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());
        return customer;
    }

    public static customer mapToCustomer(CustomerDto customerDto, customer customer) {
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());
        return customer;
    }
}