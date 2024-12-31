package com.eazybytes.Loans.Service;


import com.eazybytes.Loans.Dto.LoansDto;

public interface ILoansService {


    void createLoan(String mobileNumber);


    LoansDto fetchLoan(String mobileNumber);


    boolean updateLoan(LoansDto loansDto);


    boolean deleteLoan(String mobileNumber);

}
