package com.eazybytes.account.Service.Imps;

import com.eazybytes.account.DTO.AccountDto;
import com.eazybytes.account.DTO.CardsDto;
import com.eazybytes.account.DTO.CustomerDetailsDto;
import com.eazybytes.account.DTO.LoansDto;
import com.eazybytes.account.Entity.account;
import com.eazybytes.account.Entity.customer;
import com.eazybytes.account.Exception.ResourceNotFoundException;
import com.eazybytes.account.Mapper.AccountMapper;
import com.eazybytes.account.Mapper.CustomerMapper;
import com.eazybytes.account.Repository.AccountRepository;
import com.eazybytes.account.Repository.CustomerRepository;
import com.eazybytes.account.Service.ICustomerDetails;
import com.eazybytes.account.client.CardsFeignClient;
import com.eazybytes.account.client.LoansFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerDetailsServiceImpl implements ICustomerDetails {
    private final AccountRepository accountRepository;
    private  final CustomerRepository customerRepository;
    private final  CardsFeignClient cardsFeignClient;
    private  final LoansFeignClient loansFeignClient;

    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber) {
        // Fetch customer and account data
        customer customer = customerRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));

        account account = accountRepository.findByCustomerId(customer.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString()));

        // Map customer and account details
        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountDto(AccountMapper.mapToAccountsDto(account, new AccountDto()));

        // Fetch loan details
        try {
            ResponseEntity<LoansDto> loansResponse = loansFeignClient.fetchLoanDetails(mobileNumber);
            customerDetailsDto.setLoansDto(loansResponse.getBody());
        } catch (Exception e) {
            System.out.println("Loans service is unavailable: " + e.getMessage());
            customerDetailsDto.setLoansDto(new LoansDto()); // Default fallback behavior
        }

        // Fetch card details
        try {
            ResponseEntity<CardsDto> cardsResponse = cardsFeignClient.getCardsDetails(mobileNumber);
            customerDetailsDto.setCardsDto(cardsResponse.getBody());
        } catch (Exception e) {
            System.out.println("Cards service is unavailable: " + e.getMessage());
            customerDetailsDto.setCardsDto(new CardsDto()); // Default fallback behavior
        }

        return customerDetailsDto;
    }




    }

