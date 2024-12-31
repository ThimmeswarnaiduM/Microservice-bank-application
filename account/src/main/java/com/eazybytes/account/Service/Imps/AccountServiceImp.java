package com.eazybytes.account.Service.Imps;

import com.eazybytes.account.Constants.AccountConstant;
import com.eazybytes.account.DTO.AccountDto;
import com.eazybytes.account.DTO.CustomerDto;
import com.eazybytes.account.Entity.account;
import com.eazybytes.account.Entity.customer;
import com.eazybytes.account.Exception.CustomerAlreadyExistsException;
import com.eazybytes.account.Exception.ResourceNotFoundException;
import com.eazybytes.account.Mapper.AccountMapper;
import com.eazybytes.account.Mapper.CustomerMapper;
import com.eazybytes.account.Repository.AccountRepository;
import com.eazybytes.account.Repository.CustomerRepository;
import com.eazybytes.account.Service.IAccountService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class AccountServiceImp implements IAccountService {
    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    private final ObjectMapper objectMapper;
    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImp.class);

    @Override

    public void createAccount(CustomerDto dto) {
        if (dto == null || dto.getMobileNumber() == null) {
            throw new IllegalArgumentException("Customer DTO or mobile number cannot be null");
        }

        customer entity = CustomerMapper.mapToCustomer(dto, new customer());
        Optional<customer> existingCustomer = customerRepository.findByMobileNumber(dto.getMobileNumber());

        if (existingCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer already registered with given mobile number " + dto.getMobileNumber());
        }

        customer savedCustomer = customerRepository.save(entity);
        accountRepository.save(createNewAccount(savedCustomer));

        // Send the message to the queue after account creation

    }



    @Override
    public CustomerDto getCustomerDetails(String mobileNumber) {
        customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));

        account account = accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString()));
            CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
            customerDto.setAccountDto(AccountMapper.mapToAccountsDto(account, new AccountDto()));
        return customerDto;
    }

    @Override
    public boolean updateAccount(CustomerDto dto) {
        boolean isUpdated = false;
        AccountDto accountDto=dto.getAccountDto();
        if (accountDto!=null){
            account account = accountRepository.findById(Long.valueOf(accountDto.getAccountNumber())).orElseThrow(
                    () -> new ResourceNotFoundException("Account", "accountNumber", accountDto.getAccountNumber()));
            AccountMapper.mapToAccounts(accountDto, account);
            accountRepository.save(account);

            Long customerId = account.getCustomerId();
            customer customer = customerRepository.findById(customerId).orElseThrow(
                    () -> new ResourceNotFoundException("Customer", "customerId", customerId.toString()));
            CustomerMapper.mapToCustomer(dto, customer);
            customerRepository.save(customer);
            isUpdated = true;


        }

        return isUpdated;
    }

    @Override
    public boolean deleteAccount(String mobileNumber) {
        customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );

        accountRepository.deleteByCustomerId(customer.getCustomerId());
        customerRepository.deleteById(customer.getCustomerId());

        return true;
    }

    @Override
    public List getAllCustomers() {
        Stream<CustomerDto> customerDtoStream = customerRepository.findAll().stream().map(
                customer -> CustomerMapper.mapToCustomerDto(customer, new CustomerDto()));
        Stream<AccountDto> accountDtoStream = accountRepository.findAll().stream().map(account -> AccountMapper.mapToAccountsDto(account, new AccountDto()));

        return customerDtoStream.toList();

    }




    private account createNewAccount(customer customer) {
        account account = new account();
        account.setCustomerId(customer.getCustomerId());

        // Ensure MIN_ACCOUNT_NUMBER is the lower limit for the account number
        final long MIN_ACCOUNT_NUMBER = 10000000000L; // 10 billion
        final long MAX_ACCOUNT_NUMBER = 99999999999L; // 99 billion

        Random random = new Random();

        // Generate a random long within the specified range
        long accountNumber = MIN_ACCOUNT_NUMBER + (long)(random.nextDouble() * (MAX_ACCOUNT_NUMBER - MIN_ACCOUNT_NUMBER));

        // Set the generated account number
        account.setAccountNumber(String.valueOf(accountNumber));

        // Set the account type and branch address
        account.setAccountType(AccountConstant.SAVINGS);
        account.setBranchAddress(AccountConstant.ADDRESS);

        return account;
    }

}
