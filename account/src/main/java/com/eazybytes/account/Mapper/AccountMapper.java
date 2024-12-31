package com.eazybytes.account.Mapper;

import com.eazybytes.account.DTO.AccountDto;
import com.eazybytes.account.Entity.account;


import org.springframework.beans.factory.annotation.Autowired;

public class AccountMapper {

    public static AccountDto mapToAccountsDto(account accounts, AccountDto accountsDto) {
        accountsDto.setAccountNumber(accounts.getAccountNumber());
        accountsDto.setAccountType(accounts.getAccountType());
        accountsDto.setBranchAddress(accounts.getBranchAddress());

        return accountsDto;
    }

    public static account mapToAccounts(AccountDto accountsDto, account accounts) {
        accounts.setAccountNumber(accountsDto.getAccountNumber());
        accounts.setAccountType(accountsDto.getAccountType());
        accounts.setBranchAddress(accountsDto.getBranchAddress());
        return accounts;
    }
}
