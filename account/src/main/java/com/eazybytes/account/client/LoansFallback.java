package com.eazybytes.account.client;

import com.eazybytes.account.DTO.LoansDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class LoansFallback implements LoansFeignClient {

    @Override
    public ResponseEntity<LoansDto> fetchLoanDetails(String mobileNumber) {

        return null;
    }
}